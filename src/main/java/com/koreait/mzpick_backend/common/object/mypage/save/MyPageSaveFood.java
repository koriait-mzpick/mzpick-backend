package com.koreait.mzpick_backend.common.object.mypage.save;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;

import lombok.Getter;

@Getter
public class MyPageSaveFood {
    
    private Integer travelFoodNumber;
    private String travelFoodPhoto;
    private List<String> travelFoodHashtagList;
    private LocalDate travelFoodDate;

    public MyPageSaveFood(TravelFoodEntity travelFoodEntity, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities) {
        List<String> travelFoodPhotoList = new ArrayList<>();
        for (TravelFoodPhotoEntity travelFoodPhotoEntity: travelFoodPhotoEntities) travelFoodPhotoList.add(travelFoodPhotoEntity.getTravelFoodPhotoLink());

        List<String> travelFoodHashtagList = new ArrayList<>();
        for (TravelFoodHashtagEntity travelFoodHashtagEntity: travelFoodHashtagEntities) travelFoodHashtagList.add(travelFoodHashtagEntity.getTravelFoodHashtagContent());

        this.travelFoodNumber = travelFoodEntity.getTravelFoodNumber();
        this.travelFoodPhoto = travelFoodPhotoList.get(0);
        this.travelFoodHashtagList = travelFoodHashtagList;
        this.travelFoodDate = travelFoodEntity.getTravelFoodDate();
    }

    public static List<MyPageSaveFood> getList(List<TravelFoodEntity> travelFoodEntities, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities){
        List<MyPageSaveFood> myPageSaveFoods = new ArrayList<>();
        for(TravelFoodEntity travelFoodEntity: travelFoodEntities){
            MyPageSaveFood myPageSaveFood = new MyPageSaveFood (travelFoodEntity, travelFoodPhotoEntities, travelFoodHashtagEntities);
            myPageSaveFoods.add(myPageSaveFood);
        }
        return myPageSaveFoods;
    }
}
