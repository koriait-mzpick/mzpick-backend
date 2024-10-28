package com.koreait.mzpick_backend.service.food;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodCommentListResponseDto;


//service 여행지 댓글 서비스 //
public interface TravelFoodCommentService {
    ResponseEntity<? super GetTravelFoodCommentListResponseDto> getTravelFoodCommentList(Integer travelFoodNumber);

    ResponseEntity<ResponseDto> postTravelFoodComment(PostTravelFoodCommentRequestDto dto, Integer travelFoodNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelFoodComment(Integer travelFoodCommentNumber, String userId);
}
