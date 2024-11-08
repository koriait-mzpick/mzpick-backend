
package com.koreait.mzpick_backend.dto.response.cafe;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetTravelCafeSaveResponseDto extends ResponseDto {
    private Integer cafeNumber;
    private List<String> userIdList;

    public GetTravelCafeSaveResponseDto(Integer cafeNumber, List<String> userIdList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.cafeNumber = cafeNumber;
        this.userIdList = userIdList;
    }
    public static ResponseEntity<GetTravelCafeSaveResponseDto> success(Integer cafeNumber, List<String> userIdList) {
        GetTravelCafeSaveResponseDto responseBody = new GetTravelCafeSaveResponseDto(cafeNumber, userIdList);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
