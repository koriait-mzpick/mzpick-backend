package com.koreait.mzpick_backend.entity.fashion;

import com.koreait.mzpick_backend.dto.request.fashion.PostFashionCommentRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="fashionComment")
@Table(name="fashion_comment")
public class FashionCommentEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer fashionCommentNumber;
    private String userId;
    private Integer fashionNumber;
    private String fashionComment;

    public FashionCommentEntity(PostFashionCommentRequestDto dto,Integer fashionNumber, String userId){
        this.fashionNumber = fashionNumber;
        this.userId = userId;
        this.fashionComment = dto.getFashionComment();
    }
}
