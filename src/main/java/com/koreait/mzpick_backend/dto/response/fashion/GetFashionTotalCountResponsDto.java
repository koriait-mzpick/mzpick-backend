package com.koreait.mzpick_backend.dto.response.fashion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetFashionTotalCountResponsDto extends ResponseDto{
    private Long count;

    private GetFashionTotalCountResponsDto(Long count){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.count = count;
    }

    public static ResponseEntity<GetFashionTotalCountResponsDto> success(long count){
        GetFashionTotalCountResponsDto responseBody = new GetFashionTotalCountResponsDto(count);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}