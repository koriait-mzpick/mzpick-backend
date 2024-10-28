package com.koreait.mzpick_backend.entity.cafe;


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
@Entity(name="travelCafeLike")
@Table(name="travel_cafe_like")
@IdClass(TravelCafeLikepk.class)
public class TravelCafeLikeEntity {
    @Id
    private Integer travelCafeNumber;
    @Id
    private String userId;
    

    public TravelCafeLikeEntity(Integer travelCafeNumber, String userId) {
        this.travelCafeNumber = travelCafeNumber;
        this.userId = userId;
    }
}
