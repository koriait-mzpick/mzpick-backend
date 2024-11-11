package com.koreait.mzpick_backend.common.object.vote;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.TravelVoteResultEntity;

import lombok.Getter;

@Getter
public class VoteResult {
    private String userId;
    private String selected;

    private VoteResult(TravelVoteResultEntity travelVoteResultEntity) {
        this.userId = travelVoteResultEntity.getUserId();
        this.selected = travelVoteResultEntity.getTravelVoteResultChoice();
    }

    public static List<VoteResult> getList(List<TravelVoteResultEntity> travelVoteResultEntities) {
        List<VoteResult> list = new ArrayList<>();

        for (TravelVoteResultEntity travelVoteResultEntity: travelVoteResultEntities) {
            VoteResult voteResult = new VoteResult(travelVoteResultEntity);
            list.add(voteResult);
        }

        return list;
    }
}
