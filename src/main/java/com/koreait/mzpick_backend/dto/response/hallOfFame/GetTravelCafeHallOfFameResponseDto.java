package com.koreait.mzpick_backend.dto.response.hallOfFame;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.cafe.resultSet.GetTravelCafeHallOfFamePhotoListResultSet;

import lombok.Getter;

@Getter
public class GetTravelCafeHallOfFameResponseDto extends ResponseDto{
    private GetTravelCafeHallOfFamePhotoListResultSet resultSet;

    public GetTravelCafeHallOfFameResponseDto(List<GetTravelCafeHallOfFamePhotoListResultSet> resultSet) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.resultSet = resultSet.get(0);
    }

    public static ResponseEntity<GetTravelCafeHallOfFameResponseDto> success(List<GetTravelCafeHallOfFamePhotoListResultSet> resultSet){
        GetTravelCafeHallOfFameResponseDto responseBody = new GetTravelCafeHallOfFameResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
