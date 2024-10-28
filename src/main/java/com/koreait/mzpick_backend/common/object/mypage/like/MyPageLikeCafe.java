package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafePhotoEntity;

import lombok.Getter;
@Getter
public class MyPageLikeCafe {
    
    private Integer mypageBoardNumber;
    private String mypagePhotoList;
    private List<String> mypageHashTagList;
    private String userId;
    private LocalDate mypageBoarDate;
    

    public MyPageLikeCafe(TravelCafeEntity travelCafeEntity, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities) {

        
        List<String> myPagePhotoList = new ArrayList<>();
        for (TravelCafePhotoEntity travelCafePhotoEntity: travelCafePhotoEntities) myPagePhotoList.add(travelCafePhotoEntity.getTravelCafePhotoLink());

        List<String> myPageHashtagList = new ArrayList<>();
        for (TravelCafeHashtagEntity travelCafeHashtagEntity: travelCafeHashtagEntities) myPageHashtagList.add(travelCafeHashtagEntity.getTravelCafeHashtagContent());

        this.userId = travelCafeEntity.getUserId();
        this.mypageBoardNumber = travelCafeEntity.getTravelCafeNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        this.mypageBoarDate = travelCafeEntity.getTravelCafeDate();
    }

    public static List<MyPageLikeCafe> getMyPageLikeCafeList(List<TravelCafeEntity> travelCafeEntities, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities) {
        List<MyPageLikeCafe> myPageLikeCafes = new ArrayList<>();

        for (TravelCafeEntity travelCafeEntity: travelCafeEntities) {
            MyPageLikeCafe myPageLikeCafe = new MyPageLikeCafe(travelCafeEntity, travelCafePhotoEntities, travelCafeHashtagEntities);
            myPageLikeCafes.add(myPageLikeCafe);
        }
        return myPageLikeCafes;
    }



}
