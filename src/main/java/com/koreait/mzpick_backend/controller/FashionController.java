package com.koreait.mzpick_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.fashion.PatchFashionRequestDto;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionCommentRequestDto;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionCommentListResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionListResponseDto;
import com.koreait.mzpick_backend.service.fashion.FashionCommentService;
import com.koreait.mzpick_backend.service.fashion.FashionService;
import com.koreait.mzpick_backend.service.vote.FashionVoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fashion")
@RequiredArgsConstructor
public class FashionController {
    private final FashionService fashionService;
    private final FashionCommentService fashionCommentService;
    private final FashionVoteService fashionVoteService;
    

    @GetMapping(value = { "", "/" })
    public ResponseEntity<? super GetFashionListResponseDto> getFashionList(@RequestParam("page") Integer page) {
        ResponseEntity<? super GetFashionListResponseDto> resposne = fashionService.getFashionList(page);
        return resposne;
    }

    @GetMapping("/{fashionNumber}")
    public ResponseEntity<? super GetFashionDetailResponseDto> getFashion(
            @PathVariable("fashionNumber") Integer fashionNumber) {
        ResponseEntity<? super GetFashionDetailResponseDto> resposne = fashionService.getFashion(fashionNumber);
        return resposne;
    }

    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postFashion(
            @RequestBody @Valid PostFashionRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = fashionService.postFashion(requestBody, userId);
        return resposne;
    }

    @DeleteMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> deleteFashion(
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionService.deleteFashion(fashionNumber, userId);
        return response;
    }

    @PatchMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> patchFashion(
            @RequestBody @Valid PatchFashionRequestDto requestBody,
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionService.patchFashion(requestBody, fashionNumber, userId);
        return response;
    }

    @PostMapping("/view/{fashionNumber}")
    public ResponseEntity<ResponseDto> upFashionViewCount(
            @PathVariable("fashionNumber") Integer fashionNumber) {
        ResponseEntity<ResponseDto> response = fashionService.upFashionViewCount(fashionNumber);
        return response;
    }

        @GetMapping("/comment/{fashionNumber}")
    public ResponseEntity<? super GetFashionCommentListResponseDto> getFashionComment(
            @PathVariable("fashionNumber") Integer fashionNumber) {
        ResponseEntity<? super GetFashionCommentListResponseDto> response = fashionCommentService.getFashionCommentList(fashionNumber);
        return response;
    }

    @PostMapping("/comment/{fashionNumber}")
    public ResponseEntity<ResponseDto> postFashionComment(
            @RequestBody @Valid PostFashionCommentRequestDto requestBody,
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionCommentService.postFashionComment(requestBody, fashionNumber, userId);
        return response;
    }

    @DeleteMapping("/comment/{fashionCommentNumber}")
    public ResponseEntity<ResponseDto> deleteComment(
            @PathVariable("fashionCommentNumber") Integer fashionCommentNumber,
            @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = fashionCommentService.deleteFashionComment(fashionCommentNumber, userId);
        return response;
    }

    @PutMapping("/like/{fashionNumber}")
    public ResponseEntity<ResponseDto> putLike(
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionService.putLike(fashionNumber, userId);
        return response;
    }

    @PutMapping("/save/{fashionNumber}")
    public ResponseEntity<ResponseDto> postSave(
        @PathVariable("fashionNumber")Integer fashionNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = fashionService.putSave(fashionNumber, userId);
        return response;
    }

}
