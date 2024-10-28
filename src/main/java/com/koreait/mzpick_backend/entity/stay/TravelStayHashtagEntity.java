package com.koreait.mzpick_backend.entity.stay;


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
@Entity(name="travelStayHashtag")
@Table(name="travel_stay_hashtag")
public class TravelStayHashtagEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelStayHashtagNumber;
    private Integer travelStayNumber;
    private String travelStayHashtagContent;

    public TravelStayHashtagEntity(Integer travelStayNumber, String travelStayHashtagContent) {
        this.travelStayNumber = travelStayNumber;
        this.travelStayHashtagContent = travelStayHashtagContent;
    }
}
