package com.koreait.mzpick_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.vote.PostFashionlVoteRequestDto;
import com.koreait.mzpick_backend.dto.request.vote.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetFashionVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetFashionVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetFashionVoteTotalCountResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetTravelVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetTravelVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetTravelVoteTotalCountResponseDto;
import com.koreait.mzpick_backend.service.vote.FashionVoteService;
import com.koreait.mzpick_backend.service.vote.TravelVoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/vote")
@RequiredArgsConstructor
public class voteController {

    private final TravelVoteService travelVoteService;
    private final FashionVoteService fashionVoteService;

    //----------------------------------여행------------------------------------//
    // controller 여행 관련 투표 리스트 불러오기 //
    @GetMapping(value = { "/travel", "/travel/" })
    public ResponseEntity<? super GetTravelVoteListResponseDto> getTravelVoteList() {
        ResponseEntity<? super GetTravelVoteListResponseDto> response = travelVoteService.getTravelVoteList();
        return response;
    }

    // controller 해당 여행 관련 투표 게시글 불러오기 //
    @GetMapping("/travel/{travelVoteNumber}")
    public ResponseEntity<? super GetTravelVoteDetailResponseDto> getTravelVote(
            @PathVariable("travelVoteNumber") Integer travelVoteNumber) {
        ResponseEntity<? super GetTravelVoteDetailResponseDto> response = travelVoteService
                .getTravelVote(travelVoteNumber);
        return response;
    }

    // controller 여행 관련 투표 게시글 작성하기
    @PostMapping(value = { "/travel", "/travel/" })
    public ResponseEntity<ResponseDto> postTravelVote(
            @RequestBody @Valid PostTravelVoteRequestDto dto,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelVoteService.postTravelVote(dto, userId);
        return response;
    }

    // controller 해당 여행 게시판 투표 클릭 (투표하기 / 투표취소) //
    @PutMapping("/travel/vote-click/{travelVoteNumber}/{selectNumber}")
    public ResponseEntity<ResponseDto> putVoteClick(
            @PathVariable("travelVoteNumber") Integer travelVoteNumber,
            @PathVariable("selectNumber") Integer selectNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelVoteService.clickVote(selectNumber, travelVoteNumber, userId);
        return response;
    }

    // controller 해당 여행 투표 관련 게시판 삭제하기 //
    @DeleteMapping("/travel/{travelVoteNumber}")
    public ResponseEntity<ResponseDto> deleteTravelVote(
            @PathVariable("travelVoteNumber") Integer travelVoteNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelVoteService.deleteTravelVote(travelVoteNumber, userId);
        return response;
    }

    @GetMapping("/travel/vote-total")
    public ResponseEntity<? super GetTravelVoteTotalCountResponseDto> totalTravelVote(
            @RequestParam("travelVoteNumber") Integer travelVoteNumber) {
        ResponseEntity<? super GetTravelVoteTotalCountResponseDto> response = travelVoteService
                .totalVote(travelVoteNumber);
        return response;
    }
//------------------------------------패션--------------------------------------//
    @GetMapping(value = { "/fashion", "/fashion/" })
    public ResponseEntity<? super GetFashionVoteListResponseDto> getFashionVoteList() {
        ResponseEntity<? super GetFashionVoteListResponseDto> response = fashionVoteService.getFashionVoteList();
        return response;
    }

    @GetMapping("/fashion/{fashionVoteNumber}")
    public ResponseEntity<? super GetFashionVoteDetailResponseDto> getFashionVote(
            @PathVariable("fashionVoteNumber") Integer fashionVoteNumber) {
        ResponseEntity<? super GetFashionVoteDetailResponseDto> response = fashionVoteService.getFashionVote(fashionVoteNumber);
        return response;
    }

    @PostMapping(value = { "/fashion", "/fashion/" })
    public ResponseEntity<ResponseDto> postFashionVote(
            @RequestBody @Valid PostFashionlVoteRequestDto dto,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionVoteService.postFashionVote(dto, userId);
        return response;
    }

    @DeleteMapping("/fashion/{fashionVoteNumber}")
    public ResponseEntity<ResponseDto> deleteFashionVote(
            @PathVariable("fashionVoteNumber") Integer fashionVoteNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionVoteService.deleteFashionVote(fashionVoteNumber, userId);
        return response;
    }

    @PutMapping("/fashion/vote-click/{fashionVoteNumber}/{selectNumber}")
    public ResponseEntity<ResponseDto> putclickVote(
            @PathVariable("fashionVoteNumber") Integer fashionVoteNumber,
            @PathVariable("selectNumber") Integer selectNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionVoteService.clickVote(selectNumber,fashionVoteNumber, userId);
        return response;
    }

    @GetMapping("/fashion/vote-total")
    public ResponseEntity<? super GetFashionVoteTotalCountResponseDto> totalFashionVote(
            @RequestParam("fashionVoteNumber") Integer fashionVoteNumber
    ){
        ResponseEntity<? super GetFashionVoteTotalCountResponseDto> response = fashionVoteService.totalVote(fashionVoteNumber);
        return response;
    }

}
