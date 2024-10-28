package com.koreait.mzpick_backend.dto.response.vote;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.vote.TravelVote;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

//responseDto 여행 관련 투표 게시글 상세보기 //
@Getter
public class GetTravelVoteDetailResponseDto extends ResponseDto {
    private TravelVote travelVote;

    private GetTravelVoteDetailResponseDto(TravelVote travelVote) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelVote = travelVote;
        
    }

    public static ResponseEntity<GetTravelVoteDetailResponseDto> success(TravelVote travelVote) {
        GetTravelVoteDetailResponseDto responseBody = new GetTravelVoteDetailResponseDto(travelVote);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
