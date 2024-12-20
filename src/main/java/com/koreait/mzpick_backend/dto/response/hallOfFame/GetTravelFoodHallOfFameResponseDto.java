package com.koreait.mzpick_backend.dto.response.hallOfFame;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.food.resultSet.GetTravelFoodHallOfFamePhotoListResultSet;

import lombok.Getter;

@Getter
public class GetTravelFoodHallOfFameResponseDto extends ResponseDto{
    private Integer travelNumber;
    private String photoLink;

    public GetTravelFoodHallOfFameResponseDto(List<GetTravelFoodHallOfFamePhotoListResultSet> resultSet) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelNumber = resultSet.get(0).getTravelNumber();
        this.photoLink = resultSet.get(0).getPhotoLink();
    }

    public static ResponseEntity<GetTravelFoodHallOfFameResponseDto> success(List<GetTravelFoodHallOfFamePhotoListResultSet> resultSet){
        GetTravelFoodHallOfFameResponseDto responseBody = new GetTravelFoodHallOfFameResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
