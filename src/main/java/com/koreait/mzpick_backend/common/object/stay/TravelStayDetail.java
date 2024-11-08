package com.koreait.mzpick_backend.common.object.stay;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayCategoryEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayLikeEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStaySaveEntity;

import lombok.Getter;

// 여행 숙소 게시글의 상세 정보를 담는 DTO 클래스
@Getter
public class TravelStayDetail {
    // 게시글 번호
    private Integer travelStayNumber;
    // 게시글 제목
    private String travelStayTitle;
    // 여행 위치
    private String travelLocathion;
    // 작성자 ID
    private String userId;
    // 숙소 카테고리 목록
    private List<String> travelStayCategory;
    // 사진 URL 목록
    private List<String> travelStayPhotoList;
    // 해시태그 목록
    private List<String> travelStayHashtagList;
    // 좋아요한 사용자 ID 목록
    private List<String> travelStayLikeUserList;
    // 저장한 사용자 ID 목록
    private List<String> travelStaySaveUserList;
    // 조회수
    private Integer travelStayViewCount;
    // 좋아요 수
    private Integer travelStayLikeCount;
    // 저장 수
    private Integer travelStaySaveCount;
    // 게시글 내용
    private String travelStayContent;
    // 작성일시
    private LocalDateTime travelStayDate;

    // Entity들을 DTO로 변환하는 생성자
    public TravelStayDetail(TravelStayEntity travelStayEntity, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities, List<TravelStayLikeEntity> travelStayLikeEntities, List<TravelStaySaveEntity> travelStaySaveEntities, List<TravelStayCategoryEntity> travelStayCategoryEntities){

        // 카테고리 목록 변환
        List<String> travelStayCategory = new ArrayList<>();
        for (TravelStayCategoryEntity travelStayCategoryEntity: travelStayCategoryEntities) travelStayCategory.add(travelStayCategoryEntity.getTravelStayCategoryContent());

        // 사진 URL 목록 변환
        List<String> travelStayPhoto = new ArrayList<>();
        for (TravelStayPhotoEntity travelStayPhotoEntity: travelStayPhotoEntities) travelStayPhoto.add(travelStayPhotoEntity.getTravelStayPhotoLink());
        
        // 해시태그 목록 변환
        List<String> travelStayHashtag = new ArrayList<>();
        for (TravelStayHashtagEntity travelStayHashtagEntitiy: travelStayHashtagEntities) travelStayHashtag.add(travelStayHashtagEntitiy.getTravelStayHashtagContent());
        
        // 좋아요한 사용자 목록 변환
        List<String> travelStayLikeUserList = new ArrayList<>();
        for (TravelStayLikeEntity travelStayLikeEntity: travelStayLikeEntities) travelStayLikeUserList.add(travelStayLikeEntity.getUserId());

        // 저장한 사용자 목록 변환
        List<String> travelStaySaveUserList = new ArrayList<>();
        for (TravelStaySaveEntity travelStaySaveEntity: travelStaySaveEntities) travelStaySaveUserList.add(travelStaySaveEntity.getUserId());

        // DTO 필드 초기화
        this.travelStayNumber = travelStayEntity.getTravelStayNumber();
        this.travelStayTitle = travelStayEntity.getTravelStayTitle();
        this.travelLocathion = travelStayEntity.getTravelLocation();
        this.userId = travelStayEntity.getUserId();
        this.travelStayCategory  = travelStayCategory;
        this.travelStayPhotoList = travelStayPhoto;
        this.travelStayHashtagList = travelStayHashtag;
        this.travelStayLikeUserList = travelStayLikeUserList;
        this.travelStaySaveUserList = travelStaySaveUserList;
        this.travelStayLikeCount = travelStayLikeUserList.size();
        this.travelStaySaveCount = travelStaySaveUserList.size();
        this.travelStayViewCount = travelStayEntity.getTravelStayViewCount();
        this.travelStayContent = travelStayEntity.getTravelStayContent();
        // 서버 시간과 클라이언트 시간의 차이를 보정하기 위해 9시간 차감
        this.travelStayDate = travelStayEntity.getTravelStayDate().minusHours(9);
        this.travelStayContent = travelStayEntity.getTravelStayContent();
    }
}

