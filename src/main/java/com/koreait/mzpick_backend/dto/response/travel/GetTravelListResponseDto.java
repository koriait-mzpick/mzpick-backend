package com.koreait.mzpick_backend.dto.response.travel;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.travel.Travel;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

//responseDto 여행지 리스트 불러오기 //
@Getter
public class GetTravelListResponseDto extends ResponseDto{

    private List<Travel> travelList;

    private GetTravelListResponseDto(List<Travel> travels) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelList = travels;
    }

    public static ResponseEntity<GetTravelListResponseDto> success(List<Travel> travels) {
        GetTravelListResponseDto responseBody = new GetTravelListResponseDto(travels);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
