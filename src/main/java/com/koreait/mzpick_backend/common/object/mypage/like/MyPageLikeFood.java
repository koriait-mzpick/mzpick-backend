package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;

import lombok.Getter;
// 마이페이지의 맛집 좋아요 정보를 담는 클래스
@Getter
public class MyPageLikeFood {
    
    // 게시글 번호
    private Integer mypageBoardNumber;
    // 게시글 대표 사진 링크
    private String mypagePhotoList;
    // 게시글 해시태그 목록
    private List<String> mypageHashTagList;
    // 작성자 ID
    private String userId;
    // 게시글 작성 날짜
    private LocalDateTime mypageBoardDate;

    // TravelFoodEntity와 관련 엔티티들을 MyPageLikeFood로 변환하는 생성자
    public MyPageLikeFood(TravelFoodEntity travelFoodEntity, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities) {

        // 사진 링크 목록 생성
        List<String> myPagePhotoList = new ArrayList<>();
        for (TravelFoodPhotoEntity travelFoodPhotoEntity: travelFoodPhotoEntities) myPagePhotoList.add(travelFoodPhotoEntity.getTravelFoodPhotoLink());

        // 해시태그 목록 생성
        List<String> myPageHashtagList = new ArrayList<>();
        for (TravelFoodHashtagEntity travelFoodHashtagEntity: travelFoodHashtagEntities) myPageHashtagList.add(travelFoodHashtagEntity.getTravelFoodHashtagContent());

        this.userId = travelFoodEntity.getUserId();
        this.mypageBoardNumber = travelFoodEntity.getTravelFoodNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageBoardDate = travelFoodEntity.getTravelFoodDate().minusHours(9);
    }

    // TravelFoodEntity 리스트와 관련 엔티티들을 MyPageLikeFood 리스트로 변환하는 정적 메소드
    public static List<MyPageLikeFood> getMyPageLikeFoodList(List<TravelFoodEntity> travelFoodEntities, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities) {
        List<MyPageLikeFood> myPageLikeFoods = new ArrayList<>();

        // 각 TravelFoodEntity를 MyPageLikeFood로 변환하여 리스트에 추가
        for (TravelFoodEntity travelFoodEntity: travelFoodEntities) {
            MyPageLikeFood myPageLikeFood = new MyPageLikeFood(travelFoodEntity, travelFoodPhotoEntities, travelFoodHashtagEntities);
            myPageLikeFoods.add(myPageLikeFood);
        }
        return myPageLikeFoods;
    }

}
