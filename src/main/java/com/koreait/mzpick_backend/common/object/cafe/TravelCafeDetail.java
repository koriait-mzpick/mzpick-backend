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

// 여행 카페 게시글의 상세 정보를 담는 DTO 클래스
@Getter
public class TravelCafeDetail {
    // 게시글 번호
    private Integer travelCafeNumber;
    // 여행 위치
    private String travelLocation;
    // 작성자 ID
    private String userId;
    // 게시글 제목
    private String travelCafeTitle;
    // 카테고리 목록
    private List<String> travelCafeCategoryList;
    // 사진 URL 목록
    private List<String> travelCafePhotoList;
    // 해시태그 목록
    private List<String> travelCafeHashtagList;
    // 좋아요한 사용자 ID 목록
    private List<String> travelCafeLikeUserList;
    // 저장한 사용자 ID 목록
    private List<String> travelCafeSaveUserList;
    // 좋아요 수
    private Integer travelCafeLikeCount;
    // 저장 수
    private Integer travelCafeSaveCount;
    // 조회수
    private Integer travelCafeView;
    // 게시글 내용
    private String travelCafeContent;
    // 작성일시
    private LocalDateTime travelCafeDate;

    // Entity들을 DTO로 변환하는 생성자
    public TravelCafeDetail(TravelCafeEntity travelCafeEntity,
            List<TravelCafePhotoEntity> travelCafePhotoEntities,
            List<TravelCafeHashtagEntity> travelCafeHashtagEntities,
            List<TravelCafeLikeEntity> travelCafeLikeEntities,
            List<TravelCafeSaveEntity> travelCafeSaveEntities,
            List<TravelCafeCategoryEntity> travelCafeCategoryEntities) {

        // 사진 URL 목록 변환
        List<String> travelCafePhotoList = new ArrayList<>();
        for (TravelCafePhotoEntity travelCafePhotoEntity : travelCafePhotoEntities)
            travelCafePhotoList.add(travelCafePhotoEntity.getTravelCafePhotoLink());

        // 해시태그 목록 변환
        List<String> travelCafeHashtagList = new ArrayList<>();
        for (TravelCafeHashtagEntity travelCafeHashtagEntitiy : travelCafeHashtagEntities)
            travelCafeHashtagList.add(travelCafeHashtagEntitiy.getTravelCafeHashtagContent());

        // 좋아요한 사용자 목록 변환
        List<String> travelCafeLikeUserList = new ArrayList<>();
        for (TravelCafeLikeEntity travelCafeLikeEntity : travelCafeLikeEntities)
            travelCafeLikeUserList.add(travelCafeLikeEntity.getUserId());

        // 저장한 사용자 목록 변환
        List<String> travelCafeSaveUserList = new ArrayList<>();
        for (TravelCafeSaveEntity travelCafeSaveEntity : travelCafeSaveEntities)
            travelCafeSaveUserList.add(travelCafeSaveEntity.getUserId());

        // 카테고리 목록 변환
        List<String> travelCafeCategoryList = new ArrayList<>();
        for (TravelCafeCategoryEntity TravelCafeCategoryEntity : travelCafeCategoryEntities)
            travelCafeCategoryList.add(TravelCafeCategoryEntity.getTravelCafeCategoryContent());

        // DTO 필드 초기화
        this.travelCafeNumber = travelCafeEntity.getTravelCafeNumber();
        this.travelCafeTitle = travelCafeEntity.getTravelCafeTitle();
        this.travelLocation = travelCafeEntity.getTravelLocation();
        this.userId = travelCafeEntity.getUserId();
        this.travelCafeCategoryList = travelCafeCategoryList;
        this.travelCafeHashtagList = travelCafeHashtagList;
        this.travelCafePhotoList = travelCafePhotoList;
        this.travelCafeLikeUserList = travelCafeLikeUserList;
        this.travelCafeSaveUserList = travelCafeSaveUserList;
        this.travelCafeLikeCount = travelCafeLikeUserList.size();
        this.travelCafeSaveCount = travelCafeSaveUserList.size();
        this.travelCafeView = travelCafeEntity.getTravelCafeViewCount();
        // 서버 시간과 클라이언트 시간의 차이를 보정하기 위해 9시간 차감
        this.travelCafeDate = travelCafeEntity.getTravelCafeDate().minusHours(9);
        this.travelCafeContent = travelCafeEntity.getTravelCafeContent();
    }
}
