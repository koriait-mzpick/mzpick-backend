package com.koreait.mzpick_backend.entity.food;

import java.time.LocalDate;

import com.koreait.mzpick_backend.dto.request.food.PatchTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodRequestDto;

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
@Entity(name="travelFood")
@Table(name="travel_food")
public class TravelFoodEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelFoodNumber;
    private String userId;
    private String travelFoodTitle;
    private String travelLocation;
    private String travelFoodContent;
    private Integer travelFoodLikeCount;
    private Integer travelFoodViewCount;
    private Integer travelFoodSaveCount;
    private LocalDate travelFoodDate;

    public TravelFoodEntity(PostTravelFoodRequestDto dto, String userId){
        this.userId = userId;
        this.travelFoodTitle = dto.getTravelFoodTitle();
        this.travelLocation = dto.getTravelLocation();
        this.travelFoodContent = dto.getTravelFoodContent();
        this.travelFoodViewCount = 0;
        this.travelFoodLikeCount = 0;
        this.travelFoodSaveCount = 0;
        this.travelFoodDate = LocalDate.now();
    }

    public void patch(PatchTravelFoodRequestDto dto, String userId){
        this.userId = userId;
        this.travelFoodTitle = dto.getTravelFoodTitle();
        this.travelLocation = dto.getTravelLocation();
        this.travelFoodContent = dto.getTravelFoodContent();
        this.travelFoodDate = LocalDate.now();
    }

    public void upLikeCount(){
        this.travelFoodLikeCount ++;
    }

    public void downLikeCount(){
        this.travelFoodLikeCount --;
    }

    public void upSaveCount(){
        this.travelFoodSaveCount ++;
    }
    public void downSaveCount(){
        this.travelFoodSaveCount --;
    }
    public void upViewCount(){
        this.travelFoodViewCount ++;
    }
}