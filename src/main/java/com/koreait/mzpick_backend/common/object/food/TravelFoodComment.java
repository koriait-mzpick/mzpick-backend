package com.koreait.mzpick_backend.common.object.food;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodCommentEntity;

import lombok.Getter;

// 여행 음식점 게시글의 댓글 정보를 담는 DTO 클래스
@Getter
public class TravelFoodComment {
    // 댓글 번호
    private Integer TravelFoodCommentNumber;
    // 여행 음식점 게시글 번호
    private Integer travelFoodNumber;
    // 작성자 ID
    private String userId;
    // 댓글 내용
    private String TravelFoodComment;

    // Entity를 DTO로 변환하는 생성자
    private TravelFoodComment(TravelFoodCommentEntity TravelFoodCommentEntity) {
        this.TravelFoodCommentNumber = TravelFoodCommentEntity.getTravelFoodCommentNumber();
        this.travelFoodNumber = TravelFoodCommentEntity.getTravelFoodNumber();
        this.userId = TravelFoodCommentEntity.getUserId();
        this.TravelFoodComment = TravelFoodCommentEntity.getTravelFoodComment();
    }

    // Entity 리스트를 DTO 리스트로 변환하는 정적 메소드
    public static List<TravelFoodComment> getCommentList(List<TravelFoodCommentEntity> TravelFoodCommentEntities) {
        List<TravelFoodComment> TravelFoodComments = new ArrayList<>();

        // 각 Entity를 DTO로 변환하여 리스트에 추가
        for (TravelFoodCommentEntity TravelFoodCommentEntity: TravelFoodCommentEntities) {
            TravelFoodComment TravelFoodComment = new TravelFoodComment(TravelFoodCommentEntity);
            TravelFoodComments.add(TravelFoodComment);
        }
        return TravelFoodComments;
    }
}
