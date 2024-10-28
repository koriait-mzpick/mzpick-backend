package com.koreait.mzpick_backend.dto.response.mypage.vote;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.vote.MyPageVoteTravel;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.vote.TravelVoteEntity;

import lombok.Getter;

@Getter
public class GetMyPageVoteTravelListResponseDto extends ResponseDto {
    
   private List<MyPageVoteTravel> myPageVoteTravels;

    private GetMyPageVoteTravelListResponseDto(List<TravelVoteEntity> travelVoteEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageVoteTravels = MyPageVoteTravel.getMyPageVoteTravleList(travelVoteEntities);
    }

    public static ResponseEntity<GetMyPageVoteTravelListResponseDto> success(List<TravelVoteEntity> travelVoteEntities) {
        GetMyPageVoteTravelListResponseDto responseBody = new GetMyPageVoteTravelListResponseDto(travelVoteEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    
}
