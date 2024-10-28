package com.koreait.mzpick_backend.dto.response.fashion;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.fashion.Fashion;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

//responseDto 여행지 리스트 불러오기 //
@Getter
public class GetFashionListResponseDto extends ResponseDto{

    private List<Fashion> fashionList;

    private GetFashionListResponseDto(List<Fashion> fashions) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.fashionList = fashions;
    }

    public static ResponseEntity<GetFashionListResponseDto> success(List<Fashion> Fashions) {
        GetFashionListResponseDto responseBody = new GetFashionListResponseDto(Fashions);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
