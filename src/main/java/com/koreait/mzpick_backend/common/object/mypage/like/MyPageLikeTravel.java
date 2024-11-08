package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;

import lombok.Getter;
// 마이페이지의 여행 좋아요 정보를 담는 클래스
@Getter
public class MyPageLikeTravel {
    
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
    
    // TravelEntity와 관련 엔티티들을 MyPageLikeTravel로 변환하는 생성자
    public MyPageLikeTravel(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities) {

        // 사진 링크 목록 생성
        List<String> myPagePhotoList = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) myPagePhotoList.add(travelPhotoEntity.getTravelPhotoLink());

        // 해시태그 목록 생성
        List<String> myPageHashtagList = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntity: travelHashtagEntities) myPageHashtagList.add(travelHashtagEntity.getTravelHashtagContent());

        this.userId = travelEntity.getUserId();
        this.mypageBoardNumber = travelEntity.getTravelNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageBoardDate = travelEntity.getTravelDate().minusHours(9);
    }

    // TravelEntity 리스트와 관련 엔티티들을 MyPageLikeTravel 리스트로 변환하는 정적 메소드
    public static List<MyPageLikeTravel> getMyPageLikeTravelList(List<TravelEntity> travelEntities, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities) {
        List<MyPageLikeTravel> myPageLikeTravels = new ArrayList<>();

        // 각 TravelEntity를 MyPageLikeTravel로 변환하여 리스트에 추가
        for (TravelEntity travelEntity: travelEntities) {
            MyPageLikeTravel myPageLikeTravel = new MyPageLikeTravel(travelEntity, travelPhotoEntities, travelHashtagEntities);
            myPageLikeTravels.add(myPageLikeTravel);
        }
        return myPageLikeTravels;
    }

}
