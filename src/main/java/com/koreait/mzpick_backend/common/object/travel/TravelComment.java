package com.koreait.mzpick_backend.common.object.travel;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelCommentEntity;

import lombok.Getter;

// 여행 게시글의 댓글 정보를 담는 클래스
@Getter
public class TravelComment {
    // 댓글 번호
    private Integer travelCommentNumber;
    // 게시글 번호 
    private Integer travelNumber;
    // 작성자 ID
    private String userId;
    // 댓글 내용
    private String travelComment;

    // TravelCommentEntity를 TravelComment로 변환하는 생성자
    private TravelComment(TravelCommentEntity travelCommentEntity) {
        this.travelCommentNumber = travelCommentEntity.getTravelCommentNumber();
        this.travelNumber = travelCommentEntity.getTravelNumber();
        this.userId = travelCommentEntity.getUserId();
        this.travelComment = travelCommentEntity.getTravelComment();
    }

    // TravelCommentEntity 리스트를 TravelComment 리스트로 변환하는 정적 메소드
    public static List<TravelComment> getCommentList(List<TravelCommentEntity> travelCommentEntities) {
        List<TravelComment> travelComments = new ArrayList<>();

        // 각 TravelCommentEntity를 TravelComment로 변환하여 리스트에 추가
        for (TravelCommentEntity travelCommentEntity: travelCommentEntities) {
            TravelComment travelComment = new TravelComment(travelCommentEntity);
            travelComments.add(travelComment);
        }
        return travelComments;
    }
}
