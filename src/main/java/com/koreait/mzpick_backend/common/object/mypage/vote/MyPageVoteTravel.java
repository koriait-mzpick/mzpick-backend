package com.koreait.mzpick_backend.common.object.mypage.vote;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.TravelVoteEntity;

import lombok.Getter;
@Getter
public class MyPageVoteTravel {
    
   private Integer mypageVoteNumber;
    private String mypageVoteTitle;
    private String userId;
    private LocalDateTime mypageVoteDate;
    
    public MyPageVoteTravel(TravelVoteEntity travelVoteEntity) {
        this.mypageVoteNumber = travelVoteEntity.getTravelVoteNumber();
        this.mypageVoteTitle = travelVoteEntity.getTravelVoteTitle();
        this.userId = travelVoteEntity.getUserId();
        this.mypageVoteDate = travelVoteEntity.getTravelVoteDate().minusHours(9);;
    }

    public static List<MyPageVoteTravel> getMyPageVoteTravleList(List<TravelVoteEntity> travelVoteEntities) {

         List<MyPageVoteTravel> myPageVoteTravels = new ArrayList<>();

        for (TravelVoteEntity travelVoteEntity: travelVoteEntities) {
            MyPageVoteTravel myPageVoteTravel = new MyPageVoteTravel(travelVoteEntity);
            myPageVoteTravels.add(myPageVoteTravel);
        }
        return myPageVoteTravels;
    }



}
