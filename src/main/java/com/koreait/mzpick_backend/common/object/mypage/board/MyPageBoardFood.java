package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;

import lombok.Getter;
@Getter
public class MyPageBoardFood {
    
    private Integer mypageBoardNumber;
    private String mypageBoardTitle;
    private String userId;
    private LocalDateTime mypageBoardDate;

    public MyPageBoardFood(TravelFoodEntity travelFoodEntity) {
        this.userId = travelFoodEntity.getUserId();
        this.mypageBoardNumber = travelFoodEntity.getTravelFoodNumber();
        this.mypageBoardTitle = travelFoodEntity.getTravelFoodTitle();
        this.mypageBoardDate = travelFoodEntity.getTravelFoodDate().minusHours(9);;
    }

    public static List<MyPageBoardFood> getMyPageBoardFoodList(List<TravelFoodEntity> travelFoodEntities) {
        List<MyPageBoardFood> myPageBoardFoods = new ArrayList<>();

        for (TravelFoodEntity travelFoodEntity: travelFoodEntities) {
            MyPageBoardFood myPageBoardFood = new MyPageBoardFood(travelFoodEntity);
            myPageBoardFoods.add(myPageBoardFood);
        }
        return myPageBoardFoods;
    }


}
