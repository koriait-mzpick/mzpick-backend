package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;

import lombok.Getter;
@Getter
public class MyPageLikeStay {
    
    private Integer mypageBoardNumber;
    private String mypagePhotoList;
    private List<String> mypageHashTagList;
    private String userId;
    private LocalDate mypageBoarDate;

    public MyPageLikeStay(TravelStayEntity travelStayEntity, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities) {

        
        List<String> myPagePhotoList = new ArrayList<>();
        for (TravelStayPhotoEntity travelStayPhotoEntity: travelStayPhotoEntities) myPagePhotoList.add(travelStayPhotoEntity.getTravelStayPhotoLink());

        List<String> myPageHashtagList = new ArrayList<>();
        for (TravelStayHashtagEntity travelStayHashtagEntity: travelStayHashtagEntities) myPageHashtagList.add(travelStayHashtagEntity.getTravelStayHashtagContent());


        

        this.userId = travelStayEntity.getUserId();
        this.mypageBoardNumber = travelStayEntity.getTravelStayNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        this.mypageBoarDate = travelStayEntity.getTravelStayDate();
    }

    public static List<MyPageLikeStay> getMyPageLikeStayList(List<TravelStayEntity> travelStayEntities, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities) {
        List<MyPageLikeStay> myPageLikeStays = new ArrayList<>();

        for (TravelStayEntity travelStayEntity: travelStayEntities) {
            MyPageLikeStay myPageLikeStay = new MyPageLikeStay(travelStayEntity, travelStayPhotoEntities, travelStayHashtagEntities);
            myPageLikeStays.add(myPageLikeStay);
        }
        return myPageLikeStays;
    }


}
