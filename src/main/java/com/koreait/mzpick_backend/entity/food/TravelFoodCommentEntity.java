package com.koreait.mzpick_backend.entity.food;


import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodCommentRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travelFoodComment")
@Table(name="travel_food_comment")
public class TravelFoodCommentEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelFoodCommentNumber;
    private Integer travelFoodNumber;
    private String userId;
    private String travelFoodComment;
    
    public TravelFoodCommentEntity(PostTravelFoodCommentRequestDto dto,Integer travelFoodNumber, String userId){
        this.travelFoodNumber = travelFoodNumber;
        this.userId = userId;
        this.travelFoodComment = dto.getTravelFoodComment();
    }
}
