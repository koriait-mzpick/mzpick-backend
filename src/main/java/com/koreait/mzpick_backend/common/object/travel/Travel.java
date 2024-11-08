package com.koreait.mzpick_backend.common.object.travel;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;
import com.koreait.mzpick_backend.entity.travel.TravelSaveEntity;

import lombok.Getter;

// 여행 게시글의 정보를 담는 클래스
@Getter
public class Travel {
    // 게시글 번호
    private Integer travelNumber;
    // 작성자 ID
    private String userId;
    // 여행 위치
    private String travelLocation;
    // 대표 사진 URL
    private String travelPhoto;
    // 해시태그 목록
    private List<String> travelHashtagList;
    // 좋아요한 사용자 ID 목록
    private List<String> travelLikeUserList;
    // 저장한 사용자 ID 목록
    private List<String> travelSaveUserList;
    // 저장 수
    private Integer travelSaveCount;
    // 좋아요 수
    private Integer travelLikeCount;
    // 조회수
    private Integer travelViewCount;
    // 작성일시
    private LocalDateTime travelDate;

    // Entity들을 Travel로 변환하는 생성자
    public Travel(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities,  List<TravelLikeEntity> travelLikeEntities, List<TravelSaveEntity> travelSaveEntities ) {
        
        // 사진 URL 목록 변환
        List<String> travelPhotoList = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) travelPhotoList.add(travelPhotoEntity.getTravelPhotoLink());
        
        // 해시태그 목록 변환
        List<String> travelHashtagList = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntity: travelHashtagEntities) travelHashtagList.add(travelHashtagEntity.getTravelHashtagContent());
        
        // 좋아요한 사용자 목록 변환
        List<String> travelLikeUserList = new ArrayList<>();
        for (TravelLikeEntity travelLikeEntity : travelLikeEntities) travelLikeUserList.add(travelLikeEntity.getUserId());

        // 저장한 사용자 목록 변환
        List<String> travelSaveUserList = new ArrayList<>();
        for (TravelSaveEntity travelSaveEntity : travelSaveEntities) travelSaveUserList.add(travelSaveEntity.getUserId());

        // DTO 필드 초기화
        this.travelNumber = travelEntity.getTravelNumber();
        this.userId = travelEntity.getUserId();
        this.travelLocation = travelEntity.getTravelLocation();
        this.travelPhoto = travelPhotoList.size() != 0 ? travelPhotoList.get(0) : null;
        this.travelHashtagList = travelHashtagList;
        this.travelLikeUserList = travelLikeUserList;
        this.travelSaveUserList = travelSaveUserList;
        this.travelLikeCount = travelEntity.getTravelLikeCount();
        this.travelSaveCount = travelEntity.getTravelSaveCount();
        this.travelViewCount = travelEntity.getTravelViewCount();
        // 서버 시간과 클라이언트 시간의 차이를 보정하기 위해 9시간 차감
        this.travelDate = travelEntity.getTravelDate().minusHours(9);
    }
}