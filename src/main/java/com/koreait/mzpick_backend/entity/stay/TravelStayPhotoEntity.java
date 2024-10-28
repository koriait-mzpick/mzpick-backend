package com.koreait.mzpick_backend.entity.stay;


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
@Entity(name="travelStayPhoto")
@Table(name="travel_stay_photo")
public class TravelStayPhotoEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelStayPhotoNumber;
    private Integer travelStayNumber;
    private String travelStayPhotoLink;
    
    public TravelStayPhotoEntity(Integer travelStayNumber, String travelStayPhotoLink){
        this.travelStayNumber = travelStayNumber;
        this.travelStayPhotoLink = travelStayPhotoLink;
    }  

}
