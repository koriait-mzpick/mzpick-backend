package com.koreait.mzpick_backend.common.object.mypage.save;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;

import lombok.Getter;
// 마이페이지의 여행 저장 정보를 담는 클래스
@Getter
public class MyPageSaveTravel {
    
    // 게시글 번호
    private Integer travelNumber;
    // 게시글 대표 사진 링크
    private String travelPhoto;
    // 게시글 해시태그 목록
    private List<String> travelHashtagList;
    // 게시글 작성 날짜
    private LocalDateTime travelDate;

    // TravelEntity와 관련 엔티티들을 MyPageSaveTravel로 변환하는 생성자
    public MyPageSaveTravel(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities) {
        // 사진 링크 목록 생성
        List<String> travelPhotoList = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) travelPhotoList.add(travelPhotoEntity.getTravelPhotoLink());
        
        // 해시태그 목록 생성
        List<String> travelHashtagList = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntity: travelHashtagEntities) travelHashtagList.add(travelHashtagEntity.getTravelHashtagContent());

        this.travelNumber = travelEntity.getTravelNumber();
        this.travelPhoto = travelPhotoList.get(0);
        this.travelHashtagList = travelHashtagList;
        // 시간대 보정을 위해 9시간을 뺌
        this.travelDate = travelEntity.getTravelDate().minusHours(9);
    }

    // TravelEntity 리스트와 관련 엔티티들을 MyPageSaveTravel 리스트로 변환하는 정적 메소드
    public static List<MyPageSaveTravel> getList(List<TravelEntity> travelEntities, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities){
        List<MyPageSaveTravel> myPageSaveTravels = new ArrayList<>();
        // 각 TravelEntity를 MyPageSaveTravel로 변환하여 리스트에 추가
        for(TravelEntity travelEntity: travelEntities){
            MyPageSaveTravel myPageSaveTravel = new MyPageSaveTravel (travelEntity, travelPhotoEntities, travelHashtagEntities);
            myPageSaveTravels.add(myPageSaveTravel);
        }
        return myPageSaveTravels;
    }
}
