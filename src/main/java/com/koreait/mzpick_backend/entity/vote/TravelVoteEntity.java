package com.koreait.mzpick_backend.entity.vote;

import java.time.LocalDateTime;

import com.koreait.mzpick_backend.dto.request.vote.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.util.CustomDatetime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//entity 여행 관련 투표 테이블 //
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travelVote")
@Table(name="travel_vote")
public class TravelVoteEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelVoteNumber;
    private String userId;
    private String travelVoteTitle;
    @Column(name="travel_vote_photo_1")
    private String travelVotePhoto1;
    @Column(name="travel_vote_photo_2")
    private String travelVotePhoto2;
    @Column(name="travel_vote_choice_1")
    private String travelVoteChoice1;
    @Column(name="travel_vote_choice_2")
    private String travelVoteChoice2;
    private LocalDateTime travelVoteDate;
    private LocalDateTime travelVoteExpireDate;


    public TravelVoteEntity(PostTravelVoteRequestDto dto, String userId){
        this.userId = userId;
        this.travelVoteTitle = dto.getTravelVoteTitle();
        this.travelVotePhoto1 = dto.getTravelVotePhoto1();
        this.travelVotePhoto2 = dto.getTravelVotePhoto2();
        this.travelVoteChoice1 = dto.getTravelVoteChoice1();
        this.travelVoteChoice2 = dto.getTravelVoteChoice2();
        this.travelVoteDate = CustomDatetime.getLocalDatetime();
        this.travelVoteExpireDate= CustomDatetime.getExpireDatetime();
    }
}
