package com.koreait.mzpick_backend.common.object.food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodLikeEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodSaveEntity;

import lombok.Getter;

@Getter
public class TravelFoodDetail {
    private Integer travelFoodNumber;
    private String travelFoodTitle;
    private String travelLocation;
    private String userId;
    private List<String> travelFoodPhotoList;
    private List<String> travelFoodHashtagList;
    private List<String> travelFoodLikeUserList;
    private List<String> travelFoodSaveUserList;
    private Integer travelFoodLikeCount;
    private Integer travelFoodSaveCount;
    private Integer travelFoodViewCount;
    private String travelFoodContent;
    private LocalDateTime travelFoodDate;

    public TravelFoodDetail(TravelFoodEntity travelFoodEntity, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities, List<TravelFoodLikeEntity> travelFoodLikeEntities, List<TravelFoodSaveEntity> travelFoodSaveEntities){

        List<String> travelFoodPhotoList = new ArrayList<>();
        for (TravelFoodPhotoEntity travelFoodPhotoEntity: travelFoodPhotoEntities) travelFoodPhotoList.add(travelFoodPhotoEntity.getTravelFoodPhotoLink());
        
        List<String> travelFoodHashtagList = new ArrayList<>();
        for (TravelFoodHashtagEntity travelFoodHashtagEntitiy: travelFoodHashtagEntities) travelFoodHashtagList.add(travelFoodHashtagEntitiy.getTravelFoodHashtagContent());
        
        List<String> travelFoodLikeUserList = new ArrayList<>();
        for (TravelFoodLikeEntity travelFoodLikeEntity: travelFoodLikeEntities) travelFoodLikeUserList.add(travelFoodLikeEntity.getUserId());

        List<String> travelFoodSaveUserList = new ArrayList<>();
        for (TravelFoodSaveEntity travelFoodSaveEntity: travelFoodSaveEntities) travelFoodSaveUserList.add(travelFoodSaveEntity.getUserId());

        this.travelFoodNumber = travelFoodEntity.getTravelFoodNumber();
        this.travelFoodTitle = travelFoodEntity.getTravelFoodTitle();
        this.travelLocation = travelFoodEntity.getTravelLocation();
        this.userId = travelFoodEntity.getUserId();
        this.travelFoodPhotoList = travelFoodPhotoList;
        this.travelFoodHashtagList = travelFoodHashtagList;
        this.travelFoodLikeUserList = travelFoodLikeUserList;
        this.travelFoodSaveUserList = travelFoodSaveUserList;
        this.travelFoodLikeCount = travelFoodLikeUserList.size();
        this.travelFoodSaveCount = travelFoodSaveUserList.size();
        this.travelFoodViewCount = travelFoodEntity.getTravelFoodViewCount();
        this.travelFoodDate = travelFoodEntity.getTravelFoodDate();
        this.travelFoodContent = travelFoodEntity.getTravelFoodContent();

    }
}

