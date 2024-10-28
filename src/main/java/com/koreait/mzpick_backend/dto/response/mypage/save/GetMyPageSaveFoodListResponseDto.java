package com.koreait.mzpick_backend.dto.response.mypage.save;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.save.MyPageSaveFood;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageSaveFoodListResponseDto extends ResponseDto {

    List<MyPageSaveFood> myPageSaveFoods;

    private GetMyPageSaveFoodListResponseDto(List<MyPageSaveFood> myPageSaveFoods) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageSaveFoods = myPageSaveFoods;
    }

    public static ResponseEntity<GetMyPageSaveFoodListResponseDto> success(List<MyPageSaveFood> myPageSaveFoods) {
        GetMyPageSaveFoodListResponseDto responseBody = new GetMyPageSaveFoodListResponseDto(myPageSaveFoods);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
