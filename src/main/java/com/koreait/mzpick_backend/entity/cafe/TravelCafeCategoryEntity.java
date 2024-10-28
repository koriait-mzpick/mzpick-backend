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
@Entity(name = "travelCafeCategory")
@Table(name = "travel_cafe_category")
public class TravelCafeCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelCafeCategoryNumber;
    private Integer travelCafeNumber;
    private String travelCafeCategoryContent;

    public TravelCafeCategoryEntity(Integer travelCafeNumber, String travelCafeCategoryContent) {
        this.travelCafeNumber = travelCafeNumber;
        this.travelCafeCategoryContent = travelCafeCategoryContent;
    }

}
