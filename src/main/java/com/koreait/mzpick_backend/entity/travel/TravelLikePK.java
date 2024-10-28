package com.koreait.mzpick_backend.entity.travel;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//entity 여행지 두개의 좋아요 PK 테이블 //
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelLikePK implements Serializable{
    @Column()
    private Integer travelNumber;
    @Column()
    private String userId;
    
}
