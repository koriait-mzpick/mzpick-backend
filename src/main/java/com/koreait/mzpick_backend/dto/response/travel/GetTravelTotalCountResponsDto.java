package com.koreait.mzpick_backend.dto.response.travel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetTravelTotalCountResponsDto extends ResponseDto{
    private Long count;

    private GetTravelTotalCountResponsDto(Long count){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.count = count;
    }

    public static ResponseEntity<GetTravelTotalCountResponsDto> success(long count){
        GetTravelTotalCountResponsDto responseBody = new GetTravelTotalCountResponsDto(count);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}