package com.koreait.mzpick_backend.dto.response.mypage.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.board.MyPageBoardFood;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.fashion.FashionEntity;

import lombok.Getter;

@Getter
public class GetMyPageBoardFoodListResponseDto extends ResponseDto {
    
     private List<MyPageBoardFood> myPageBoardFoods;

    private GetMyPageBoardFoodListResponseDto(List<FashionEntity> fashionEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageBoardFoods = MyPageBoardFood.getMyPageBoardFoodList(fashionEntities);
    }

    public static ResponseEntity<GetMyPageBoardFoodListResponseDto> success(List<FashionEntity> fashionEntities) {
        GetMyPageBoardFoodListResponseDto responseBody = new GetMyPageBoardFoodListResponseDto(fashionEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }


    
}
