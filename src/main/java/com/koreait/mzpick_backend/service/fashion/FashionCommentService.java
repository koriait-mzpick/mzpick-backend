package com.koreait.mzpick_backend.service.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.fashion.PostFashionCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionCommentListResponseDto;

public interface FashionCommentService {
    
    ResponseEntity<? super GetFashionCommentListResponseDto> getFashionCommentList(Integer fashionNumber);
    ResponseEntity<ResponseDto> postFashionComment(PostFashionCommentRequestDto dto,Integer fashionNumber, String userId);
    ResponseEntity<ResponseDto> deleteFashionComment(Integer fashionCommentNumber, String userId);
}
