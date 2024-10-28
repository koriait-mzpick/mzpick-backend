package com.koreait.mzpick_backend.entity.travel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//entity 여행지 사진 테이블 //
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travelPhoto")
@Table(name="travel_photo")
public class TravelPhotoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelPhotoNumber;
    private Integer travelNumber;
    private String travelPhotoLink;

    public TravelPhotoEntity(Integer travelNumber, String travelPhotoLink){
        this.travelNumber = travelNumber;
        this.travelPhotoLink = travelPhotoLink;
    }    
}