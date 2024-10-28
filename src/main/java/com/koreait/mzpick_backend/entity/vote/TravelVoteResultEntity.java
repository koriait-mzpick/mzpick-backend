package com.koreait.mzpick_backend.entity.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//entity 여행 투표 합계 및 유저 투표 선택 항목 테이블 //
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "travelVoteResult")
@Table(name = "travel_vote_result")
@IdClass(TravelVoteResultPK.class)
public class TravelVoteResultEntity {

    @Id
    private Integer travelVoteNumber;
    @Id
    private String userId;
    private String travelVoteResultChoice;
    
}