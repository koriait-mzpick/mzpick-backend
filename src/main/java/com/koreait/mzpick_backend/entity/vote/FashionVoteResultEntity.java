package com.koreait.mzpick_backend.entity.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="fashionVoteResult")
@Table(name="fashion_vote_result")
@IdClass(FashionVoteResultpk.class)
public class FashionVoteResultEntity {
    @Id
    private String userId;
    @Id
    private Integer fashionVoteNumber;
    private String fashionVoteResultChoice;
}
