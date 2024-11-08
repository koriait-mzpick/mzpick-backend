package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;

import lombok.Getter;
// 마이페이지의 숙소 좋아요 정보를 담는 클래스
@Getter
public class MyPageLikeStay {
    
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

    // TravelStayEntity와 관련 엔티티들을 MyPageLikeStay로 변환하는 생성자
    public MyPageLikeStay(TravelStayEntity travelStayEntity, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities) {

        // 사진 링크 목록 생성
        List<String> myPagePhotoList = new ArrayList<>();
        for (TravelStayPhotoEntity travelStayPhotoEntity: travelStayPhotoEntities) myPagePhotoList.add(travelStayPhotoEntity.getTravelStayPhotoLink());

        // 해시태그 목록 생성
        List<String> myPageHashtagList = new ArrayList<>();
        for (TravelStayHashtagEntity travelStayHashtagEntity: travelStayHashtagEntities) myPageHashtagList.add(travelStayHashtagEntity.getTravelStayHashtagContent());

        this.userId = travelStayEntity.getUserId();
        this.mypageBoardNumber = travelStayEntity.getTravelStayNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageBoardDate = travelStayEntity.getTravelStayDate().minusHours(9);
    }

    // TravelStayEntity 리스트와 관련 엔티티들을 MyPageLikeStay 리스트로 변환하는 정적 메소드
    public static List<MyPageLikeStay> getMyPageLikeStayList(List<TravelStayEntity> travelStayEntities, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities) {
        List<MyPageLikeStay> myPageLikeStays = new ArrayList<>();

        // 각 TravelStayEntity를 MyPageLikeStay로 변환하여 리스트에 추가
        for (TravelStayEntity travelStayEntity: travelStayEntities) {
            MyPageLikeStay myPageLikeStay = new MyPageLikeStay(travelStayEntity, travelStayPhotoEntities, travelStayHashtagEntities);
            myPageLikeStays.add(myPageLikeStay);
        }
        return myPageLikeStays;
    }

}
