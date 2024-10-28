package com.koreait.mzpick_backend.dto.response.mypage.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.board.MyPageBoardTravel;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;

import lombok.Getter;

@Getter
public class GetMyPageBoardTravelListResponseDto extends ResponseDto {
    
     private List<MyPageBoardTravel> myPageBoardTravels;

    private GetMyPageBoardTravelListResponseDto(List<TravelEntity> travelEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageBoardTravels = MyPageBoardTravel.getMyPageBoardList(travelEntities);
    }

    public static ResponseEntity<GetMyPageBoardTravelListResponseDto> success(List<TravelEntity> travelEntities) {
        GetMyPageBoardTravelListResponseDto responseBody = new GetMyPageBoardTravelListResponseDto(travelEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
