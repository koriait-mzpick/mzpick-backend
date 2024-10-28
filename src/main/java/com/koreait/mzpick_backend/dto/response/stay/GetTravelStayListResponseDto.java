package com.koreait.mzpick_backend.dto.response.stay;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.stay.TravelStay;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

//responseDto 여행지 리스트 불러오기 //
@Getter
public class GetTravelStayListResponseDto extends ResponseDto{

    private List<TravelStay> travelStayList;

    private GetTravelStayListResponseDto(List<TravelStay> travelStays) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelStayList = travelStays;
    }

    public static ResponseEntity<GetTravelStayListResponseDto> success(List<TravelStay> travelStays) {
        GetTravelStayListResponseDto responseBody = new GetTravelStayListResponseDto(travelStays);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
