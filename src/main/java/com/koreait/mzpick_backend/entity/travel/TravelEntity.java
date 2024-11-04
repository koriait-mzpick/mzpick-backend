package com.koreait.mzpick_backend.entity.travel;

import java.time.LocalDateTime;

import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;
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

//entity 여행지 테이블 //
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travel")
@Table(name="travel")
public class TravelEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelNumber;
    private String userId;
    private String travelTitle;
    private String travelLocation;
    private String travelContent;
    private Integer travelViewCount;
    private LocalDateTime travelDate;
    private Integer travelLikeCount;
    private Integer travelSaveCount;

    public TravelEntity(PostTravelRequestDto dto, String userId){
        this.userId = userId;
        this.travelTitle = dto.getTravelTitle();
        this.travelLocation = dto.getTravelLocation();
        this.travelContent = dto.getTravelContent();
        this.travelDate = CustomDatetime.getLocalDatetime();
        this.travelViewCount = 0;
        this.travelLikeCount = 0;
        this.travelSaveCount = 0;
    }

    public void patch(PatchTravelRequestDto dto, String userId){
        this.userId = userId;
        this.travelTitle = dto.getTravelTitle();
        this.travelLocation = dto.getTravelLocation();
        this.travelContent = dto.getTravelContent();
        this.travelDate = CustomDatetime.getLocalDatetime();
    }

    public void upLikeCount(){
        this.travelLikeCount ++;
    }

    public void downLikeCount(){
        this.travelLikeCount --;
    }

    public void upSaveCount(){
        this.travelSaveCount ++;
    }
    public void downSaveCount(){
        this.travelSaveCount --;
    }
    public void upViewCount(){
        this.travelViewCount ++;
    }
}