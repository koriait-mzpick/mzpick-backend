package com.koreait.mzpick_backend.common.object.vote;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.TravelVoteEntity;
import com.koreait.mzpick_backend.entity.vote.TravelVoteResultEntity;

import lombok.Getter;

@Getter
public class TravelVote {
    private Integer travelVoteNumber;
    private String userId;
    private String travelVoteTitle;
    private String travelVotePhoto1;
    private String travelVotePhoto2;
    private String travelVoteChoice1;
    private String travelVoteChoice2;
    private List<String> travelVoteChoiceUserList;
    private List<String> travelVoteChoiceContentList;
    private LocalDate travelVoteDate;

    public TravelVote(TravelVoteEntity travelVoteEntity, List<TravelVoteResultEntity> travelVoteResultEntitys ){
        List<String> travelVoteChoiceUserList = new ArrayList<>();
        for(TravelVoteResultEntity travelVoteResultEntity : travelVoteResultEntitys) travelVoteChoiceUserList.add(travelVoteResultEntity.getUserId());
        List<String> travelVoteChoiceContentList = new ArrayList<>();
        for(TravelVoteResultEntity travelVoteResultEntity : travelVoteResultEntitys) travelVoteChoiceContentList.add(travelVoteResultEntity.getTravelVoteResultChoice());
        this.travelVoteNumber = travelVoteEntity.getTravelVoteNumber();
        this.travelVoteTitle = travelVoteEntity.getTravelVoteTitle();
        this.userId = travelVoteEntity.getUserId();
        this.travelVotePhoto1 = travelVoteEntity.getTravelVotePhoto1();
        this.travelVotePhoto2 = travelVoteEntity.getTravelVotePhoto2();
        this.travelVoteChoice1 = travelVoteEntity.getTravelVoteChoice1();
        this.travelVoteChoice2 = travelVoteEntity.getTravelVoteChoice2();
        this.travelVoteChoiceUserList = travelVoteChoiceUserList;
        this.travelVoteChoiceContentList = travelVoteChoiceContentList;
        this.travelVoteDate = travelVoteEntity.getTravelVoteDate();
    }

    public static List<TravelVote> getList(List<TravelVoteEntity> travelVoteEntities , List<TravelVoteResultEntity> travelVoteResultEntitys){
        List<TravelVote> travelVotes = new ArrayList<>();
        for(TravelVoteEntity travelVoteEntity : travelVoteEntities){
            TravelVote travelVote = new TravelVote(travelVoteEntity, travelVoteResultEntitys);
            travelVotes.add(travelVote);
        }
        return travelVotes;
    }
}
