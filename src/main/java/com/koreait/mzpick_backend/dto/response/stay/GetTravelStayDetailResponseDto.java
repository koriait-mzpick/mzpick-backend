package com.koreait.mzpick_backend.dto.response.stay;
// 여행지 리스트 보기 요청 dto

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.stay.TravelStayDetail;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

// responseDto 해당 여행지 게시글 자세히 보기 //
@Getter
public class GetTravelStayDetailResponseDto extends ResponseDto {

    private TravelStayDetail travelStayDetail;

    private GetTravelStayDetailResponseDto(TravelStayDetail travelStayDetail) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelStayDetail = travelStayDetail;
    }

    public static ResponseEntity<GetTravelStayDetailResponseDto> success(TravelStayDetail travelStayDetail) {
        GetTravelStayDetailResponseDto responseBody = new GetTravelStayDetailResponseDto(travelStayDetail);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
