package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;

import lombok.Getter;
@Getter
public class MyPageLikeTravel {
    
    private Integer mypageBoardNumber;
    private String mypagePhotoList;
    private List<String> mypageHashTagList;
    private String userId;
    private LocalDate mypageBoardDate;
    

    public MyPageLikeTravel(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities) {

        
        List<String> myPagePhotoList = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) myPagePhotoList.add(travelPhotoEntity.getTravelPhotoLink());

        List<String> myPageHashtagList = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntity: travelHashtagEntities) myPageHashtagList.add(travelHashtagEntity.getTravelHashtagContent());

        this.userId = travelEntity.getUserId();
        this.mypageBoardNumber = travelEntity.getTravelNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        this.mypageBoardDate = travelEntity.getTravelDate();
    }

    public static List<MyPageLikeTravel> getMyPageLikeTravelList(List<TravelEntity> travelEntities, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities) {
        List<MyPageLikeTravel> myPageLikeTravels = new ArrayList<>();

        for (TravelEntity travelEntity: travelEntities) {
            MyPageLikeTravel myPageLikeTravel = new MyPageLikeTravel(travelEntity, travelPhotoEntities, travelHashtagEntities);
            myPageLikeTravels.add(myPageLikeTravel);
        }
        return myPageLikeTravels;
    }



}
