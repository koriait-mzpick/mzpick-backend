package com.koreait.mzpick_backend.common.object.fashion;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionCommentEntity;

import lombok.Getter;

@Getter
public class FashionComment {
    private Integer fashionCommentNumeber;
    private Integer fashionNumber;
    private String userId;
    private String fashionComment;

    private FashionComment(FashionCommentEntity fashionCommentEntity) {
        this.fashionCommentNumeber = fashionCommentEntity.getFashionCommentNumber();
        this.fashionNumber = fashionCommentEntity.getFashionNumber();
        this.userId = fashionCommentEntity.getUserId();
        this.fashionComment = fashionCommentEntity.getFashionComment();
    }

    public static List<FashionComment> getCommentList(List<FashionCommentEntity> fashionCommentEntities) {
        List<FashionComment> fashionComments = new ArrayList<>();

        for (FashionCommentEntity fashionCommentEntity: fashionCommentEntities) {
            FashionComment fashionComment = new FashionComment(fashionCommentEntity);
            fashionComments.add(fashionComment);
        }
        return fashionComments;
    }
}

