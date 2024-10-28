package com.koreait.mzpick_backend.service.cafe;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeCommentListResponseDto;


//service 여행지 댓글 서비스 //
public interface TravelCafeCommentService {
    ResponseEntity<? super GetTravelCafeCommentListResponseDto> getTravelCafeCommentList(Integer travelCafeNumber);

    ResponseEntity<ResponseDto> postTravelCafeComment(PostTravelCafeCommentRequestDto dto, Integer travelCafeNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelCafeComment(Integer travelCafeCommentNumber, String userId);
}
