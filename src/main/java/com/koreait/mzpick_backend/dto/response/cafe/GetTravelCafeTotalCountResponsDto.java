package com.koreait.mzpick_backend.dto.response.cafe;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetTravelCafeTotalCountResponsDto extends ResponseDto{
    private Long count;

    private GetTravelCafeTotalCountResponsDto(Long count){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.count = count;
    }

    public static ResponseEntity<GetTravelCafeTotalCountResponsDto> success(long count){
        GetTravelCafeTotalCountResponsDto responseBody = new GetTravelCafeTotalCountResponsDto(count);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}