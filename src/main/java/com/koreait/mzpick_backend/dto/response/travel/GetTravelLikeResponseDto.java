package com.koreait.mzpick_backend.dto.response.travel;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetTravelLikeResponseDto extends ResponseDto {
    private Integer travelNumber;
    private List<String> userIdList;

    public GetTravelLikeResponseDto(Integer travelNumber, List<String> userIdList) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelNumber = travelNumber;
        this.userIdList = userIdList;
    }
    public static ResponseEntity<GetTravelLikeResponseDto> success(Integer travelNumber, List<String> userIdList) {
        GetTravelLikeResponseDto responseBody = new GetTravelLikeResponseDto(travelNumber, userIdList);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
