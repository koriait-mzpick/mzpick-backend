package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;

import lombok.Getter;
// 마이페이지 여행 카페 게시글 정보를 담는 클래스
@Getter
public class MyPageBoardCafe {
    
    // 마이페이지 게시글 번호
    private Integer mypageBoardNumber;
    // 마이페이지 게시글 제목
    private String mypageBoardTitle;
    // 사용자 ID
    private String userId;
    // 마이페이지 게시글 작성일자
    private LocalDateTime mypageBoardDate;

    // TravelCafeEntity를 MyPageBoardCafe 객체로 변환하는 생성자
    public MyPageBoardCafe(TravelCafeEntity travelCafeEntity) {
        this.userId = travelCafeEntity.getUserId();
        this.mypageBoardNumber = travelCafeEntity.getTravelCafeNumber();
        this.mypageBoardTitle = travelCafeEntity.getTravelCafeTitle();
        // 서버 시간과 한국 시간의 차이를 보정하기 위해 9시간 차감
        this.mypageBoardDate = travelCafeEntity.getTravelCafeDate().minusHours(9);
    }

    // TravelCafeEntity 리스트를 MyPageBoardCafe 리스트로 변환하는 정적 메소드
    public static List<MyPageBoardCafe> getMyPageBoardCafeList(List<TravelCafeEntity> travelCafeEntities) {
        List<MyPageBoardCafe> myPageBoardCafes = new ArrayList<>();

        // 각 TravelCafeEntity를 MyPageBoardCafe로 변환하여 리스트에 추가
        for (TravelCafeEntity travelCafeEntity: travelCafeEntities) {
            MyPageBoardCafe myPageBoardCafe = new MyPageBoardCafe(travelCafeEntity);
            myPageBoardCafes.add(myPageBoardCafe);
        }
        return myPageBoardCafes;
    }
}