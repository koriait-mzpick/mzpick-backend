package com.koreait.mzpick_backend.dto.response.food;
// 여행지 리스트 보기 요청 dto

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.food.TravelFoodDetail;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

// responseDto 해당 여행지 게시글 자세히 보기 //
@Getter
public class GetTravelFoodDetailResponseDto extends ResponseDto {

    private TravelFoodDetail travelFoodDetail;

    private GetTravelFoodDetailResponseDto(TravelFoodDetail travelFoodDetail) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelFoodDetail = travelFoodDetail;
    }

    public static ResponseEntity<GetTravelFoodDetailResponseDto> success(TravelFoodDetail travelFoodDetail) {
        GetTravelFoodDetailResponseDto responseBody = new GetTravelFoodDetailResponseDto(travelFoodDetail);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
