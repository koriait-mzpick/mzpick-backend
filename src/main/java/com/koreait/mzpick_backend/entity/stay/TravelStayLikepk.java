package com.koreait.mzpick_backend.entity.stay;

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
public class TravelStayLikepk implements Serializable{
    @Column()
    private Integer travelStayNumber;
    @Column()
    private String userId;
    
}
