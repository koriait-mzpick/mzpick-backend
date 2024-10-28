package com.koreait.mzpick_backend.dto.response.fashion;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.fashion.FashionComment;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.fashion.FashionCommentEntity;

import lombok.Getter;

//responseDto 해당 게시판 여행지 댓글 리스트 불러오기 //
@Getter
public class GetFashionCommentListResponseDto extends ResponseDto{
    
    private List<FashionComment> fashionComments;

    private GetFashionCommentListResponseDto(List<FashionCommentEntity> FashionCommentEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.fashionComments = FashionComment.getCommentList(FashionCommentEntities);
    }

    public static ResponseEntity<GetFashionCommentListResponseDto> success(List<FashionCommentEntity> FashionCommentEntities) {
        GetFashionCommentListResponseDto responseBody = new GetFashionCommentListResponseDto(FashionCommentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
