package com.koreait.mzpick_backend.dto.response.food;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.food.TravelFood;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

//responseDto 여행지 리스트 불러오기 //
@Getter
public class GetTravelFoodListResponseDto extends ResponseDto{

    private List<TravelFood> travelFoodList;

    private GetTravelFoodListResponseDto(List<TravelFood> travelFoods) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelFoodList = travelFoods;
    }

    public static ResponseEntity<GetTravelFoodListResponseDto> success(List<TravelFood> travelFoods) {
        GetTravelFoodListResponseDto responseBody = new GetTravelFoodListResponseDto(travelFoods);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
