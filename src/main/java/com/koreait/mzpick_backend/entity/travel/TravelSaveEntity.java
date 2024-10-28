package com.koreait.mzpick_backend.entity.travel;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//entity 여행지 저장 테이블 //
@Getter
@Setter
@NoArgsConstructor
@Entity(name="travelSave")
@Table(name="travel_save")
@IdClass(TravelSavePK.class)
public class TravelSaveEntity {

    @Id
    private Integer travelNumber;
    @Id
    private String userId;

    public TravelSaveEntity(Integer travelNumber, String userId) {
        this.travelNumber = travelNumber;
        this.userId = userId;
    }
    
}