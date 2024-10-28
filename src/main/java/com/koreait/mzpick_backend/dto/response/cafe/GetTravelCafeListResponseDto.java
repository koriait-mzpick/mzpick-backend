package com.koreait.mzpick_backend.dto.response.cafe;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.cafe.TravelCafe;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

//responseDto 여행지 리스트 불러오기 //
@Getter
public class GetTravelCafeListResponseDto extends ResponseDto{

    private List<TravelCafe> travelCafeList;

    private GetTravelCafeListResponseDto(List<TravelCafe> travelCafes) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelCafeList = travelCafes;
    }

    public static ResponseEntity<GetTravelCafeListResponseDto> success(List<TravelCafe> travelCafes) {
        GetTravelCafeListResponseDto responseBody = new GetTravelCafeListResponseDto(travelCafes);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
