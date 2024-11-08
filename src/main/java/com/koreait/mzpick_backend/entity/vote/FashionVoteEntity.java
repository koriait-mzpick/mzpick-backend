package com.koreait.mzpick_backend.entity.vote;

import java.time.LocalDateTime;

import com.koreait.mzpick_backend.dto.request.vote.PostFashionlVoteRequestDto;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="fashionVote")
@Table(name="fashion_vote")
public class FashionVoteEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer fashionVoteNumber;
    private String userId;
    private String fashionVoteTitle;
    @Column(name="fashion_vote_photo_1")
    private String fashionVotePhoto1;
    @Column(name="fashion_vote_photo_2")
    private String fashionVotePhoto2;
    @Column(name="fashion_vote_choice_1")
    private String fashionVoteChoice1;
    @Column(name="fashion_vote_choice_2")
    private String fashionVoteChoice2;
    private LocalDateTime fashionVoteDate;
    private LocalDateTime fashionVoteExpireDate;

    public FashionVoteEntity(PostFashionlVoteRequestDto dto, String userId){
        this.userId = userId;
        this.fashionVoteTitle = dto.getFashionVoteTitle();
        this.fashionVotePhoto1 = dto.getFashionVotePhoto1();
        this.fashionVotePhoto2 = dto.getFashionVotePhoto2();
        this.fashionVoteChoice1 = dto.getFashionVoteChoice1();
        this.fashionVoteChoice2 = dto.getFashionVoteChoice2();
        this.fashionVoteDate = CustomDatetime.getLocalDatetime();
        this.fashionVoteExpireDate = CustomDatetime.getExpireDatetime();
    }
}
