package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;

import lombok.Getter;
@Getter
public class MyPageLikeFood {
    
      private Integer mypageBoardNumber;
    private String mypagePhotoList;
    private List<String> mypageHashTagList;
    private String userId;
    private LocalDateTime mypageBoardDate;

    public MyPageLikeFood(TravelFoodEntity travelFoodEntity, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities) {

        
        List<String> myPagePhotoList = new ArrayList<>();
        for (TravelFoodPhotoEntity travelFoodPhotoEntity: travelFoodPhotoEntities) myPagePhotoList.add(travelFoodPhotoEntity.getTravelFoodPhotoLink());

        List<String> myPageHashtagList = new ArrayList<>();
        for (TravelFoodHashtagEntity travelFoodHashtagEntity: travelFoodHashtagEntities) myPageHashtagList.add(travelFoodHashtagEntity.getTravelFoodHashtagContent());


        this.userId = travelFoodEntity.getUserId();
        this.mypageBoardNumber = travelFoodEntity.getTravelFoodNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        this.mypageBoardDate = travelFoodEntity.getTravelFoodDate().minusHours(9);;
    }

    public static List<MyPageLikeFood> getMyPageLikeFoodList(List<TravelFoodEntity> travelFoodEntities, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities) {
        List<MyPageLikeFood> myPageLikeFoods = new ArrayList<>();

        for (TravelFoodEntity travelFoodEntity: travelFoodEntities) {
            MyPageLikeFood myPageLikeFood = new MyPageLikeFood(travelFoodEntity, travelFoodPhotoEntities, travelFoodHashtagEntities);
            myPageLikeFoods.add(myPageLikeFood);
        }
        return myPageLikeFoods;
    }

}
