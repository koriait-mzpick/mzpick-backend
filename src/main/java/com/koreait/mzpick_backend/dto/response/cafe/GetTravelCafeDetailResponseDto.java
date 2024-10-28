package com.koreait.mzpick_backend.dto.response.cafe;
// 여행지 리스트 보기 요청 dto

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.cafe.TravelCafeDetail;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

// responseDto 해당 여행지 게시글 자세히 보기 //
@Getter
public class GetTravelCafeDetailResponseDto extends ResponseDto {

    private TravelCafeDetail travelCafeDetail;

    private GetTravelCafeDetailResponseDto(TravelCafeDetail travelCafeDetail) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelCafeDetail = travelCafeDetail;
    }

    public static ResponseEntity<GetTravelCafeDetailResponseDto> success(TravelCafeDetail travelCafeDetail) {
        GetTravelCafeDetailResponseDto responseBody = new GetTravelCafeDetailResponseDto(travelCafeDetail);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
