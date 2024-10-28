package com.koreait.mzpick_backend.common.object.stay;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayCommentEntity;

import lombok.Getter;

@Getter
public class TravelStayComment {
    private Integer TravelStayCommentNumeber;
    private Integer travelStayNumber;
    private String userId;
    private String TravelStayComment;

    private TravelStayComment(TravelStayCommentEntity TravelStayCommentEntity) {
        this.TravelStayCommentNumeber = TravelStayCommentEntity.getTravelStayCommentNumber();
        this.travelStayNumber = TravelStayCommentEntity.getTravelStayNumber();
        this.userId = TravelStayCommentEntity.getUserId();
        this.TravelStayComment = TravelStayCommentEntity.getTravelStayComment();
    }

    public static List<TravelStayComment> getCommentList(List<TravelStayCommentEntity> TravelStayCommentEntities) {
        List<TravelStayComment> TravelStayComments = new ArrayList<>();

        for (TravelStayCommentEntity TravelStayCommentEntity: TravelStayCommentEntities) {
            TravelStayComment TravelStayComment = new TravelStayComment(TravelStayCommentEntity);
            TravelStayComments.add(TravelStayComment);
        }
        return TravelStayComments;
    }
}

