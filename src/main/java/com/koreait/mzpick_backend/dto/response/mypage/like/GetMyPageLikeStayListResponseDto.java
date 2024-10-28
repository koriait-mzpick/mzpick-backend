package com.koreait.mzpick_backend.dto.response.mypage.like;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.like.MyPageLikeStay;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageLikeStayListResponseDto extends ResponseDto {
    
   private List<MyPageLikeStay>  myPageLikeStays;

    private GetMyPageLikeStayListResponseDto(List<MyPageLikeStay> myPageLikeStays) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageLikeStays = myPageLikeStays;
    }

    public static ResponseEntity<GetMyPageLikeStayListResponseDto> success(List<MyPageLikeStay> myPageLikeStays) {
        GetMyPageLikeStayListResponseDto responseBody = new GetMyPageLikeStayListResponseDto(myPageLikeStays);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    
}
