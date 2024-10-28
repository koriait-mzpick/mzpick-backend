package com.koreait.mzpick_backend.entity.travel;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//entity 여행지 해시태그 테이블 //
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travelHashtag")
@Table(name="travel_hashtag")
public class TravelHashtagEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelHashtagNumber;
    private Integer travelNumber;
    private String travelHashtagContent;

    public TravelHashtagEntity(Integer travelNumber, String travelHashtagContent) {
        this.travelNumber = travelNumber;
        this.travelHashtagContent = travelHashtagContent;
    }
    
}