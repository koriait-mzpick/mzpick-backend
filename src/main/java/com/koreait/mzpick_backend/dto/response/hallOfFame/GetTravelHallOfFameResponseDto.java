package com.koreait.mzpick_backend.dto.response.hallOfFame;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.travel.resultSet.GetTravelHallOfFamePhotoListResultSet;

import lombok.Getter;

@Getter
public class GetTravelHallOfFameResponseDto extends ResponseDto{
    private Integer travelNumber;
    private String photoLink;

    public GetTravelHallOfFameResponseDto(List<GetTravelHallOfFamePhotoListResultSet> resultSet) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelNumber = resultSet.get(0).getTravelNumber();
        this.photoLink = resultSet.get(0).getPhotoLink();
    }

    public static ResponseEntity<GetTravelHallOfFameResponseDto> success(List<GetTravelHallOfFamePhotoListResultSet> resultSet){
        GetTravelHallOfFameResponseDto responseBody = new GetTravelHallOfFameResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
