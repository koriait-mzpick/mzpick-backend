package com.koreait.mzpick_backend.service.vote;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.vote.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.vote.GetMyPageVoteTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetTravelVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetTravelVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetTravelVoteTotalCountResponseDto;

//service 여행 관련 투표 서비스 //
public interface TravelVoteService {

    ResponseEntity<? super GetTravelVoteListResponseDto> getTravelVoteList();

    ResponseEntity<? super GetTravelVoteDetailResponseDto> getTravelVote(Integer travelVoteNumber);

    ResponseEntity<ResponseDto> postTravelVote(PostTravelVoteRequestDto dto, String userId);

    ResponseEntity<ResponseDto> deleteTravelVote(Integer travelVoteNumber, String userId);

    ResponseEntity<ResponseDto> clickVote(Integer selectNumber, Integer travelVoteNumber, String userId);

    ResponseEntity<? super GetTravelVoteTotalCountResponseDto> totalVote(Integer travelVoteNumber);

    ResponseEntity<? super GetMyPageVoteTravelListResponseDto> myPageVoteTravelList(String userId);
}
