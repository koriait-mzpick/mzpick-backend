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
@Entity(name="travelStayCategory")
@Table(name="travel_stay_category")
public class TravelStayCategoryEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelStayCategoryNumber;
    private Integer travelStayNumber;
    private String travelStayCategoryContent;

    public TravelStayCategoryEntity(Integer travelStayNumber, String travelStayCategoryContent){
        this.travelStayNumber = travelStayNumber;
        this.travelStayCategoryContent = travelStayCategoryContent;
    }
}
