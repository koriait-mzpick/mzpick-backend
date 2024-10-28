package com.koreait.mzpick_backend.dto.response.cafe;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.cafe.TravelCafeComment;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeCommentEntity;

import lombok.Getter;

//responseDto 해당 게시판 여행지 댓글 리스트 불러오기 //
@Getter
public class GetTravelCafeCommentListResponseDto extends ResponseDto{
    
    private List<TravelCafeComment> travelCafeComments;

    private GetTravelCafeCommentListResponseDto(List<TravelCafeCommentEntity> travelCafeCommentEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelCafeComments = TravelCafeComment.getCommentList(travelCafeCommentEntities);
    }

    public static ResponseEntity<GetTravelCafeCommentListResponseDto> success(List<TravelCafeCommentEntity> travelCafeCommentEntities) {
        GetTravelCafeCommentListResponseDto responseBody = new GetTravelCafeCommentListResponseDto(travelCafeCommentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
