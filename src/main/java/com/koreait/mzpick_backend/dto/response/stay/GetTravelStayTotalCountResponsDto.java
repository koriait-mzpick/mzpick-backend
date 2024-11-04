package com.koreait.mzpick_backend.dto.response.stay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetTravelStayTotalCountResponsDto extends ResponseDto{
    private Long count;

    private GetTravelStayTotalCountResponsDto(Long count){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.count = count;
    }

    public static ResponseEntity<GetTravelStayTotalCountResponsDto> success(long count){
        GetTravelStayTotalCountResponsDto responseBody = new GetTravelStayTotalCountResponsDto(count);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}