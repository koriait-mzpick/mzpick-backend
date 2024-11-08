package com.koreait.mzpick_backend.common.object.mypage.vote;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.FashionVoteEntity;

import lombok.Getter;
@Getter
public class MyPageVoteFashion {
    private Integer mypageVoteNumber;
    private String mypageVoteTitle;
    private String userId;
    private LocalDateTime mypageVoteDate;
    
    public MyPageVoteFashion(FashionVoteEntity fashionVoteEntity) {
        this.mypageVoteNumber = fashionVoteEntity.getFashionVoteNumber();
        this.mypageVoteTitle = fashionVoteEntity.getFashionVoteTitle();
        this.userId = fashionVoteEntity.getUserId();
        this.mypageVoteDate = fashionVoteEntity.getFashionVoteDate().minusHours(9);;

    }

    public static List<MyPageVoteFashion> getMyPageVoteFashionList(List<FashionVoteEntity> fashionVoteEntities) {

         List<MyPageVoteFashion> myPageVoteFashions = new ArrayList<>();

        for (FashionVoteEntity fashionVoteEntity: fashionVoteEntities) {
            MyPageVoteFashion myPageVoteFashion = new MyPageVoteFashion(fashionVoteEntity);
            myPageVoteFashions.add(myPageVoteFashion);
        }
        return myPageVoteFashions;
    }

}
