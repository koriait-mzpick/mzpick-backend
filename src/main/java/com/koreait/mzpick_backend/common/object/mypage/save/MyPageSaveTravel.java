package com.koreait.mzpick_backend.common.object.mypage.save;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;

import lombok.Getter;
@Getter
public class MyPageSaveTravel {
    
    private Integer travelNumber;
    private String travelPhoto;
    private List<String> travelHashtagList;
    private LocalDateTime travelDate;

    public MyPageSaveTravel(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities) {
        List<String> travelPhotoList = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) travelPhotoList.add(travelPhotoEntity.getTravelPhotoLink());
        
        List<String> travelHashtagList = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntity: travelHashtagEntities) travelHashtagList.add(travelHashtagEntity.getTravelHashtagContent());

        this.travelNumber = travelEntity.getTravelNumber();
        this.travelPhoto = travelPhotoList.get(0);
        this.travelHashtagList = travelHashtagList;
        this.travelDate = travelEntity.getTravelDate();
    }

    public static List<MyPageSaveTravel> getList(List<TravelEntity> travelEntities, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities){
        List<MyPageSaveTravel> myPageSaveTravels = new ArrayList<>();
        for(TravelEntity travelEntity: travelEntities){
            MyPageSaveTravel myPageSaveTravel = new MyPageSaveTravel (travelEntity, travelPhotoEntities, travelHashtagEntities);
            myPageSaveTravels.add(myPageSaveTravel);
        }
        return myPageSaveTravels;
    }
}
