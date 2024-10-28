package com.koreait.mzpick_backend.common.object.food;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodLikeEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodSaveEntity;

import lombok.Getter;

@Getter
public class TravelFood {
    private Integer traveFoodNumber;
    private String travelFoodPhoto;
    private List<String> travelFoodHashtagList;
    private List<String> travelFoodLikeUserList;
    private List<String> travelFoodSaveUserList;
    private Integer travelFoodLikeCount;
    private Integer travelFoodSaveCount;
    private Integer travelFoodViewCount;
    private LocalDate travelFoodDate;

    public TravelFood (TravelFoodEntity travelFoodEntity, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities, List<TravelFoodLikeEntity> travelFoodLikeEntities, List<TravelFoodSaveEntity> travelFoodSaveEntities ) {
        List<String> travelFoodPhotoList = new ArrayList<>();
        for (TravelFoodPhotoEntity travelFoodPhotoEntity: travelFoodPhotoEntities) travelFoodPhotoList.add(travelFoodPhotoEntity.getTravelFoodPhotoLink());
        
        List<String> travelFoodHashtagList = new ArrayList<>();
        for (TravelFoodHashtagEntity travelFoodHashtagEntity: travelFoodHashtagEntities) travelFoodHashtagList.add(travelFoodHashtagEntity.getTravelFoodHashtagContent());
        
        List<String> travelFoodLikeUserList = new ArrayList<>();
        for (TravelFoodLikeEntity travelFoodLikeEntity: travelFoodLikeEntities) travelFoodLikeUserList.add(travelFoodLikeEntity.getUserId());

        List<String> travelFoodSaveUserList = new ArrayList<>();
        for (TravelFoodSaveEntity travelFoodSaveEntity: travelFoodSaveEntities) travelFoodSaveUserList.add(travelFoodSaveEntity.getUserId());
        this.traveFoodNumber = travelFoodEntity.getTravelFoodNumber();
        this.travelFoodPhoto = travelFoodPhotoList.get(0);
        this.travelFoodHashtagList = travelFoodHashtagList;
        this.travelFoodLikeUserList = travelFoodLikeUserList;
        this.travelFoodSaveUserList = travelFoodSaveUserList;
        this.travelFoodLikeCount = travelFoodEntity.getTravelFoodLikeCount();
        this.travelFoodSaveCount = travelFoodEntity.getTravelFoodSaveCount();
        this.travelFoodViewCount = travelFoodEntity.getTravelFoodViewCount();
        this.travelFoodDate = travelFoodEntity.getTravelFoodDate();
        
    }

    public static List<TravelFood> getList(List<TravelFoodEntity> travelFoodEntities, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities, List<TravelFoodLikeEntity> travelFoodLikeEntities, List<TravelFoodSaveEntity> travelFoodSaveEntities ) {
        List<TravelFood> travelFoods = new ArrayList<>();

        for (TravelFoodEntity travelFoodEntity: travelFoodEntities) {
            TravelFood travelFood = new TravelFood(travelFoodEntity, travelFoodPhotoEntities, travelFoodHashtagEntities, travelFoodLikeEntities, travelFoodSaveEntities);
            travelFoods.add(travelFood);
        }
        return travelFoods;
    }
}

