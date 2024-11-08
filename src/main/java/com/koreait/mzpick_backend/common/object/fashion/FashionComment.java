package com.koreait.mzpick_backend.common.object.fashion;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionCommentEntity;

import lombok.Getter;

// 패션 게시글의 댓글 정보를 담는 DTO 클래스
@Getter
public class FashionComment {
    // 댓글 번호
    private Integer fashionCommentNumber;
    // 패션 게시글 번호
    private Integer fashionNumber;
    // 작성자 ID
    private String userId;
    // 댓글 내용
    private String fashionComment;

    // Entity를 DTO로 변환하는 생성자
    private FashionComment(FashionCommentEntity fashionCommentEntity) {
        this.fashionCommentNumber = fashionCommentEntity.getFashionCommentNumber();
        this.fashionNumber = fashionCommentEntity.getFashionNumber();
        this.userId = fashionCommentEntity.getUserId();
        this.fashionComment = fashionCommentEntity.getFashionComment();
    }

    // Entity 리스트를 DTO 리스트로 변환하는 정적 메소드
    public static List<FashionComment> getCommentList(List<FashionCommentEntity> fashionCommentEntities) {
        List<FashionComment> fashionComments = new ArrayList<>();

        // 각 Entity를 DTO로 변환하여 리스트에 추가
        for (FashionCommentEntity fashionCommentEntity: fashionCommentEntities) {
            FashionComment fashionComment = new FashionComment(fashionCommentEntity);
            fashionComments.add(fashionComment);
        }
        return fashionComments;
    }
}

