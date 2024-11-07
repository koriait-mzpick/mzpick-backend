package com.koreait.mzpick_backend.dto.response.fashion;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetFashionLikeResponeDto extends ResponseDto {
    private Integer fashionNumber;
    private List<String> userIdList;

    public GetFashionLikeResponeDto(Integer fashionNumber, List<String> userIdList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.fashionNumber = fashionNumber;
        this.userIdList = userIdList;
    }
    public static ResponseEntity<GetFashionLikeResponeDto> success(Integer fashionNumber, List<String> userIdList) {
        GetFashionLikeResponeDto responseBody = new GetFashionLikeResponeDto(fashionNumber, userIdList);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
