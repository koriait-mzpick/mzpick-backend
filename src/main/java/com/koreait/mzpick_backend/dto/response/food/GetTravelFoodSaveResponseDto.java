package com.koreait.mzpick_backend.dto.response.food;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetTravelFoodSaveResponseDto extends ResponseDto{
    private Integer foodNumber;
    private List<String> userIdList;

    public GetTravelFoodSaveResponseDto(Integer foodNumber, List<String> userIdList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.foodNumber = foodNumber;
        this.userIdList = userIdList;
    }

    public static ResponseEntity<GetTravelFoodSaveResponseDto> success(Integer foodNumber, List<String> userIdList) {
        GetTravelFoodSaveResponseDto responseBody = new GetTravelFoodSaveResponseDto(foodNumber, userIdList);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
