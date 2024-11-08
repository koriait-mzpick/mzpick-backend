package com.koreait.mzpick_backend.dto.response.stay;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

public class GetTravelStaySaveResponseDto extends ResponseDto {
    private Integer stayNumber;
    private List<String> userIdList;

    public GetTravelStaySaveResponseDto(Integer stayNumber, List<String> userIdList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.stayNumber = stayNumber;
        this.userIdList = userIdList;
    }
    public static ResponseEntity<GetTravelStaySaveResponseDto> success(Integer stayNumber, List<String> userIdList) {
        GetTravelStaySaveResponseDto responseBody = new GetTravelStaySaveResponseDto(stayNumber, userIdList);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
