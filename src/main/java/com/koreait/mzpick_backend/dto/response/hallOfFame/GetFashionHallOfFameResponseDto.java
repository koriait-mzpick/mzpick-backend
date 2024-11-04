package com.koreait.mzpick_backend.dto.response.hallOfFame;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.fashion.Fashion;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.fashion.resultSet.GetFashionHallOfFamePhotoListResultSet;

import lombok.Getter;

@Getter
public class GetFashionHallOfFameResponseDto extends ResponseDto{
    private Integer fashionNumber;
    private String photoLink; 


    public GetFashionHallOfFameResponseDto(List<GetFashionHallOfFamePhotoListResultSet> resultSet) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.fashionNumber = resultSet.get(0).getFashionNumber();
        this.photoLink = resultSet.get(0).getPhotoLink();
    }

    public static ResponseEntity<GetFashionHallOfFameResponseDto> success(List<GetFashionHallOfFamePhotoListResultSet> resultSet){
        GetFashionHallOfFameResponseDto responseBody = new GetFashionHallOfFameResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
