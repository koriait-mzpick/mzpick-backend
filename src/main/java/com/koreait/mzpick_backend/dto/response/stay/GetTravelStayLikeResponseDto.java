package com.koreait.mzpick_backend.dto.response.stay;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

public class GetTravelStayLikeResponseDto extends ResponseDto {
    private Integer stayNumber;
    private List<String> userIdList;

    public GetTravelStayLikeResponseDto(Integer stayNumber, List<String> userIdList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.stayNumber = stayNumber;
        this.userIdList = userIdList;
    }
    public static ResponseEntity<GetTravelStayLikeResponseDto> success(Integer stayNumber, List<String> userIdList) {
        GetTravelStayLikeResponseDto responseBody = new GetTravelStayLikeResponseDto(stayNumber, userIdList);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
