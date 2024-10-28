package com.koreait.mzpick_backend.entity.food;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelFoodSavepk implements Serializable{
    @Column()
    private Integer travelFoodNumber;
    @Column()
    private String userId;
    
}
