package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;

import lombok.Getter;
// 마이페이지의 맛집 게시글 정보를 담는 클래스
@Getter
public class MyPageBoardFood {
    
    // 게시글 번호
    private Integer mypageBoardNumber;
    // 게시글 제목
    private String mypageBoardTitle;
    // 작성자 ID
    private String userId;
    // 게시글 작성 날짜
    private LocalDateTime mypageBoardDate;

    // TravelFoodEntity를 MyPageBoardFood로 변환하는 생성자
    public MyPageBoardFood(TravelFoodEntity travelFoodEntity) {
        this.userId = travelFoodEntity.getUserId();
        this.mypageBoardNumber = travelFoodEntity.getTravelFoodNumber();
        this.mypageBoardTitle = travelFoodEntity.getTravelFoodTitle();
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageBoardDate = travelFoodEntity.getTravelFoodDate().minusHours(9);
    }

    // TravelFoodEntity 리스트를 MyPageBoardFood 리스트로 변환하는 정적 메소드
    public static List<MyPageBoardFood> getMyPageBoardFoodList(List<TravelFoodEntity> travelFoodEntities) {
        List<MyPageBoardFood> myPageBoardFoods = new ArrayList<>();

        // 각 TravelFoodEntity를 MyPageBoardFood로 변환하여 리스트에 추가
        for (TravelFoodEntity travelFoodEntity: travelFoodEntities) {
            MyPageBoardFood myPageBoardFood = new MyPageBoardFood(travelFoodEntity);
            myPageBoardFoods.add(myPageBoardFood);
        }
        return myPageBoardFoods;
    }
}
