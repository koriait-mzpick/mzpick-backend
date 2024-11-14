package com.koreait.mzpick_backend.common.object.vote;

import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.FashionVoteResultEntity;

import lombok.Getter;

@Getter
public class FashionVoteResult {
    private String userId;
    private String selected;

    private FashionVoteResult(FashionVoteResultEntity fashionVoteResultEntity) {
        this.userId = fashionVoteResultEntity.getUserId();
        this.selected = fashionVoteResultEntity.getFashionVoteResultChoice();
    }

    public static List<FashionVoteResult> getList(List<FashionVoteResultEntity> fashionVoteResultEntities) {
        List<FashionVoteResult> list = new ArrayList<>();

        for (FashionVoteResultEntity fashionVoteResultEntity: fashionVoteResultEntities) {
            FashionVoteResult fashionVoteResult = new FashionVoteResult(fashionVoteResultEntity);
            list.add(fashionVoteResult);
        }

        return list;
    }
}
