package com.koreait.mzpick_backend.dto.response.vote;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.vote.VoteResult;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.vote.TravelVoteResultEntity;

import lombok.Getter;

@Getter
public class GetTravelVoteTotalCountResponseDto extends ResponseDto {

    private List<VoteResult> voteResults;

    private GetTravelVoteTotalCountResponseDto(List<TravelVoteResultEntity> travelVoteResultEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.voteResults = VoteResult.getList(travelVoteResultEntities);
    }

    public static ResponseEntity<GetTravelVoteTotalCountResponseDto> success(List<TravelVoteResultEntity> travelVoteResultEntities) {
        GetTravelVoteTotalCountResponseDto responseBody = new GetTravelVoteTotalCountResponseDto(travelVoteResultEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
