package com.koreait.mzpick_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.keyword.PostKeywordWriteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.keyword.GetKeywordListResponseDto;
import com.koreait.mzpick_backend.service.keyword.KeywordService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
// REST API 컨트롤러 지정 //
@RestController
// API 경로 지정 //
@RequestMapping("/api/v1/keyword")
// 의존성 주입을 위한 어노테이션 //
@RequiredArgsConstructor
public class KeywordController {
    
    // KeywordService 의존성 주입 //
    private final KeywordService keywordService;

    // 키워드 목록 조회 메서드 //
    @GetMapping(value={"", "/"})
    public ResponseEntity<? super GetKeywordListResponseDto> getKeyword() {
        ResponseEntity<? super GetKeywordListResponseDto> response = keywordService.getKeyword();
        return response;
    }

    // 키워드 작성 메서드 //
    @PostMapping("/write")
    public ResponseEntity<ResponseDto> postKeyword(
        @RequestBody @Valid PostKeywordWriteRequestDto dto,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = keywordService.postKeyword(dto, userId);
        return response;
    }
}
