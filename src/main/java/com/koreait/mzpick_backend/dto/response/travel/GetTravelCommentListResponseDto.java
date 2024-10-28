package com.koreait.mzpick_backend.dto.response.travel;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.travel.TravelComment;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.travel.TravelCommentEntity;

import lombok.Getter;

//responseDto 해당 게시판 여행지 댓글 리스트 불러오기 //
@Getter
public class GetTravelCommentListResponseDto extends ResponseDto{
    
    private List<TravelComment> travelComments;

    private GetTravelCommentListResponseDto(List<TravelCommentEntity> travelCommentEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelComments = TravelComment.getCommentList(travelCommentEntities);
    }

    public static ResponseEntity<GetTravelCommentListResponseDto> success(List<TravelCommentEntity> travelCommentEntities) {
        GetTravelCommentListResponseDto responseBody = new GetTravelCommentListResponseDto(travelCommentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
