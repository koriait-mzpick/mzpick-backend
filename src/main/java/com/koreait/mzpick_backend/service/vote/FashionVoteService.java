package com.koreait.mzpick_backend.service.vote;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.vote.PostFashionlVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.vote.GetMyPageVoteFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetFashionVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetFashionVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetFashionVoteTotalCountResponseDto;

public interface FashionVoteService {
    ResponseEntity<? super GetFashionVoteListResponseDto> getFashionVoteList();
    ResponseEntity<? super GetFashionVoteDetailResponseDto> getFashionVote(Integer fashionVoteNumber);
    ResponseEntity<ResponseDto> postFashionVote(PostFashionlVoteRequestDto dto, String userId);
    ResponseEntity<ResponseDto> deleteFashionVote(Integer fashionVoteNumber, String userId);
    ResponseEntity<ResponseDto> clickVote(Integer selectNumber, Integer fashionVoteNumber, String userId);
    ResponseEntity<? super GetFashionVoteTotalCountResponseDto> totalVote(Integer fashionVoteNumber);

    ResponseEntity<? super GetMyPageVoteFashionListResponseDto> myPageVoteFashionList(String userId);
   
}
