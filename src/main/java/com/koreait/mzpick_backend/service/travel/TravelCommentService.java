package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelCommentListResponseDto;


//service 여행지 댓글 서비스 //
public interface TravelCommentService {
    ResponseEntity<? super GetTravelCommentListResponseDto> getTravelCommentList(Integer travelNumber);

    ResponseEntity<ResponseDto> postTravelComment(PostTravelCommentRequestDto dto, Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelComment(Integer travelCommentNumber, String userId);
}
