package com.koreait.mzpick_backend.dto.response.mypage.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.mypage.board.MyPageBoardFashion;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.fashion.FashionEntity;

import lombok.Getter;

@Getter
public class GetMyPageBoardFashionListResponseDto extends ResponseDto {
    
    private List<MyPageBoardFashion> myPageBoardFashions;

    private GetMyPageBoardFashionListResponseDto(List<FashionEntity> fashionEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.myPageBoardFashions = MyPageBoardFashion.getMyPageBoardFashionList(fashionEntities);
    }

    public static ResponseEntity<GetMyPageBoardFashionListResponseDto> success(List<FashionEntity> fashionEntities) {
        GetMyPageBoardFashionListResponseDto responseBody = new GetMyPageBoardFashionListResponseDto(fashionEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    
}
