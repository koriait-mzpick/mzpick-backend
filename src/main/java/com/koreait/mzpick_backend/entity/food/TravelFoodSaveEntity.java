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
@Entity(name="travelFoodSave")
@Table(name="travel_food_save")
@IdClass(TravelFoodSavepk.class)
public class TravelFoodSaveEntity {

    @Id
    private Integer travelFoodNumber;
    @Id
    private String userId;
    
    public TravelFoodSaveEntity(Integer travelFoodNumber, String userId) {
        this.travelFoodNumber = travelFoodNumber;
        this.userId = userId;
    }
}
