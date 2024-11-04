package com.koreait.mzpick_backend.common.object.cafe;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeCategoryEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeLikeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafePhotoEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeSaveEntity;

import lombok.Getter;

@Getter
public class TravelCafe {
    private Integer traveCafeNumber;
    private String travelLocation;
    private String userId;
    private List<String> travelCafeCategoryList;
    private String travelCafePhoto;
    private List<String> travelCafeHashtagList;
    private List<String> travelCafeLikeUserList;
    private List<String> travelCafeSaveUserList;
    private Integer travelCafeLikeCount;
    private Integer travelCafeSaveCount;
    private Integer travelCafeView;
    private LocalDateTime travelCafeDate;

    public TravelCafe (TravelCafeEntity travelCafeEntity, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities, List<TravelCafeCategoryEntity> travelCafeCategoryEntities, List<TravelCafeLikeEntity> travelCafeLikeEntities, List<TravelCafeSaveEntity> travelCafeSaveEntities ) {
        List<String> travelCafePhotoList = new ArrayList<>();
        for (TravelCafePhotoEntity travelCafePhotoEntity: travelCafePhotoEntities) travelCafePhotoList.add(travelCafePhotoEntity.getTravelCafePhotoLink());
        
        List<String> travelCafeHashtagList = new ArrayList<>();
        for (TravelCafeHashtagEntity travelCafeHashtagEntity: travelCafeHashtagEntities) travelCafeHashtagList.add(travelCafeHashtagEntity.getTravelCafeHashtagContent());
        
        List<String> travelCafeCategoryList = new ArrayList<>();
        for (TravelCafeCategoryEntity travelCafeCategoryEntity: travelCafeCategoryEntities) travelCafeCategoryList.add(travelCafeCategoryEntity.getTravelCafeCategoryContent());

        List<String> travelCafeLikeUserList = new ArrayList<>();
        for (TravelCafeLikeEntity travelCafeLikeEntity: travelCafeLikeEntities) travelCafeLikeUserList.add(travelCafeLikeEntity.getUserId());

        List<String> travelCafeSaveUserList = new ArrayList<>();
        for (TravelCafeSaveEntity travelCafeSaveEntity: travelCafeSaveEntities) travelCafeSaveUserList.add(travelCafeSaveEntity.getUserId());

        this.traveCafeNumber = travelCafeEntity.getTravelCafeNumber();
        this.travelCafePhoto = travelCafePhotoList.get(0);
        this.travelLocation = travelCafeEntity.getTravelLocation();
        this.userId = travelCafeEntity.getUserId();
        this.travelCafeHashtagList = travelCafeHashtagList;
        this.travelCafeCategoryList = travelCafeCategoryList;
        this.travelCafeLikeUserList = travelCafeLikeUserList;
        this.travelCafeSaveUserList = travelCafeSaveUserList;
        this.travelCafeLikeCount = travelCafeEntity.getTravelCafeLikeCount();
        this.travelCafeSaveCount = travelCafeEntity.getTravelCafeSaveCount();
        this.travelCafeView = travelCafeEntity.getTravelCafeViewCount();
        this.travelCafeDate = travelCafeEntity.getTravelCafeDate();
        
    }
}

