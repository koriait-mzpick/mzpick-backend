package com.koreait.mzpick_backend.dto.response.mypage.save;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.save.MyPageSaveCafe;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

public class GetMyPageSaveCafeListResponseDto extends ResponseDto{
    
    List<MyPageSaveCafe> myPageSaveCafes;

    private GetMyPageSaveCafeListResponseDto(List<MyPageSaveCafe> myPageSaveCafes) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageSaveCafes = myPageSaveCafes;
    }

    public static ResponseEntity<GetMyPageSaveCafeListResponseDto> success(List<MyPageSaveCafe> myPageSaveCafes) {
        GetMyPageSaveCafeListResponseDto responseBody = new GetMyPageSaveCafeListResponseDto(myPageSaveCafes);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
