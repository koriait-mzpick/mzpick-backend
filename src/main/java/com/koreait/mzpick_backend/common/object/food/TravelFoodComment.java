package com.koreait.mzpick_backend.common.object.food;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodCommentEntity;

import lombok.Getter;

@Getter
public class TravelFoodComment {
    private Integer TravelFoodCommentNumeber;
    private Integer travelFoodNumber;
    private String userId;
    private String TravelFoodComment;

    private TravelFoodComment(TravelFoodCommentEntity TravelFoodCommentEntity) {
        this.TravelFoodCommentNumeber = TravelFoodCommentEntity.getTravelFoodCommentNumber();
        this.travelFoodNumber = TravelFoodCommentEntity.getTravelFoodNumber();
        this.userId = TravelFoodCommentEntity.getUserId();
        this.TravelFoodComment = TravelFoodCommentEntity.getTravelFoodComment();
    }

    public static List<TravelFoodComment> getCommentList(List<TravelFoodCommentEntity> TravelFoodCommentEntities) {
        List<TravelFoodComment> TravelFoodComments = new ArrayList<>();

        for (TravelFoodCommentEntity TravelFoodCommentEntity: TravelFoodCommentEntities) {
            TravelFoodComment TravelFoodComment = new TravelFoodComment(TravelFoodCommentEntity);
            TravelFoodComments.add(TravelFoodComment);
        }
        return TravelFoodComments;
    }
}

