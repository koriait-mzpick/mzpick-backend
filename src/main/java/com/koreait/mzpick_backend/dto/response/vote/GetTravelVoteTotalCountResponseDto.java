package com.koreait.mzpick_backend.dto.response.vote;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.travel.resultSet.GetTravelVoteResultSet;

import lombok.Getter;

@Getter
public class GetTravelVoteTotalCountResponseDto extends ResponseDto {
    private List<GetTravelVoteResultSet> resultSets;

    private GetTravelVoteTotalCountResponseDto(List<GetTravelVoteResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.resultSets = resultSets;
    }

    public static ResponseEntity<GetTravelVoteTotalCountResponseDto> success(List<GetTravelVoteResultSet> resultSets) {
        GetTravelVoteTotalCountResponseDto responseBody = new GetTravelVoteTotalCountResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
