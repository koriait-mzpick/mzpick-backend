package com.koreait.mzpick_backend.common.object.mypage.save;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;

import lombok.Getter;

@Getter
public class MyPageSaveStay {

    private Integer travelStayNumber;
    private String travelStayPhoto;
    private List<String> travelStayHashtagList;
    private LocalDate travelStayDate;

    public MyPageSaveStay(TravelStayEntity travelStayEntity, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities) {
        List<String> travelStayPhotoList = new ArrayList<>();
        for (TravelStayPhotoEntity travelStayPhotoEntity: travelStayPhotoEntities) travelStayPhotoList.add(travelStayPhotoEntity.getTravelStayPhotoLink());

        List<String> travelStayHashtagList = new ArrayList<>();
        for (TravelStayHashtagEntity travelStayHashtagEntity: travelStayHashtagEntities) travelStayHashtagList.add(travelStayHashtagEntity.getTravelStayHashtagContent());

        this.travelStayNumber = travelStayEntity.getTravelStayNumber();
        this.travelStayPhoto = travelStayPhotoList.get(0);
        this.travelStayHashtagList = travelStayHashtagList;
        this.travelStayDate = travelStayEntity.getTravelStayDate();
    }

    public static List<MyPageSaveStay> getList(List<TravelStayEntity> travelStayEntities, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities){
        List<MyPageSaveStay> myPageSaveStays = new ArrayList<>();
        for(TravelStayEntity travelStayEntity: travelStayEntities){
            MyPageSaveStay myPageSaveStay = new MyPageSaveStay (travelStayEntity, travelStayPhotoEntities, travelStayHashtagEntities);
            myPageSaveStays.add(myPageSaveStay);
        }
        return myPageSaveStays;
    }

}
