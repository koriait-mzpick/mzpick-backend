package com.koreait.mzpick_backend.service.auth;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.auth.IdCheckRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.SignInRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.SignUpRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.TelAuthCheckRequestDto;
import com.koreait.mzpick_backend.dto.request.auth.TelAuthRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import  com.koreait.mzpick_backend.dto.response.auth.SignInResponseDto;


public interface AuthService {
    ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<ResponseDto> telAuth(TelAuthRequestDto dto);
    ResponseEntity<ResponseDto> telAuthCheck(TelAuthCheckRequestDto dto);
    ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
