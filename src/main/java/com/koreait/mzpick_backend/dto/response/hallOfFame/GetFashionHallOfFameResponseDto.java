package com.koreait.mzpick_backend.dto.response.hallOfFame;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.fashion.resultSet.GetFashionHallOfFamePhotoListResultSet;

import lombok.Getter;

@Getter
public class GetFashionHallOfFameResponseDto extends ResponseDto{
    private GetFashionHallOfFamePhotoListResultSet resultSet;

    public GetFashionHallOfFameResponseDto(List<GetFashionHallOfFamePhotoListResultSet> resultSet) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.resultSet = resultSet.get(0);
    }

    public static ResponseEntity<GetFashionHallOfFameResponseDto> success(List<GetFashionHallOfFamePhotoListResultSet> resultSet){
        GetFashionHallOfFameResponseDto responseBody = new GetFashionHallOfFameResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
