package com.koreait.mzpick_backend.dto.response.travel;
// 여행지 리스트 보기 요청 dto

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.travel.TravelDetail;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

// responseDto 해당 여행지 게시글 자세히 보기 //
@Getter
public class GetTravelDetailResponseDto extends ResponseDto {

    private TravelDetail travelDetail;

    private GetTravelDetailResponseDto(TravelDetail travelDetail) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelDetail = travelDetail;
    }

    public static ResponseEntity<GetTravelDetailResponseDto> success(TravelDetail travelDetail) {
        GetTravelDetailResponseDto responseBody = new GetTravelDetailResponseDto(travelDetail);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
