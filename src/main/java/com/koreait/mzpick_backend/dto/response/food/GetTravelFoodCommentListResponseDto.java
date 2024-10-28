package com.koreait.mzpick_backend.dto.response.food;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.food.TravelFoodComment;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.food.TravelFoodCommentEntity;

import lombok.Getter;

//responseDto 해당 게시판 여행지 댓글 리스트 불러오기 //
@Getter
public class GetTravelFoodCommentListResponseDto extends ResponseDto{
    
    private List<TravelFoodComment> travelFoodComments;

    private GetTravelFoodCommentListResponseDto(List<TravelFoodCommentEntity> travelFoodCommentEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelFoodComments = TravelFoodComment.getCommentList(travelFoodCommentEntities);
    }

    public static ResponseEntity<GetTravelFoodCommentListResponseDto> success(List<TravelFoodCommentEntity> travelFoodCommentEntities) {
        GetTravelFoodCommentListResponseDto responseBody = new GetTravelFoodCommentListResponseDto(travelFoodCommentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
