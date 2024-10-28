package com.koreait.mzpick_backend.dto.response.vote;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.fashion.resultSet.GetFashionVoteResultSet;

import lombok.Getter;

@Getter
public class GetFashionVoteTotalCountResponseDto extends ResponseDto {
    private List<GetFashionVoteResultSet> resultSets;

    private GetFashionVoteTotalCountResponseDto(List<GetFashionVoteResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.resultSets = resultSets;
    }

    public static ResponseEntity<GetFashionVoteTotalCountResponseDto> success(List<GetFashionVoteResultSet> resultSets) {
        GetFashionVoteTotalCountResponseDto responseBody = new GetFashionVoteTotalCountResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
