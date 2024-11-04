package com.koreait.mzpick_backend.common.object.vote;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.FashionVoteEntity;
import com.koreait.mzpick_backend.entity.vote.FashionVoteResultEntity;

import lombok.Getter;

@Getter
public class FashionVote {
    private Integer fashionVoteNumber;
    private String userId;
    private String fashionVoteTitle;
    private String fashionVotePhoto1;
    private String fashionVotePhoto2;
    private String fashionVoteChoice1;
    private String fashionVoteChoice2;
    private List<String> fashionVoteChoiceUserList;
    private List<String> fashionVoteChoiceContentList;
    private LocalDateTime fashionVoteDate;

    public FashionVote (FashionVoteEntity fashionVoteEntity, List<FashionVoteResultEntity> fashionVoteResultEntitys){
        List<String> fashionvotechoiceUserList = new ArrayList<>();
        for(FashionVoteResultEntity fashionVoteResultEntity : fashionVoteResultEntitys) fashionvotechoiceUserList.add(fashionVoteResultEntity.getUserId());
        List<String> fashionVoteChoiceContentList = new ArrayList<>();
        for(FashionVoteResultEntity fashionVoteResultEntity : fashionVoteResultEntitys) fashionVoteChoiceContentList.add(fashionVoteResultEntity.getFashionVoteResultChoice());
        this.fashionVoteNumber = fashionVoteEntity.getFashionVoteNumber();
        this.fashionVoteTitle = fashionVoteEntity.getFashionVoteTitle();
        this.userId = fashionVoteEntity.getUserId();
        this.fashionVotePhoto1 = fashionVoteEntity.getFashionVotePhoto1();
        this.fashionVotePhoto2 = fashionVoteEntity.getFashionVotePhoto2();
        this.fashionVoteChoice1 = fashionVoteEntity.getFashionVoteChoice1();
        this.fashionVoteChoice2 = fashionVoteEntity.getFashionVoteChoice2();
        this.fashionVoteChoiceUserList = fashionvotechoiceUserList;
        this.fashionVoteChoiceContentList = fashionVoteChoiceContentList;
        this.fashionVoteDate = fashionVoteEntity.getFashionVoteDate();
    }

    public static List<FashionVote> getList(List<FashionVoteEntity> fashionVoteEntities, List<FashionVoteResultEntity> fashionVoteResultEntitys){
        List<FashionVote> fashionVotes = new ArrayList<>();
        for(FashionVoteEntity fashionVoteEntity : fashionVoteEntities){
            FashionVote fasionVote = new FashionVote(fashionVoteEntity, fashionVoteResultEntitys);
            fashionVotes.add(fasionVote);
        }
        return fashionVotes;
    }

}
