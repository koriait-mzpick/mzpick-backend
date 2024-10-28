package com.koreait.mzpick_backend.entity.travel;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//entity 여행지 좋아요 테이블 //
@Getter
@Setter
@NoArgsConstructor
@Entity(name="travelLike")
@Table(name="travel_Like")
@IdClass(TravelLikePK.class)
public class TravelLikeEntity {

    @Id
    private Integer travelNumber;
    @Id
    private String userId;    

    public TravelLikeEntity(Integer travelNumber, String userId) {
        this.travelNumber = travelNumber;
        this.userId = userId;
    }
}