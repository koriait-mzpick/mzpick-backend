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
// 여행 숙소 정보를 담는 클래스
@Getter
public class TravelStay {
    // 숙소 게시글 번호
    private Integer traveStayNumber;
    // 작성자 ID
    private String userId;
    // 숙소 위치
    private String travelLocation;
    // 숙소 대표 사진 링크
    private String travelStayPhoto;
    // 숙소 해시태그 목록
    private List<String> travelStayHashtag;
    // 숙소 카테고리 목록
    private List<String> travelStayCategory;
    // 숙소 게시글 좋아요한 사용자 목록
    private List<String> travelStayLikeUserList;
    // 숙소 게시글 저장한 사용자 목록
    private List<String> travelStaySaveUserList;
    // 숙소 게시글 조회수
    private Integer travelStayViewCount;
    // 숙소 게시글 좋아요 수
    private Integer travelStayLikeCount;
    // 숙소 게시글 저장 수
    private Integer travelStaySaveCount;
    // 숙소 게시글 작성 날짜
    private LocalDateTime travelStayDate;

    // TravelStayEntity와 관련 엔티티들을 TravelStay로 변환하는 생성자
    public TravelStay(TravelStayEntity travelStayEntity, List<TravelStayPhotoEntity> travelStayPhotoEntities,
            List<TravelStayHashtagEntity> travelStayHashtagEntities,
            List<TravelStayCategoryEntity> travelStayCategoryEntities,
            List<TravelStayLikeEntity> travelStayLikeEntities, List<TravelStaySaveEntity> travelStaySaveEntities) {
        // 사진 링크 목록 생성
        List<String> travelStayPhoto = new ArrayList<>();
        for (TravelStayPhotoEntity travelStayPhotoEntity : travelStayPhotoEntities)
            travelStayPhoto.add(travelStayPhotoEntity.getTravelStayPhotoLink());

        // 해시태그 목록 생성
        List<String> travelStayHashtag = new ArrayList<>();
        for (TravelStayHashtagEntity travelStayHashtagEntity : travelStayHashtagEntities)
            travelStayHashtag.add(travelStayHashtagEntity.getTravelStayHashtagContent());

        // 카테고리 목록 생성
        List<String> travelStayCategory = new ArrayList<>();
        for (TravelStayCategoryEntity TravelStayCategoryEntity : travelStayCategoryEntities)
            travelStayCategory.add(TravelStayCategoryEntity.getTravelStayCategoryContent());

        // 좋아요한 사용자 목록 생성
        List<String> travelStayLikeUserList = new ArrayList<>();
        for (TravelStayLikeEntity travelStayLikeEntity : travelStayLikeEntities)
            travelStayLikeUserList.add(travelStayLikeEntity.getUserId());

        // 저장한 사용자 목록 생성
        List<String> travelStaySaveUserList = new ArrayList<>();
        for (TravelStaySaveEntity travelStaySaveEntity : travelStaySaveEntities)
            travelStaySaveUserList.add(travelStaySaveEntity.getUserId());

        this.traveStayNumber = travelStayEntity.getTravelStayNumber();
        this.travelStayPhoto = travelStayPhoto.get(0);
        this.travelLocation = travelStayEntity.getTravelLocation();
        this.userId = travelStayEntity.getUserId();
        this.travelStayHashtag = travelStayHashtag;
        this.travelStayCategory = travelStayCategory;
        this.travelStayLikeUserList = travelStayLikeUserList;
        this.travelStaySaveUserList = travelStaySaveUserList;
        this.travelStayLikeCount = travelStayEntity.getTravelStayLikeCount();
        this.travelStaySaveCount = travelStayEntity.getTravelStaySaveCount();
        this.travelStayViewCount = travelStayEntity.getTravelStayViewCount();
        // 시간대 보정을 위해 9시간을 뺌
        this.travelStayDate = travelStayEntity.getTravelStayDate().minusHours(9);

    }
}
