package com.koreait.mzpick_backend.dto.response.mypage.like;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.like.MyPageLikeFashion;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageLikeFashionListResponseDto extends ResponseDto {
    
    private List<MyPageLikeFashion> myPageLikeFashions;

    private GetMyPageLikeFashionListResponseDto(List<MyPageLikeFashion> myPageLikeFashions) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageLikeFashions = myPageLikeFashions;
    }

    public static ResponseEntity<GetMyPageLikeFashionListResponseDto> success(List<MyPageLikeFashion> myPageLikeFashions) {
        GetMyPageLikeFashionListResponseDto responseBody = new GetMyPageLikeFashionListResponseDto(myPageLikeFashions);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }


    
}
