package com.koreait.mzpick_backend.dto.response.mypage.save;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.save.MyPageSaveTravel;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageSaveTravelListResponseDto extends ResponseDto {
    List<MyPageSaveTravel> myPageSaveTravel;

    private GetMyPageSaveTravelListResponseDto(List<MyPageSaveTravel> myPageSaveTravels) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageSaveTravel = myPageSaveTravels;
    }

    public static ResponseEntity<GetMyPageSaveTravelListResponseDto> success(List<MyPageSaveTravel> myPageSaveTravels){
        GetMyPageSaveTravelListResponseDto responseBody = new GetMyPageSaveTravelListResponseDto(myPageSaveTravels);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
