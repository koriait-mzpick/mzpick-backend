package com.koreait.mzpick_backend.common.object.mypage.save;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;

import lombok.Getter;

// 마이페이지의 맛집 저장 정보를 담는 클래스
@Getter
public class MyPageSaveFood {
    
    // 게시글 번호
    private Integer travelFoodNumber;
    // 게시글 대표 사진 링크
    private String travelFoodPhoto;
    // 게시글 해시태그 목록
    private List<String> travelFoodHashtagList;
    // 게시글 작성 날짜
    private LocalDateTime travelFoodDate;

    // TravelFoodEntity와 관련 엔티티들을 MyPageSaveFood로 변환하는 생성자
    public MyPageSaveFood(TravelFoodEntity travelFoodEntity, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities) {
        // 사진 링크 목록 생성
        List<String> travelFoodPhotoList = new ArrayList<>();
        for (TravelFoodPhotoEntity travelFoodPhotoEntity: travelFoodPhotoEntities) travelFoodPhotoList.add(travelFoodPhotoEntity.getTravelFoodPhotoLink());

        // 해시태그 목록 생성
        List<String> travelFoodHashtagList = new ArrayList<>();
        for (TravelFoodHashtagEntity travelFoodHashtagEntity: travelFoodHashtagEntities) travelFoodHashtagList.add(travelFoodHashtagEntity.getTravelFoodHashtagContent());

        this.travelFoodNumber = travelFoodEntity.getTravelFoodNumber();
        this.travelFoodPhoto = travelFoodPhotoList.get(0);
        this.travelFoodHashtagList = travelFoodHashtagList;
        // 시간대 보정을 위해 9시간을 뺌
        this.travelFoodDate = travelFoodEntity.getTravelFoodDate().minusHours(9);
    }

    // TravelFoodEntity 리스트와 관련 엔티티들을 MyPageSaveFood 리스트로 변환하는 정적 메소드
    public static List<MyPageSaveFood> getList(List<TravelFoodEntity> travelFoodEntities, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities) {
        List<MyPageSaveFood> myPageSaveFoods = new ArrayList<>();
        // 각 TravelFoodEntity를 MyPageSaveFood로 변환하여 리스트에 추가
        for (TravelFoodEntity travelFoodEntity: travelFoodEntities) {
            MyPageSaveFood myPageSaveFood = new MyPageSaveFood(travelFoodEntity, travelFoodPhotoEntities, travelFoodHashtagEntities);
            myPageSaveFoods.add(myPageSaveFood);
        }
        return myPageSaveFoods;
    }
}
