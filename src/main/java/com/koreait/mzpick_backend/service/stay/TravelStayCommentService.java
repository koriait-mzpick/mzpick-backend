package com.koreait.mzpick_backend.service.stay;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayCommentListResponseDto;


//service 여행지 댓글 서비스 //
public interface TravelStayCommentService {
    ResponseEntity<? super GetTravelStayCommentListResponseDto> getTravelStayCommentList(Integer travelStayNumber);

    ResponseEntity<ResponseDto> postTravelStayComment(PostTravelStayCommentRequestDto dto, Integer travelStayNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelStayComment(Integer travelStayCommentNumber, String userId);
}
