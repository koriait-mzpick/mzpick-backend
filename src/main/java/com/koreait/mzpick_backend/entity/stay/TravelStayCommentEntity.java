package com.koreait.mzpick_backend.entity.stay;

import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayCommentRequestDto;

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
@Entity(name = "travelStayComment")
@Table(name = "travel_stay_comment")
public class TravelStayCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelStayCommentNumber;
    private String userId;
    private Integer travelStayNumber;
    private String travelStayComment;

    public TravelStayCommentEntity(PostTravelStayCommentRequestDto dto, Integer travelStayNumber, String userId) {
        this.travelStayNumber = travelStayNumber;
        this.userId = userId;
        this.travelStayComment = dto.getTravelStayComment();
    }
}
