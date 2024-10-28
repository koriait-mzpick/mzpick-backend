package com.koreait.mzpick_backend.dto.response.mypage.save;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.save.MyPageSaveStay;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageSaveStayListResponseDto extends ResponseDto {
    List<MyPageSaveStay> myPageSaveStays;

    private GetMyPageSaveStayListResponseDto(List<MyPageSaveStay> myPageSaveStays) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageSaveStays = myPageSaveStays;
    }

    public static ResponseEntity<GetMyPageSaveStayListResponseDto> success(List<MyPageSaveStay> myPageSaveStays){
        GetMyPageSaveStayListResponseDto responseBody = new GetMyPageSaveStayListResponseDto(myPageSaveStays);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
