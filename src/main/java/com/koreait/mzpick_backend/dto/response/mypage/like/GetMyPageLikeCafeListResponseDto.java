package com.koreait.mzpick_backend.dto.response.mypage.like;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.like.MyPageLikeCafe;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageLikeCafeListResponseDto extends ResponseDto {
    
     
   private List<MyPageLikeCafe> myPageLikeCafes;

    private GetMyPageLikeCafeListResponseDto(List<MyPageLikeCafe> myPageLikeCafes) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageLikeCafes = myPageLikeCafes;
    }

    public static ResponseEntity<GetMyPageLikeCafeListResponseDto> success(List<MyPageLikeCafe> myPageLikeCafes) {
        GetMyPageLikeCafeListResponseDto responseBody = new GetMyPageLikeCafeListResponseDto(myPageLikeCafes);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
