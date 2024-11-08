package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafePhotoEntity;

import lombok.Getter;
// 마이페이지의 카페 좋아요 정보를 담는 클래스
@Getter
public class MyPageLikeCafe {
    
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
    
    // TravelCafeEntity와 관련 엔티티들을 MyPageLikeCafe로 변환하는 생성자
    public MyPageLikeCafe(TravelCafeEntity travelCafeEntity, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities) {

        // 사진 링크 목록 생성
        List<String> myPagePhotoList = new ArrayList<>();
        for (TravelCafePhotoEntity travelCafePhotoEntity: travelCafePhotoEntities) myPagePhotoList.add(travelCafePhotoEntity.getTravelCafePhotoLink());

        // 해시태그 목록 생성
        List<String> myPageHashtagList = new ArrayList<>();
        for (TravelCafeHashtagEntity travelCafeHashtagEntity: travelCafeHashtagEntities) myPageHashtagList.add(travelCafeHashtagEntity.getTravelCafeHashtagContent());

        this.userId = travelCafeEntity.getUserId();
        this.mypageBoardNumber = travelCafeEntity.getTravelCafeNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageBoardDate = travelCafeEntity.getTravelCafeDate().minusHours(9);
    }

    // TravelCafeEntity 리스트와 관련 엔티티들을 MyPageLikeCafe 리스트로 변환하는 정적 메소드
    public static List<MyPageLikeCafe> getMyPageLikeCafeList(List<TravelCafeEntity> travelCafeEntities, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities) {
        List<MyPageLikeCafe> myPageLikeCafes = new ArrayList<>();

        // 각 TravelCafeEntity를 MyPageLikeCafe로 변환하여 리스트에 추가
        for (TravelCafeEntity travelCafeEntity: travelCafeEntities) {
            MyPageLikeCafe myPageLikeCafe = new MyPageLikeCafe(travelCafeEntity, travelCafePhotoEntities, travelCafeHashtagEntities);
            myPageLikeCafes.add(myPageLikeCafe);
        }
        return myPageLikeCafes;
    }

}
