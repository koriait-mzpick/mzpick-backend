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
@Entity(name="travelFoodPhoto")
@Table(name="travel_food_photo")
public class TravelFoodPhotoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelFoodPhotoNumber;
    private Integer travelFoodNumber;
    private String travelFoodPhotoLink;
    

    public TravelFoodPhotoEntity(Integer travelFoodNumber, String travelFoodPhotoLink){
        this.travelFoodNumber = travelFoodNumber;
        this.travelFoodPhotoLink = travelFoodPhotoLink;
    }    
}
