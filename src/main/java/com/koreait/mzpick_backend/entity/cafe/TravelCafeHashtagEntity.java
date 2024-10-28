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
@Entity(name="travelCafeHashtag")
@Table(name="travel_cafe_hashtag")
public class TravelCafeHashtagEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelCafeHashtagNumber;
    private Integer travelCafeNumber;
    private String travelCafeHashtagContent;

    public TravelCafeHashtagEntity(Integer travelCafeNumber, String travelCafeHashtagContent) {
        this.travelCafeNumber = travelCafeNumber;
        this.travelCafeHashtagContent = travelCafeHashtagContent;
    }
}
