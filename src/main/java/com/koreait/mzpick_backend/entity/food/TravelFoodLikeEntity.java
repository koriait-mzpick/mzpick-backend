package com.koreait.mzpick_backend.entity.food;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="travelFoodLike")
@Table(name="travel_food_like")
@IdClass(TravelFoodLikepk.class)
public class TravelFoodLikeEntity {

    @Id
    private Integer travelFoodNumber;
    @Id
    private String userId;


    public TravelFoodLikeEntity(Integer travelFoodNumber, String userId) {
        this.travelFoodNumber = travelFoodNumber;
        this.userId = userId;
    }
}
