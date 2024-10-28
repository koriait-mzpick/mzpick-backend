package com.koreait.mzpick_backend.dto.response.mypage.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.board.MyPageBoardStay;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;

import lombok.Getter;

@Getter
public class GetMyPageBoardStayListResponseDto extends ResponseDto {
    
   private List<MyPageBoardStay> myPageBoardStays;

    private GetMyPageBoardStayListResponseDto(List<TravelStayEntity> travelStayEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageBoardStays = MyPageBoardStay.getMyPageBoardStayList(travelStayEntities);
    }

    public static ResponseEntity<GetMyPageBoardStayListResponseDto> success(List<TravelStayEntity> travelStayEntities) {
        GetMyPageBoardStayListResponseDto responseBody = new GetMyPageBoardStayListResponseDto(travelStayEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    
}
