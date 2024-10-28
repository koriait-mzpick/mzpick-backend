package com.koreait.mzpick_backend.common.object.cafe;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeCommentEntity;

import lombok.Getter;

@Getter
public class TravelCafeComment {
    private Integer TravelCafeCommentNumeber;
    private Integer travelCafeNumber;
    private String userId;
    private String TravelCafeComment;

    private TravelCafeComment(TravelCafeCommentEntity TravelCafeCommentEntity) {
        this.TravelCafeCommentNumeber = TravelCafeCommentEntity.getTravelCafeCommentNumber();
        this.travelCafeNumber = TravelCafeCommentEntity.getTravelCafeNumber();
        this.userId = TravelCafeCommentEntity.getUserId();
        this.TravelCafeComment = TravelCafeCommentEntity.getTravelCafeComment();
    }

    public static List<TravelCafeComment> getCommentList(List<TravelCafeCommentEntity> TravelCafeCommentEntities) {
        List<TravelCafeComment> TravelCafeComments = new ArrayList<>();

        for (TravelCafeCommentEntity TravelCafeCommentEntity: TravelCafeCommentEntities) {
            TravelCafeComment TravelCafeComment = new TravelCafeComment(TravelCafeCommentEntity);
            TravelCafeComments.add(TravelCafeComment);
        }
        return TravelCafeComments;
    }
}

