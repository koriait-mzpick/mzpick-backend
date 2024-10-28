package com.koreait.mzpick_backend.entity.stay;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "travelStaySave")
@Table(name = "travel_stay_save")
@IdClass(TravelStaySavepk.class)
public class TravelStaySaveEntity {

    @Id
    private Integer travelStayNumber;
    @Id
    private String userId;

    public TravelStaySaveEntity(Integer travelStayNumber, String userId) {
        this.travelStayNumber = travelStayNumber;
        this.userId = userId;
    }
}
