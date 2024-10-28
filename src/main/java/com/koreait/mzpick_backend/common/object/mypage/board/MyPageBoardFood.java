package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;

import lombok.Getter;
@Getter
public class MyPageBoardFood {
    
    private Integer mypageBoardNumber;
    private String mypageBoardTitle;
    private String userId;
    private LocalDate mypageBoardDate;

    public MyPageBoardFood(FashionEntity fashionEntity) {
        this.userId = fashionEntity.getUserId();
        this.mypageBoardNumber = fashionEntity.getFashionNumber();
        this.mypageBoardTitle = fashionEntity.getFashionTitle();
        this.mypageBoardDate = fashionEntity.getFashionDate();
    }

    public static List<MyPageBoardFood> getMyPageBoardFoodList(List<FashionEntity> fashionEntities) {
        List<MyPageBoardFood> myPageBoardFoods = new ArrayList<>();

        for (FashionEntity fashionEntity: fashionEntities) {
            MyPageBoardFood myPageBoardFood = new MyPageBoardFood(fashionEntity);
            myPageBoardFoods.add(myPageBoardFood);
        }
        return myPageBoardFoods;
    }


}
