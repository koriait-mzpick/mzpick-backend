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

import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelCommentListResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelTotalCountResponsDto;
import com.koreait.mzpick_backend.service.travel.TravelCommentService;
import com.koreait.mzpick_backend.service.travel.TravelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel")
@RequiredArgsConstructor
public class TravelController {
    private final TravelService travelService;
    private final TravelCommentService travelCommentService;

    // controller 여행게시판 리스트 불러오기//
    @GetMapping(value = { "", "/" })
    public ResponseEntity<? super GetTravelListResponseDto> getTravelList(@RequestParam("page") Integer page) {
        ResponseEntity<? super GetTravelListResponseDto> resposne = travelService.getTravelList(page);
        return resposne;
    }

    // controller 해당 여행 게시판 불러오기//
    @GetMapping("/{travelNumber}")
    public ResponseEntity<? super GetTravelDetailResponseDto> getTravel(
            @PathVariable("travelNumber") Integer travelNumber) {
        ResponseEntity<? super GetTravelDetailResponseDto> resposne = travelService.getTravel(travelNumber);
        return resposne;
    }

    @GetMapping("/totalCount")
    public ResponseEntity<? super GetTravelTotalCountResponsDto> getTravelTotalCount(){
        ResponseEntity<? super GetTravelTotalCountResponsDto> response = travelService.travelTotalCount();
        return response;
    }
    

    // controller 여행 게시판 작성하기 //
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postTravel(
            @RequestBody @Valid PostTravelRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = travelService.postTravel(requestBody, userId);
        return resposne;
    }

    // controller 해당 여행 게시판 삭제하기 //
    @DeleteMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> deleteTravel(
            @PathVariable("travelNumber") Integer travelNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelService.deleteTravel(travelNumber, userId);
        return response;
    }

    // controller 해당 여행 게시판 수정하기 //
    @PatchMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> patchTravel(
            @RequestBody @Valid PatchTravelRequestDto requestBody,
            @PathVariable("travelNumber") Integer travelNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelService.patchTravel(requestBody, travelNumber, userId);
        return response;
    }

    // controller 해당 여행 게시판 조회수 증가 시키기 //
    @PostMapping("/view/{travelNumber}")
    public ResponseEntity<ResponseDto> upTravelViewCount(
            @PathVariable("travelNumber") Integer travelNumber) {
        ResponseEntity<ResponseDto> response = travelService.upTravelViewCount(travelNumber);
        return response;
    }

    // controller 해당 게시판 여행 댓글 리스트 불러오기 //
    @GetMapping("/comment/{travelNumber}")
    public ResponseEntity<? super GetTravelCommentListResponseDto> getTravelCommentList(
            @PathVariable("travelNumber") Integer travelNumber) {
        ResponseEntity<? super GetTravelCommentListResponseDto> response = travelCommentService
                .getTravelCommentList(travelNumber);
        return response;
    }

    // controller 해당 게시판 여행 댓글 입력하기 //
    @PostMapping("/comment/{travelNumber}")
    public ResponseEntity<ResponseDto> postComment(
            @RequestBody @Valid PostTravelCommentRequestDto requestBody,
            @PathVariable("travelNumber") Integer travelNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelCommentService.postTravelComment(requestBody, travelNumber,
                userId);
        return response;
    }

    // controller 해당 게시판 여행 댓글 삭제하기 //
    @DeleteMapping("/comment/{travelCommentNumber}")
    public ResponseEntity<ResponseDto> deleteComment(
            @PathVariable("travelCommentNumber") Integer travelCommentNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelCommentService.deleteTravelComment(travelCommentNumber, userId);
        return response;
    }

    // controller 해당 여행 게시판 좋아요 버튼 (클릭 / 클릭 해제) //
    @PutMapping("/like/{travelNumber}")
    public ResponseEntity<ResponseDto> putLike(
            @PathVariable("travelNumber") Integer travelNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelService.putLike(travelNumber, userId);
        return response;
    }

    // controller 여행 게시판 저장 (저장 / 저장 취소) //
    @PutMapping("/save/{travelNumber}")
    public ResponseEntity<ResponseDto> putSave(
            @PathVariable("travelNumber") Integer travelNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelService.putSave(travelNumber, userId);
        return response;
    }


}
