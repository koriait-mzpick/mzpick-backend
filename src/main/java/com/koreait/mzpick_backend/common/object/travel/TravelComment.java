package com.koreait.mzpick_backend.common.object.travel;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelCommentEntity;

import lombok.Getter;

@Getter
public class TravelComment {
    private Integer travelCommentNumeber;
    private Integer travelNumber;
    private String userId;
    private String travelComment;

    private TravelComment(TravelCommentEntity travelCommentEntity) {
        this.travelCommentNumeber = travelCommentEntity.getTravelCommentNumber();
        this.travelNumber = travelCommentEntity.getTravelNumber();
        this.userId = travelCommentEntity.getUserId();
        this.travelComment = travelCommentEntity.getTravelComment();
    }

    public static List<TravelComment> getCommentList(List<TravelCommentEntity> travelCommentEntities) {
        List<TravelComment> travelComments = new ArrayList<>();

        for (TravelCommentEntity travelCommentEntity: travelCommentEntities) {
            TravelComment travelComment = new TravelComment(travelCommentEntity);
            travelComments.add(travelComment);
        }
        return travelComments;
    }
}
