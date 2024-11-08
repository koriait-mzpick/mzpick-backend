package com.koreait.mzpick_backend.common.object.mypage.save;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafePhotoEntity;

import lombok.Getter;

@Getter
public class MyPageSaveCafe {

    private Integer travelCafeNumber;
    private String travelCafePhoto;
    private List<String> travelCafeHashtagList;
    private LocalDateTime travelCafeDate;

    public MyPageSaveCafe(TravelCafeEntity travelCafeEntity, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities) {
        List<String> travelCafePhotoList = new ArrayList<>();
        for (TravelCafePhotoEntity travelCafePhotoEntity: travelCafePhotoEntities) travelCafePhotoList.add(travelCafePhotoEntity.getTravelCafePhotoLink());

        List<String> travelCafeHashtagList = new ArrayList<>();
        for (TravelCafeHashtagEntity travelCafeHashtagEntity: travelCafeHashtagEntities) travelCafeHashtagList.add(travelCafeHashtagEntity.getTravelCafeHashtagContent());

        this.travelCafeNumber = travelCafeEntity.getTravelCafeNumber();
        this.travelCafePhoto = travelCafePhotoList.get(0);
        this.travelCafeHashtagList = travelCafeHashtagList;
        this.travelCafeDate = travelCafeEntity.getTravelCafeDate().minusHours(9);;
    }

    public static List<MyPageSaveCafe> getList(List<TravelCafeEntity> travelCafeEntities,
            List<TravelCafePhotoEntity> travelCafePhotoEntities,
            List<TravelCafeHashtagEntity> travelCafeHashtagEntities) {
        List<MyPageSaveCafe> myPageSaveCafes = new ArrayList<>();
        for (TravelCafeEntity travelCafeEntity : travelCafeEntities) {
            MyPageSaveCafe myPageSaveCafe = new MyPageSaveCafe(travelCafeEntity, travelCafePhotoEntities,
                    travelCafeHashtagEntities);
            myPageSaveCafes.add(myPageSaveCafe);
        }
        return myPageSaveCafes;
    }

}
