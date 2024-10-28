package com.koreait.mzpick_backend.service.implement.food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodCommentListResponseDto;
import com.koreait.mzpick_backend.entity.food.TravelFoodCommentEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.repository.food.TravelFoodCommentRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.food.TravelFoodCommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelFoodCommentServiceImplement implements TravelFoodCommentService {
    private final TravelFoodRepository travelFoodRepository;
    private final UserRepository userRepository;
    private final TravelFoodCommentRepository travelFoodCommentRepository;

    @Override
    public ResponseEntity<? super GetTravelFoodCommentListResponseDto> getTravelFoodCommentList(Integer travelFoodNumber) {
        List<TravelFoodCommentEntity>  travelFoodCommentEntities = new ArrayList<>();
        try {
            travelFoodCommentEntities = travelFoodCommentRepository.findByTravelFoodNumber(travelFoodNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelFoodCommentListResponseDto.success(travelFoodCommentEntities);
    }


    @Override
    public ResponseEntity<ResponseDto> postTravelFoodComment(PostTravelFoodCommentRequestDto dto, Integer travelFoodNumber,
            String userId) {
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            TravelFoodCommentEntity travelFoodCommentEntity = new TravelFoodCommentEntity(dto, travelFoodNumber, userId);
            travelFoodCommentRepository.save(travelFoodCommentEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravelFoodComment(Integer travelFoodCommentNumber, String userId) {
        try {
            TravelFoodCommentEntity travelFoodCommentEntity = travelFoodCommentRepository.findByTravelFoodCommentNumber(travelFoodCommentNumber);
            if(travelFoodCommentEntity == null) return ResponseDto.noExistComment();

            String user = travelFoodCommentEntity.getUserId();
            boolean isUser = user.equals(userId);
            if(!isUser) return ResponseDto.noPermission();
            travelFoodCommentRepository.deleteByTravelFoodCommentNumber(travelFoodCommentNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
}
