package com.koreait.mzpick_backend.dto.response.mypage.like;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.like.MyPageLikeTravel;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageLikeTravelListResponseDto extends ResponseDto {
    
     
   private List<MyPageLikeTravel> myPageLikeTravels;

    private GetMyPageLikeTravelListResponseDto(List<MyPageLikeTravel> myPageLikeTravels) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageLikeTravels = myPageLikeTravels;
    }

    public static ResponseEntity<GetMyPageLikeTravelListResponseDto> success(List<MyPageLikeTravel> myPageLikeTravels) {
        GetMyPageLikeTravelListResponseDto responseBody = new GetMyPageLikeTravelListResponseDto(myPageLikeTravels);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
