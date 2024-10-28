package com.koreait.mzpick_backend.dto.response.fashion;
// 여행지 리스트 보기 요청 dto

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.fashion.FashionDetail;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

// responseDto 해당 여행지 게시글 자세히 보기 //
@Getter
public class GetFashionDetailResponseDto extends ResponseDto {

    private FashionDetail FashionDetail;

    private GetFashionDetailResponseDto(FashionDetail FashionDetail) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.FashionDetail = FashionDetail;
    }

    public static ResponseEntity<GetFashionDetailResponseDto> success(FashionDetail FashionDetail) {
        GetFashionDetailResponseDto responseBody = new GetFashionDetailResponseDto(FashionDetail);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
