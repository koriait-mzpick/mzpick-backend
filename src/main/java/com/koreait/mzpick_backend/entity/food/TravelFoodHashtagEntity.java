package com.koreait.mzpick_backend.entity.food;


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
@Entity(name="travelFoodHashtag")
@Table(name="travel_food_hashtag")
public class TravelFoodHashtagEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelFoodHashtagNumber;
    private Integer travelFoodNumber;
    private String travelFoodHashtagContent;
    

    public TravelFoodHashtagEntity(Integer travelFoodNumber, String travelFoodHashtagContent) {
        this.travelFoodNumber = travelFoodNumber;
        this.travelFoodHashtagContent = travelFoodHashtagContent;
    }
}
