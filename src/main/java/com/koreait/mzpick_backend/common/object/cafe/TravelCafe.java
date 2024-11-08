package com.koreait.mzpick_backend.common.object.cafe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeCategoryEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeLikeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafePhotoEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeSaveEntity;

import lombok.Getter;

/**
 * 여행 카페 정보를 담는 클래스
 * Entity 객체들을 통합하여 클라이언트에게 제공할 데이터를 구성
 */
@Getter
public class TravelCafe {
    // 여행 카페 게시물 번호
    private Integer traveCafeNumber;
    // 여행 위치 정보
    private String travelLocation;
    // 작성자 ID
    private String userId;
    // 카페 카테고리 목록
    private List<String> travelCafeCategoryList;
    // 대표 사진 URL
    private String travelCafePhoto;
    // 해시태그 목록
    private List<String> travelCafeHashtagList;
    // 좋아요한 사용자 목록
    private List<String> travelCafeLikeUserList;
    // 저장한 사용자 목록
    private List<String> travelCafeSaveUserList;
    // 좋아요 수
    private Integer travelCafeLikeCount;
    // 저장 수
    private Integer travelCafeSaveCount;
    // 조회수
    private Integer travelCafeView;
    // 게시물 작성일자
    private LocalDateTime travelCafeDate;

    /**
     * TravelCafe 객체 생성자
     * 각 Entity 객체들을 통합하여 하나의 TravelCafe 객체로 변환
     * 
     * @param travelCafeEntity           기본 카페 정보 Entity
     * @param travelCafePhotoEntities    카페 사진 Entity 목록
     * @param travelCafeHashtagEntities  해시태그 Entity 목록
     * @param travelCafeCategoryEntities 카테고리 Entity 목록
     * @param travelCafeLikeEntities     좋아요 Entity 목록
     * @param travelCafeSaveEntities     저장 Entity 목록
     */
    public TravelCafe(TravelCafeEntity travelCafeEntity,
            List<TravelCafePhotoEntity> travelCafePhotoEntities,
            List<TravelCafeHashtagEntity> travelCafeHashtagEntities,
            List<TravelCafeCategoryEntity> travelCafeCategoryEntities,
            List<TravelCafeLikeEntity> travelCafeLikeEntities,
            List<TravelCafeSaveEntity> travelCafeSaveEntities) {

        // 사진 URL 목록 변환
        List<String> travelCafePhotoList = new ArrayList<>();
        for (TravelCafePhotoEntity travelCafePhotoEntity : travelCafePhotoEntities)
            travelCafePhotoList.add(travelCafePhotoEntity.getTravelCafePhotoLink());

        // 해시태그 목록 변환
        List<String> travelCafeHashtagList = new ArrayList<>();
        for (TravelCafeHashtagEntity travelCafeHashtagEntity : travelCafeHashtagEntities)
            travelCafeHashtagList.add(travelCafeHashtagEntity.getTravelCafeHashtagContent());

        // 카테고리 목록 변환
        List<String> travelCafeCategoryList = new ArrayList<>();
        for (TravelCafeCategoryEntity travelCafeCategoryEntity : travelCafeCategoryEntities)
            travelCafeCategoryList.add(travelCafeCategoryEntity.getTravelCafeCategoryContent());

        // 좋아요한 사용자 목록 변환
        List<String> travelCafeLikeUserList = new ArrayList<>();
        for (TravelCafeLikeEntity travelCafeLikeEntity : travelCafeLikeEntities)
            travelCafeLikeUserList.add(travelCafeLikeEntity.getUserId());

        // 저장한 사용자 목록 변환
        List<String> travelCafeSaveUserList = new ArrayList<>();
        for (TravelCafeSaveEntity travelCafeSaveEntity : travelCafeSaveEntities)
            travelCafeSaveUserList.add(travelCafeSaveEntity.getUserId());

        // 객체 필드 초기화
        this.traveCafeNumber = travelCafeEntity.getTravelCafeNumber();
        this.travelCafePhoto = travelCafePhotoList.get(0); // 첫 번째 사진을 대표 사진으로 설정
        this.travelLocation = travelCafeEntity.getTravelLocation();
        this.userId = travelCafeEntity.getUserId();
        this.travelCafeHashtagList = travelCafeHashtagList;
        this.travelCafeCategoryList = travelCafeCategoryList;
        this.travelCafeLikeUserList = travelCafeLikeUserList;
        this.travelCafeSaveUserList = travelCafeSaveUserList;
        this.travelCafeLikeCount = travelCafeEntity.getTravelCafeLikeCount();
        this.travelCafeSaveCount = travelCafeEntity.getTravelCafeSaveCount();
        this.travelCafeView = travelCafeEntity.getTravelCafeViewCount();
        this.travelCafeDate = travelCafeEntity.getTravelCafeDate().minusHours(9); // UTC to KST 변환
    }
}
