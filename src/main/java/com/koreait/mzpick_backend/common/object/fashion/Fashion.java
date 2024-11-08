package com.koreait.mzpick_backend.common.object.fashion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionLikeEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionSaveEntity;

import lombok.Getter;

// 패션 게시글의 정보를 담는 DTO 클래스
@Getter
public class Fashion {
    // 게시글 번호
    private Integer fashionNumber;
    // 작성자 ID
    private String userId;
    // 대표 사진 URL
    private String fashionPhoto;
    // 해시태그 목록
    private List<String> fashionHashtagList;
    // 좋아요한 사용자 ID 목록
    private List<String> fashionLikeUserList;
    // 저장한 사용자 ID 목록
    private List<String> fashionSaveUserList;
    // 저장 수
    private Integer fashionSaveCount;
    // 좋아요 수
    private Integer fashionLikeCount;
    // 총 가격
    private Integer totalPrice;
    // 조회수
    private Integer fashionViewCount;
    // 작성일시
    private LocalDateTime fashionDate;

    // Entity들을 DTO로 변환하는 생성자
    public Fashion(FashionEntity fashionEntity,
            List<FashionPhotoEntity> fashionPhotoEntities,
            List<FashionHashtagEntity> fashionHashtagEntities,
            List<FashionLikeEntity> fashionLikeEntities,
            List<FashionSaveEntity> fashionSaveEntities) {

        // 사진 URL 목록 변환
        List<String> fashionPhotoList = new ArrayList<>();
        for (FashionPhotoEntity fashionPhotoEntity : fashionPhotoEntities)
            fashionPhotoList.add(fashionPhotoEntity.getFashionPhotoLink());

        // 해시태그 목록 변환
        List<String> fashionHashtagList = new ArrayList<>();
        for (FashionHashtagEntity fashionHashtagEntity : fashionHashtagEntities)
            fashionHashtagList.add(fashionHashtagEntity.getFashionHashtagContent());

        // 좋아요한 사용자 목록 변환
        List<String> fashionLikeUserList = new ArrayList<>();
        for (FashionLikeEntity fashionLikeEntity : fashionLikeEntities)
            fashionLikeUserList.add(fashionLikeEntity.getUserId());

        // 저장한 사용자 목록 변환
        List<String> fashionSaveUserList = new ArrayList<>();
        for (FashionSaveEntity fashionSaveEntity : fashionSaveEntities)
            fashionSaveUserList.add(fashionSaveEntity.getUserId());

        // DTO 필드 초기화
        this.fashionNumber = fashionEntity.getFashionNumber();
        this.userId = fashionEntity.getUserId();
        this.fashionPhoto = fashionPhotoList.get(0); // 첫 번째 사진을 대표 사진으로 사용
        this.fashionHashtagList = fashionHashtagList;
        this.fashionLikeUserList = fashionLikeUserList;
        this.fashionSaveUserList = fashionSaveUserList;
        this.totalPrice = fashionEntity.getFashionTotalPrice();
        this.fashionLikeCount = fashionEntity.getFashionLikeCount();
        this.fashionSaveCount = fashionEntity.getFashionSaveCount();
        this.fashionViewCount = fashionEntity.getFashionViewCount();
        // 서버 시간과 클라이언트 시간의 차이를 보정하기 위해 9시간 차감
        this.fashionDate = fashionEntity.getFashionDate().minusHours(9);
    }
}
