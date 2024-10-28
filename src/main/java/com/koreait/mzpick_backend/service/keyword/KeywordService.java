package com.koreait.mzpick_backend.service.keyword;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.keyword.PostKeywordWriteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.keyword.GetKeywordListResponseDto;

public interface KeywordService {
    
    ResponseEntity<? super GetKeywordListResponseDto> getKeyword();
    ResponseEntity<ResponseDto> postKeyword(PostKeywordWriteRequestDto dto, String userId);
}
