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
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionLikeResponeDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionSaveResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionTotalCountResponsDto;
import com.koreait.mzpick_backend.service.fashion.FashionCommentService;
import com.koreait.mzpick_backend.service.fashion.FashionService;
import com.koreait.mzpick_backend.service.vote.FashionVoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// REST API 컨트롤러 지정 //
@RestController
// API 경로 지정 //
@RequestMapping("/api/v1/fashion")
// 의존성 주입을 위한 어노테이션 //
@RequiredArgsConstructor
public class FashionController {
    // FashionService 의존성 주입 //
    private final FashionService fashionService;
    // FashionCommentService 의존성 주입 //
    private final FashionCommentService fashionCommentService;
    // FashionVoteService 의존성 주입 //
    private final FashionVoteService fashionVoteService;
    

    // 패션 게시글 목록 조회 메서드 //
    @GetMapping(value = { "", "/" })
    public ResponseEntity<? super GetFashionListResponseDto> getFashionList(
        @RequestParam("page") Integer page,
        @RequestParam(name="hashtag",defaultValue="") String hashtag
        ) {
        ResponseEntity<? super GetFashionListResponseDto> resposne = fashionService.getFashionList(page, hashtag);
        return resposne;
    }

    // 패션 게시글 상세 조회 메서드 //
    @GetMapping("/{fashionNumber}")
    public ResponseEntity<? super GetFashionDetailResponseDto> getFashion(
            @PathVariable("fashionNumber") Integer fashionNumber) {
        ResponseEntity<? super GetFashionDetailResponseDto> resposne = fashionService.getFashion(fashionNumber);
        return resposne;
    }

    // 패션 게시글 전체 수 조회 메서드 //
    @GetMapping("/totalCount")
    public ResponseEntity<? super GetFashionTotalCountResponsDto> getFashionTotalCount(){
        ResponseEntity<? super GetFashionTotalCountResponsDto> response = fashionService.getFashionTotalCount();
        return response;
    }
    

    // 패션 게시글 작성 메서드 //
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postFashion(
            @RequestBody @Valid PostFashionRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = fashionService.postFashion(requestBody, userId);
        return resposne;
    }

    // 패션 게시글 삭제 메서드 //
    @DeleteMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> deleteFashion(
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionService.deleteFashion(fashionNumber, userId);
        return response;
    }

    // 패션 게시글 수정 메서드 //
    @PatchMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> patchFashion(
            @RequestBody @Valid PatchFashionRequestDto requestBody,
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionService.patchFashion(requestBody, fashionNumber, userId);
        return response;
    }

    // 패션 게시글 조회수 증가 메서드 //
    @PostMapping("/view/{fashionNumber}")
    public ResponseEntity<ResponseDto> upFashionViewCount(
            @PathVariable("fashionNumber") Integer fashionNumber) {
        ResponseEntity<ResponseDto> response = fashionService.upFashionViewCount(fashionNumber);
        return response;
    }

    // 패션 게시글 댓글 목록 조회 메서드 //
    @GetMapping("/comment/{fashionNumber}")
    public ResponseEntity<? super GetFashionCommentListResponseDto> getFashionComment(
            @PathVariable("fashionNumber") Integer fashionNumber) {
        ResponseEntity<? super GetFashionCommentListResponseDto> response = fashionCommentService.getFashionCommentList(fashionNumber);
        return response;
    }

    // 패션 게시글 댓글 작성 메서드 //
    @PostMapping("/comment/{fashionNumber}")
    public ResponseEntity<ResponseDto> postFashionComment(
            @RequestBody @Valid PostFashionCommentRequestDto requestBody,
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionCommentService.postFashionComment(requestBody, fashionNumber, userId);
        return response;
    }

    // 패션 게시글 댓글 삭제 메서드 //
    @DeleteMapping("/comment/{fashionCommentNumber}")
    public ResponseEntity<ResponseDto> deleteComment(
            @PathVariable("fashionCommentNumber") Integer fashionCommentNumber,
            @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = fashionCommentService.deleteFashionComment(fashionCommentNumber, userId);
        return response;
    }

    // 패션 게시글 좋아요 수 조회 메서드 //
    @GetMapping("/like/{fashionNumber}")
    public ResponseEntity<? super GetFashionLikeResponeDto> getLike(
            @PathVariable("fashionNumber") Integer fashionNumber){
        ResponseEntity<? super GetFashionLikeResponeDto> response = fashionService.getLike(fashionNumber);
        return response;
    }

    // 패션 게시글 좋아요 토글 메서드 //
    @PutMapping("/like/{fashionNumber}")
    public ResponseEntity<ResponseDto> putLike(
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionService.putLike(fashionNumber, userId);
        return response;
    }
    
    // 패션 게시글 저장 수 조회 메서드 //
    @GetMapping("/save/{fashionNumber}")
    public ResponseEntity<? super GetFashionSaveResponseDto> getSave(
            @PathVariable("fashionNumber") Integer fashionNumber){
        ResponseEntity<? super GetFashionSaveResponseDto> response = fashionService.getSave(fashionNumber);
        return response;
    }

    // 패션 게시글 저장 토글 메서드 //
    @PutMapping("/save/{fashionNumber}")
    public ResponseEntity<ResponseDto> putSave(
        @PathVariable("fashionNumber")Integer fashionNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = fashionService.putSave(fashionNumber, userId);
        return response;
    }

}
