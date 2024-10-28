package com.koreait.mzpick_backend.dto.response.stay;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.stay.TravelStayComment;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.stay.TravelStayCommentEntity;

import lombok.Getter;

//responseDto 해당 게시판 여행지 댓글 리스트 불러오기 //
@Getter
public class GetTravelStayCommentListResponseDto extends ResponseDto{
    
    private List<TravelStayComment> travelStayComments;

    private GetTravelStayCommentListResponseDto(List<TravelStayCommentEntity> travelStayCommentEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelStayComments = TravelStayComment.getCommentList(travelStayCommentEntities);
    }

    public static ResponseEntity<GetTravelStayCommentListResponseDto> success(List<TravelStayCommentEntity> travelStayCommentEntities) {
        GetTravelStayCommentListResponseDto responseBody = new GetTravelStayCommentListResponseDto(travelStayCommentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
