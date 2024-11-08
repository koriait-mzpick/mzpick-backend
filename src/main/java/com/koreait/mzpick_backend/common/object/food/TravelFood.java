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

// 여행 음식점 게시글의 정보를 담는 DTO 클래스
@Getter
public class TravelFood {
    // 게시글 번호
    private Integer traveFoodNumber;
    // 여행 위치
    private String travelLocation;
    // 작성자 ID
    private String userId;
    // 대표 사진 URL
    private String travelFoodPhoto;
    // 해시태그 목록
    private List<String> travelFoodHashtagList;
    // 좋아요한 사용자 ID 목록
    private List<String> travelFoodLikeUserList;
    // 저장한 사용자 ID 목록
    private List<String> travelFoodSaveUserList;
    // 좋아요 수
    private Integer travelFoodLikeCount;
    // 저장 수
    private Integer travelFoodSaveCount;
    // 조회수
    private Integer travelFoodViewCount;
    // 작성일시
    private LocalDateTime travelFoodDate;

    // Entity들을 DTO로 변환하는 생성자
    public TravelFood(TravelFoodEntity travelFoodEntity,
            List<TravelFoodPhotoEntity> travelFoodPhotoEntities,
            List<TravelFoodHashtagEntity> travelFoodHashtagEntities,
            List<TravelFoodLikeEntity> travelFoodLikeEntities,
            List<TravelFoodSaveEntity> travelFoodSaveEntities) {

        // 사진 URL 목록 변환
        List<String> travelFoodPhotoList = new ArrayList<>();
        for (TravelFoodPhotoEntity travelFoodPhotoEntity : travelFoodPhotoEntities)
            travelFoodPhotoList.add(travelFoodPhotoEntity.getTravelFoodPhotoLink());

        // 해시태그 목록 변환
        List<String> travelFoodHashtagList = new ArrayList<>();
        for (TravelFoodHashtagEntity travelFoodHashtagEntity : travelFoodHashtagEntities)
            travelFoodHashtagList.add(travelFoodHashtagEntity.getTravelFoodHashtagContent());

        // 좋아요한 사용자 목록 변환
        List<String> travelFoodLikeUserList = new ArrayList<>();
        for (TravelFoodLikeEntity travelFoodLikeEntity : travelFoodLikeEntities)
            travelFoodLikeUserList.add(travelFoodLikeEntity.getUserId());

        // 저장한 사용자 목록 변환
        List<String> travelFoodSaveUserList = new ArrayList<>();
        for (TravelFoodSaveEntity travelFoodSaveEntity : travelFoodSaveEntities)
            travelFoodSaveUserList.add(travelFoodSaveEntity.getUserId());

        // DTO 필드 초기화
        this.traveFoodNumber = travelFoodEntity.getTravelFoodNumber();
        this.travelFoodPhoto = travelFoodPhotoList.get(0); // 첫 번째 사진을 대표 사진으로 사용
        this.travelLocation = travelFoodEntity.getTravelLocation();
        this.userId = travelFoodEntity.getUserId();
        this.travelFoodHashtagList = travelFoodHashtagList;
        this.travelFoodLikeUserList = travelFoodLikeUserList;
        this.travelFoodSaveUserList = travelFoodSaveUserList;
        this.travelFoodLikeCount = travelFoodEntity.getTravelFoodLikeCount();
        this.travelFoodSaveCount = travelFoodEntity.getTravelFoodSaveCount();
        this.travelFoodViewCount = travelFoodEntity.getTravelFoodViewCount();
        // 서버 시간과 클라이언트 시간의 차이를 보정하기 위해 9시간 차감
        this.travelFoodDate = travelFoodEntity.getTravelFoodDate().minusHours(9);
    }
}
