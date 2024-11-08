package com.koreait.mzpick_backend.common.object.stay;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayCommentEntity;

import lombok.Getter;
// 여행 숙소 게시글의 댓글 정보를 담는 클래스
@Getter
public class TravelStayComment {
    // 댓글 번호
    private Integer TravelStayCommentNumber;
    // 게시글 번호 
    private Integer travelStayNumber;
    // 작성자 ID
    private String userId;
    // 댓글 내용
    private String TravelStayComment;

    // TravelStayCommentEntity를 TravelStayComment로 변환하는 생성자
    private TravelStayComment(TravelStayCommentEntity TravelStayCommentEntity) {
        this.TravelStayCommentNumber = TravelStayCommentEntity.getTravelStayCommentNumber();
        this.travelStayNumber = TravelStayCommentEntity.getTravelStayNumber();
        this.userId = TravelStayCommentEntity.getUserId();
        this.TravelStayComment = TravelStayCommentEntity.getTravelStayComment();
    }

    // TravelStayCommentEntity 리스트를 TravelStayComment 리스트로 변환하는 정적 메소드
    public static List<TravelStayComment> getCommentList(List<TravelStayCommentEntity> TravelStayCommentEntities) {
        List<TravelStayComment> TravelStayComments = new ArrayList<>();

        // 각 TravelStayCommentEntity를 TravelStayComment로 변환하여 리스트에 추가
        for (TravelStayCommentEntity TravelStayCommentEntity: TravelStayCommentEntities) {
            TravelStayComment TravelStayComment = new TravelStayComment(TravelStayCommentEntity);
            TravelStayComments.add(TravelStayComment);
        }
        return TravelStayComments;
    }
}

