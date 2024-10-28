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
@Entity(name = "travelStayLike")
@Table(name = "travel_stay_like")
@IdClass(TravelStayLikepk.class)
public class TravelStayLikeEntity {

    @Id
    private Integer travelStayNumber;
    @Id
    private String userId;

    public TravelStayLikeEntity(Integer travelStayNumber, String userId) {
        this.travelStayNumber = travelStayNumber;
        this.userId = userId;
    }
}
