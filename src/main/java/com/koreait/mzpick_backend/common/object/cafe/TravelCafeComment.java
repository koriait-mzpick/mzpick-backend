package com.koreait.mzpick_backend.common.object.cafe;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeCommentEntity;

import lombok.Getter;

/**
 * 여행 카페 댓글 정보를 담는 클래스
 */
@Getter
public class TravelCafeComment {
    /** 여행 카페 댓글 번호 */
    private Integer TravelCafeCommentNumber;
    /** 여행 카페 게시글 번호 */
    private Integer travelCafeNumber;
    /** 사용자 ID */
    private String userId;
    /** 댓글 내용 */
    private String TravelCafeComment;

    /**
     * Entity를 받아 TravelCafeComment 객체로 변환하는 생성자
     * 
     * @param TravelCafeCommentEntity 여행 카페 댓글 엔티티
     */
    private TravelCafeComment(TravelCafeCommentEntity TravelCafeCommentEntity) {
        this.TravelCafeCommentNumber = TravelCafeCommentEntity.getTravelCafeCommentNumber();
        this.travelCafeNumber = TravelCafeCommentEntity.getTravelCafeNumber();
        this.userId = TravelCafeCommentEntity.getUserId();
        this.TravelCafeComment = TravelCafeCommentEntity.getTravelCafeComment();
    }

    /**
     * Entity 리스트를 TravelCafeComment 객체 리스트로 변환하는 메소드
     * 
     * @param TravelCafeCommentEntities 여행 카페 댓글 엔티티 리스트
     * @return 변환된 TravelCafeComment 객체 리스트
     */
    public static List<TravelCafeComment> getCommentList(List<TravelCafeCommentEntity> TravelCafeCommentEntities) {
        List<TravelCafeComment> TravelCafeComments = new ArrayList<>();

        for (TravelCafeCommentEntity TravelCafeCommentEntity : TravelCafeCommentEntities) {
            TravelCafeComment TravelCafeComment = new TravelCafeComment(TravelCafeCommentEntity);
            TravelCafeComments.add(TravelCafeComment);
        }
        return TravelCafeComments;
    }
}
