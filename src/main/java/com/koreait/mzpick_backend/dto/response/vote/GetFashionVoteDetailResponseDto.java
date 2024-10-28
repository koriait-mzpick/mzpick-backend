package com.koreait.mzpick_backend.dto.response.vote;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.vote.FashionVote;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

//responseDto 여행 관련 투표 게시글 상세보기 //
@Getter
public class GetFashionVoteDetailResponseDto extends ResponseDto {
    private FashionVote FashionVote;

    private GetFashionVoteDetailResponseDto(FashionVote FashionVote) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.FashionVote = FashionVote;
        
    }

    public static ResponseEntity<GetFashionVoteDetailResponseDto> success(FashionVote FashionVote) {
        GetFashionVoteDetailResponseDto responseBody = new GetFashionVoteDetailResponseDto(FashionVote);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
