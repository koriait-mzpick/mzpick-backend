package com.koreait.mzpick_backend.dto.response.food;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetTravelFoodTotalCountResponsDto extends ResponseDto{
    private Long count;

    private GetTravelFoodTotalCountResponsDto(Long count){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.count = count;
    }

    public static ResponseEntity<GetTravelFoodTotalCountResponsDto> success(long count){
        GetTravelFoodTotalCountResponsDto responseBody = new GetTravelFoodTotalCountResponsDto(count);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}