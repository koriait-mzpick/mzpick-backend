package com.koreait.mzpick_backend.dto.response.mypage.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.board.MyPageBoardCafe;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;

import lombok.Getter;

@Getter
public class GetMyPageBoardCafeListResponseDto extends ResponseDto {
    
   private List<MyPageBoardCafe> myPageBoardCafes;

    private GetMyPageBoardCafeListResponseDto(List<TravelCafeEntity> travelCafeEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageBoardCafes = MyPageBoardCafe.getMyPageBoardCafeList(travelCafeEntities);
    }

    public static ResponseEntity<GetMyPageBoardCafeListResponseDto> success(List<TravelCafeEntity> travelCafeEntities) {
        GetMyPageBoardCafeListResponseDto responseBody = new GetMyPageBoardCafeListResponseDto(travelCafeEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    
}
