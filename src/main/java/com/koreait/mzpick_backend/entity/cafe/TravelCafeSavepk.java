package com.koreait.mzpick_backend.entity.cafe;

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
public class TravelCafeSavepk implements Serializable{
    @Column()
    private Integer travelCafeNumber;
    @Column()
    private String userId;
    
}
