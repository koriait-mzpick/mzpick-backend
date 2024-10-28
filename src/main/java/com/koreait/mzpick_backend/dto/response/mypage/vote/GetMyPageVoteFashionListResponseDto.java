package com.koreait.mzpick_backend.dto.response.mypage.vote;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.vote.MyPageVoteFashion;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.vote.FashionVoteEntity;

import lombok.Getter;

@Getter
public class GetMyPageVoteFashionListResponseDto extends ResponseDto {
    
   private List<MyPageVoteFashion> myPageVoteFashions;

    private GetMyPageVoteFashionListResponseDto(List<FashionVoteEntity> fashionVoteEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageVoteFashions = MyPageVoteFashion.getMyPageVoteFashionList(fashionVoteEntities);
    }

    public static ResponseEntity<GetMyPageVoteFashionListResponseDto> success(List<FashionVoteEntity> fashionVoteEntities) {
        GetMyPageVoteFashionListResponseDto responseBody = new GetMyPageVoteFashionListResponseDto(fashionVoteEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
