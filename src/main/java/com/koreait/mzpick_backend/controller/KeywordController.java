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

@RestController
@RequestMapping("/api/v1/keyword")
@RequiredArgsConstructor
public class KeywordController {
    
    private final KeywordService keywordService;

    @GetMapping(value={"", "/"})
    public ResponseEntity<? super GetKeywordListResponseDto> getKeyword() {
        ResponseEntity<? super GetKeywordListResponseDto> response = keywordService.getKeyword();
        return response;
    }

    @PostMapping("/write")
    public ResponseEntity<ResponseDto> postKeyword(
        @RequestBody @Valid PostKeywordWriteRequestDto dto,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = keywordService.postKeyword(dto, userId);
        return response;
    }
}
