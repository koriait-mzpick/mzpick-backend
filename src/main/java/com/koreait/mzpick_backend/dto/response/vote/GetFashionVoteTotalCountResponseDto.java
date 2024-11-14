package com.koreait.mzpick_backend.dto.response.vote;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.vote.FashionVoteResult;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.fashion.resultSet.GetFashionVoteResultSet;
import com.koreait.mzpick_backend.entity.vote.FashionVoteResultEntity;

import lombok.Getter;

@Getter
public class GetFashionVoteTotalCountResponseDto extends ResponseDto {
    private List<FashionVoteResult> fashionVoteResults;

    private GetFashionVoteTotalCountResponseDto(List<FashionVoteResultEntity> fashionVoteResultEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.fashionVoteResults = FashionVoteResult.getList(fashionVoteResultEntities);
    }

    public static ResponseEntity<GetFashionVoteTotalCountResponseDto> success(List<FashionVoteResultEntity> fashionVoteResultEntities) {
        GetFashionVoteTotalCountResponseDto responseBody = new GetFashionVoteTotalCountResponseDto(fashionVoteResultEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
