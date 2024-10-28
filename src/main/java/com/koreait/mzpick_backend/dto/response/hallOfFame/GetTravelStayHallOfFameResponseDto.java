package com.koreait.mzpick_backend.dto.response.hallOfFame;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.stay.resultSet.GetTravelStayHallOfFamePhotoListResultSet;

import lombok.Getter;

@Getter
public class GetTravelStayHallOfFameResponseDto extends ResponseDto{
    private GetTravelStayHallOfFamePhotoListResultSet resultSet;

    public GetTravelStayHallOfFameResponseDto(List<GetTravelStayHallOfFamePhotoListResultSet> resultSet) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.resultSet = resultSet.get(0);
    }

    public static ResponseEntity<GetTravelStayHallOfFameResponseDto> success(List<GetTravelStayHallOfFamePhotoListResultSet> resultSet){
        GetTravelStayHallOfFameResponseDto responseBody = new GetTravelStayHallOfFameResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
