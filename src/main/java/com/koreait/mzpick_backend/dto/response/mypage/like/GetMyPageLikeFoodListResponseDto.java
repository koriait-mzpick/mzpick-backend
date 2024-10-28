package com.koreait.mzpick_backend.dto.response.mypage.like;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.like.MyPageLikeFood;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageLikeFoodListResponseDto extends ResponseDto {
    
   private List<MyPageLikeFood> myPageLikeFoods;

    private GetMyPageLikeFoodListResponseDto(List<MyPageLikeFood> myPageLikeFoods) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageLikeFoods = myPageLikeFoods;
    }

    public static ResponseEntity<GetMyPageLikeFoodListResponseDto> success(List<MyPageLikeFood> myPageLikeFoods) {
        GetMyPageLikeFoodListResponseDto responseBody = new GetMyPageLikeFoodListResponseDto(myPageLikeFoods);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
