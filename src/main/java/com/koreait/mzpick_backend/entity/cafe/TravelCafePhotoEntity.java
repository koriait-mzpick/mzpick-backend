package com.koreait.mzpick_backend.entity.cafe;


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
@Entity(name="travelCafePhoto")
@Table(name="travel_cafe_photo")
public class TravelCafePhotoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelCafePhotoNumber;
    private Integer travelCafeNumber;
    private String travelCafePhotoLink;
    
        
    public TravelCafePhotoEntity(Integer travelCafeNumber, String travelCafePhotoLink) {
        this.travelCafeNumber = travelCafeNumber;
        this.travelCafePhotoLink = travelCafePhotoLink;
    }
}
