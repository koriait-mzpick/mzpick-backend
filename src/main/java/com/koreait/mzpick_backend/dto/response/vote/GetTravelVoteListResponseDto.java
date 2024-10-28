package com.koreait.mzpick_backend.dto.response.vote;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.vote.TravelVote;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

//responseDto 여행 관련 투표 리스트 불러오기 //
@Getter
public class GetTravelVoteListResponseDto extends ResponseDto {
    private List<TravelVote> travelVotes;

    private GetTravelVoteListResponseDto(List<TravelVote> travelVotes) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelVotes = travelVotes;
    }

    public static ResponseEntity<GetTravelVoteListResponseDto> success(List<TravelVote> travelVotes) {
        GetTravelVoteListResponseDto responseBody = new GetTravelVoteListResponseDto(travelVotes);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
