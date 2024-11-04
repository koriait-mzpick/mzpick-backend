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
public class TravelCafeDetail {
    private Integer travelCafeNumber;
    private String travelLocation;
    private String userId;
    private String travelCafeTitle;
    private List<String> travelCafeCategoryList;
    private List<String> travelCafePhotoList;
    private List<String> travelCafeHashtagList;
    private List<String> travelCafeLikeUserList;
    private List<String> travelCafeSaveUserList;
    private Integer travelCafeLikeCount;
    private Integer travelCafeSaveCount;
    private Integer travelCafeView;
    private LocalDateTime travelCafeDate;

    public TravelCafeDetail(TravelCafeEntity travelCafeEntity, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities, List<TravelCafeLikeEntity> travelCafeLikeEntities, List<TravelCafeSaveEntity> travelCafeSaveEntities, List<TravelCafeCategoryEntity> travelCafeCategoryEntities){

        List<String> travelCafePhotoList = new ArrayList<>();
        for (TravelCafePhotoEntity travelCafePhotoEntity: travelCafePhotoEntities) travelCafePhotoList.add(travelCafePhotoEntity.getTravelCafePhotoLink());
        
        List<String> travelCafeHashtagList = new ArrayList<>();
        for (TravelCafeHashtagEntity travelCafeHashtagEntitiy: travelCafeHashtagEntities) travelCafeHashtagList.add(travelCafeHashtagEntitiy.getTravelCafeHashtagContent());
        
        List<String> travelCafeLikeUserList = new ArrayList<>();
        for (TravelCafeLikeEntity travelCafeLikeEntity: travelCafeLikeEntities) travelCafeLikeUserList.add(travelCafeLikeEntity.getUserId());

        List<String> travelCafeSaveUserList = new ArrayList<>();
        for (TravelCafeSaveEntity travelCafeSaveEntity: travelCafeSaveEntities) travelCafeSaveUserList.add(travelCafeSaveEntity.getUserId());

        List<String> travelCafeCategoryList = new ArrayList<>();
        for (TravelCafeCategoryEntity TravelCafeCategoryEntity: travelCafeCategoryEntities) travelCafeCategoryList.add(TravelCafeCategoryEntity.getTravelCafeCategoryContent());

        this.travelCafeNumber = travelCafeEntity.getTravelCafeNumber();
        this.travelCafeTitle = travelCafeEntity.getTravelCafeTitle();
        this.travelLocation = travelCafeEntity.getTravelLocation();
        this.userId = travelCafeEntity.getUserId();
        this.travelCafeCategoryList = travelCafeCategoryList;
        this.travelCafeHashtagList = travelCafeHashtagList;
        this.travelCafePhotoList = travelCafePhotoList;
        this.travelCafeLikeUserList = travelCafeLikeUserList;
        this.travelCafeSaveUserList = travelCafeSaveUserList;
        this.travelCafeLikeCount = travelCafeLikeUserList.size();
        this.travelCafeSaveCount = travelCafeSaveUserList.size();
        this.travelCafeView = travelCafeEntity.getTravelCafeViewCount();
        this.travelCafeDate = travelCafeEntity.getTravelCafeDate();
    }
}

