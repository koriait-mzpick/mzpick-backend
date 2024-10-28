package com.koreait.mzpick_backend.dto.response.vote;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.vote.FashionVote;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

//responseDto 여행 관련 투표 리스트 불러오기 //
@Getter
public class GetFashionVoteListResponseDto extends ResponseDto {
    private List<FashionVote> FashionVotes;

    private GetFashionVoteListResponseDto(List<FashionVote> FashionVotes) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.FashionVotes = FashionVotes;
    }

    public static ResponseEntity<GetFashionVoteListResponseDto> success(List<FashionVote> FashionVotes) {
        GetFashionVoteListResponseDto responseBody = new GetFashionVoteListResponseDto(FashionVotes);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
