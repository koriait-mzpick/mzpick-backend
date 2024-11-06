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

import com.koreait.mzpick_backend.dto.request.food.PatchTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodCommentRequestDto;
import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodCommentListResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodListResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodTotalCountResponsDto;
import com.koreait.mzpick_backend.service.food.TravelFoodCommentService;
import com.koreait.mzpick_backend.service.food.TravelFoodService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class TravelFoodController {

    private final TravelFoodService travelFoodService;

    private final TravelFoodCommentService travelFoodCommentService;



// controller 여행게시판 리스트 불러오기//
    @GetMapping(value = { "", "/" })
    public ResponseEntity<? super GetTravelFoodListResponseDto> getTravelFoodList(
        @RequestParam("page") Integer page,
        @RequestParam(name="searchLocation", defaultValue="") String searchLocation,
        @RequestParam(name="hashtag",defaultValue="") String hashtag 
        ) {
        ResponseEntity<? super GetTravelFoodListResponseDto> resposne = travelFoodService.getTravelFoodList(page ,searchLocation, hashtag);
        return resposne;
    }

    // controller 해당 여행 게시판 불러오기//
    @GetMapping("/{travelFoodNumber}")
    public ResponseEntity<? super GetTravelFoodDetailResponseDto> getTravel(
            @PathVariable("travelFoodNumber") Integer travelFoodNumber
            ) {
        ResponseEntity<? super GetTravelFoodDetailResponseDto> resposne = travelFoodService
                .getTravelFood(travelFoodNumber);
        return resposne;
    }

    @GetMapping("/totalCount")
    public ResponseEntity<? super GetTravelFoodTotalCountResponsDto> getTravelFoodTotalCount(){
        ResponseEntity<? super GetTravelFoodTotalCountResponsDto> response = travelFoodService.travelFoodTotalCount();
        return response;
    }

    // controller 여행 게시판 작성하기 //
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postTravelFood(
            @RequestBody @Valid PostTravelFoodRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = travelFoodService.postTravelFood(requestBody, userId);
        return resposne;
    }

    // controller 해당 여행 게시판 삭제하기 //
    @DeleteMapping("/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> deleteTravelFood(
            @PathVariable("travelFoodNumber") Integer travelFoodNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelFoodService.deleteTravelFood(travelFoodNumber, userId);
        return response;
    }

    // controller 해당 여행 게시판 수정하기 //
    @PatchMapping("/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> patchFoodTravel(
            @RequestBody @Valid PatchTravelFoodRequestDto requestBody,
            @PathVariable("travelFoodNumber") Integer travelFoodNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelFoodService.patchTravelFood(requestBody, travelFoodNumber, userId);
        return response;
    }

    // controller 해당 여행 게시판 조회수 증가 시키기 //
    @PostMapping("/view/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> upTravelViewCount(
            @PathVariable("travelFoodNumber") Integer travelFoodNumber) {
        ResponseEntity<ResponseDto> response = travelFoodService.upTravelFoodViewCount(travelFoodNumber);
        return response;
    }

    @PutMapping("/save/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> putSave(
            @PathVariable("travelFoodNumber") Integer travelFoodNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelFoodService.putSave(travelFoodNumber, userId);
        return response;
    }

    @PutMapping("/like/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> putLike(
        @PathVariable("travelFoodNumber") Integer travelFoodNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelFoodService.putLike(travelFoodNumber, userId);
        return response;
    }
    @GetMapping("/comment/{travelFoodNumber}")
    public ResponseEntity<? super GetTravelFoodCommentListResponseDto> getTravelFoodCommentList(
        @PathVariable("travelFoodNumber")Integer travelFoodNumber
    ) {
        ResponseEntity<? super GetTravelFoodCommentListResponseDto> response = travelFoodCommentService.getTravelFoodCommentList(travelFoodNumber);
        return response;
    }
    
    // controller 해당 게시판 여행 댓글 입력하기 //
    @PostMapping("/comment/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> postCommentFood(
        @RequestBody @Valid PostTravelFoodCommentRequestDto requestBody,
        @PathVariable("travelFoodNumber") Integer travelFoodNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelFoodCommentService.postTravelFoodComment(requestBody, travelFoodNumber, userId);
        return response;
    }

    // controller 해당 게시판 여행 댓글 삭제하기 //
    @DeleteMapping("/comment/{travelFoodCommentNumber}")
    public ResponseEntity<ResponseDto> deleteCommentFood(
        @PathVariable("travelFoodCommentNumber") Integer travelFoodCommentNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelFoodCommentService.deleteTravelFoodComment(travelFoodCommentNumber, userId);
        return response;
    }
    
}
