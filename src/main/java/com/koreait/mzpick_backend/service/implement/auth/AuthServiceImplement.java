package com.koreait.mzpick_backend.service.implement.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.auth.IdCheckRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.SignInRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.SignUpRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.TelAuthCheckRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.TelAuthRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.auth.SignInResponseDto;
import com.koreait.mzpick_backend.entity.auth.TelAuthNumberEntity;
import com.koreait.mzpick_backend.entity.auth.UserEntity;
import com.koreait.mzpick_backend.provider.JwtProvider;
import com.koreait.mzpick_backend.provider.SmsProvider;
import com.koreait.mzpick_backend.repository.auth.TelAuthNumberRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.auth.AuthService;
import com.koreait.mzpick_backend.util.AuthNumberCreator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private final TelAuthNumberRepository telAuthNumberRepository;
    private final SmsProvider smsProvider;
    private final JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 아이디 중복확인
    @Override
    public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {

        String userId = dto.getUserId();
        try {

            boolean isExistedId = userRepository.existsByUserId(userId);
            if (isExistedId)
                return ResponseDto.duplicatedUserId();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }

    // 전화번호 인증
    @Override
    public ResponseEntity<ResponseDto> telAuth(TelAuthRequestDto dto) {

        String telNumber = dto.getTelNumber();
        try {
            boolean isExistedTelNumber = userRepository.existsByTelNumber(telNumber);
            if (isExistedTelNumber)
                return ResponseDto.duplicatedTelNumber();

            String authNumber = AuthNumberCreator.number6();

            boolean isSendSuccess = smsProvider.sendMessage(telNumber, authNumber);
            if (!isSendSuccess)
                return ResponseDto.messageSendFail();

            try {

                TelAuthNumberEntity telAuthNumberEntity = new TelAuthNumberEntity(telNumber, authNumber);
                telAuthNumberRepository.save(telAuthNumberEntity);

            } catch (Exception exception) {
                exception.printStackTrace();
                return ResponseDto.databaseError();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> telAuthCheck(TelAuthCheckRequestDto dto) {
        String telNumber = dto.getTelNumber();
        String authNumber = dto.getAuthNumber();

        try {

            boolean isMatched = telAuthNumberRepository.existsByTelNumberAndAuthNumber(telNumber, authNumber);
            if (!isMatched)
                return ResponseDto.telAuthFail();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
        String userId = dto.getUserId();
        String telNumber = dto.getTelNumber();
        String authNumber = dto.getAuthNumber();
        String password = dto.getPassword();

        try {

            boolean isExistedId = userRepository.existsByUserId(userId);
            if (isExistedId)
                return ResponseDto.duplicatedUserId();

            boolean isExistedTelNumber = userRepository.existsByTelNumber(telNumber);
            if (isExistedTelNumber)
                return ResponseDto.duplicatedTelNumber();

            boolean isMatched = telAuthNumberRepository.existsByTelNumberAndAuthNumber(telNumber, authNumber);
            if (!isMatched)
                return ResponseDto.telAuthFail();

            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        String userId = dto.getUserId();
        String password = dto.getPassword();

        String accessToken = null;

        try {

            UserEntity userEntity = userRepository.findByUserId(userId);
            if (userEntity == null)
                return ResponseDto.signInFail();

            String encodedPassword = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if (!isMatched)
                return ResponseDto.signInFail();

            accessToken = jwtProvider.create(userId);
            if (accessToken == null)
                return ResponseDto.tokenCreateFail();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignInResponseDto.success(accessToken);
    }

}
