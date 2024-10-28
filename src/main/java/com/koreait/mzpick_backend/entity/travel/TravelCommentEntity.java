package com.koreait.mzpick_backend.entity.travel;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// entity 여행 댓글 테이블 //
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "travelComment")
@Table(name = "travel_comment")
public class TravelCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelCommentNumber;
    private Integer travelNumber;
    private String userId;
    private String travelComment;

    public TravelCommentEntity(PostTravelCommentRequestDto dto,Integer travelNumber, String userId){
        this.travelNumber = travelNumber;
        this.userId = userId;
        this.travelComment = dto.getTravelComment();
    }
}