package com.koreait.mzpick_backend.entity.cafe;

import java.time.LocalDateTime;

import com.koreait.mzpick_backend.dto.request.cafe.PatchTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeRequestDto;
import com.koreait.mzpick_backend.util.CustomDatetime;

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
@Entity(name="travelCafe")
@Table(name="travel_cafe")
public class TravelCafeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelCafeNumber;
    private String userId;
    private String travelCafeTitle;
    private String travelLocation;
    private String travelCafeContent;
    private Integer travelCafeLikeCount;
    private Integer travelCafeSaveCount;
    private Integer travelCafeViewCount;
    private LocalDateTime travelCafeDate;

    public TravelCafeEntity(PostTravelCafeRequestDto dto, String userId){
        this.userId = userId;
        this.travelCafeTitle = dto.getTravelCafeTitle();
        this.travelLocation = dto.getTravelLocation();
        this.travelCafeContent = dto.getTravelCafeContent();
        this.travelCafeViewCount = 0;
        this.travelCafeLikeCount = 0;
        this.travelCafeSaveCount = 0;
        this.travelCafeDate = CustomDatetime.getLocalDatetime();
    }

    public void patch(PatchTravelCafeRequestDto dto, String userId){
        this.userId = userId;
        this.travelCafeTitle = dto.getTravelCafeTitle();
        this.travelLocation = dto.getTraveLocation();
        this.travelCafeContent = dto.getTravelCafeContent();
        this.travelCafeDate = CustomDatetime.getLocalDatetime();
    }
    

    public void upLikeCount(){
        this.travelCafeLikeCount ++;
    }

    public void downLikeCount(){
        this.travelCafeLikeCount --;
    }

    public void upSaveCount(){
        this.travelCafeSaveCount ++;
    }
    public void downSaveCount(){
        this.travelCafeSaveCount --;
    }

    public void upViewCount(){
        this.travelCafeViewCount ++;
    }

    
}
