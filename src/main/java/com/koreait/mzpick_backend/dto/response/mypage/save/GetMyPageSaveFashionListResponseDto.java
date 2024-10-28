package com.koreait.mzpick_backend.dto.response.mypage.save;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.save.MyPageSaveFashion;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageSaveFashionListResponseDto extends ResponseDto {

    List<MyPageSaveFashion> myPageSaveFashions;

    private GetMyPageSaveFashionListResponseDto(List<MyPageSaveFashion> myPageSaveFashions) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageSaveFashions = myPageSaveFashions;
    }

    public static ResponseEntity<GetMyPageSaveFashionListResponseDto> success(List<MyPageSaveFashion> myPageSaveFashions) {
        GetMyPageSaveFashionListResponseDto responseBody = new GetMyPageSaveFashionListResponseDto(myPageSaveFashions);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
