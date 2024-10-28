package com.koreait.mzpick_backend.service.implement.cafe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeCommentListResponseDto;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeCommentEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeCommentRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.cafe.TravelCafeCommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelCafeCommentServiceImplement implements TravelCafeCommentService {
    private final TravelCafeRepository travelCafeRepository;
    private final UserRepository userRepository;
    private final TravelCafeCommentRepository travelCafeCommentRepository;

    @Override
    public ResponseEntity<? super GetTravelCafeCommentListResponseDto> getTravelCafeCommentList(Integer travelCafeNumber) {
        List<TravelCafeCommentEntity>  travelCafeCommentEntities = new ArrayList<>();
        try {
            travelCafeCommentEntities = travelCafeCommentRepository.findByTravelCafeNumber(travelCafeNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelCafeCommentListResponseDto.success(travelCafeCommentEntities);
    }


    @Override
    public ResponseEntity<ResponseDto> postTravelCafeComment(PostTravelCafeCommentRequestDto dto, Integer travelCafeNumber,
            String userId) {
        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            TravelCafeCommentEntity travelCafeCommentEntity = new TravelCafeCommentEntity(dto, travelCafeNumber, userId);
            travelCafeCommentRepository.save(travelCafeCommentEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravelCafeComment(Integer travelCafeCommentNumber, String userId) {
        try {
            TravelCafeCommentEntity travelCafeCommentEntity = travelCafeCommentRepository.findByTravelCafeCommentNumber(travelCafeCommentNumber);
            if(travelCafeCommentEntity == null) return ResponseDto.noExistComment();

            String user = travelCafeCommentEntity.getUserId();
            boolean isUser = user.equals(userId);
            if(!isUser) return ResponseDto.noPermission();
            travelCafeCommentRepository.deleteByTravelCafeCommentNumber(travelCafeCommentNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
}
