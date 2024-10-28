package com.koreait.mzpick_backend.entity.vote;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//entity 여행지 두개의 투표 하기 PK 테이블 //
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelVoteResultPK implements Serializable{
    @Column()
    private Integer travelVoteNumber;
    @Column()
    private String userId;
    
}
