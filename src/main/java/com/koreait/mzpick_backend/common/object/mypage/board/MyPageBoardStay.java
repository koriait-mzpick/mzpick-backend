package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;

import lombok.Getter;
// 마이페이지의 숙소 게시글 정보를 담는 클래스
@Getter
public class MyPageBoardStay {
    
    // 게시글 번호
    private Integer mypageBoardNumber;
    // 게시글 제목
    private String mypageBoardTitle;
    // 작성자 ID
    private String userId;
    // 게시글 작성 날짜
    private LocalDateTime mypageBoardDate;

    // TravelStayEntity를 MyPageBoardStay로 변환하는 생성자
    public MyPageBoardStay(TravelStayEntity travelStayEntity) {
        this.userId = travelStayEntity.getUserId();
        this.mypageBoardNumber = travelStayEntity.getTravelStayNumber();
        this.mypageBoardTitle = travelStayEntity.getTravelStayTitle();
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageBoardDate = travelStayEntity.getTravelStayDate().minusHours(9);
    }

    // TravelStayEntity 리스트를 MyPageBoardStay 리스트로 변환하는 정적 메소드
    public static List<MyPageBoardStay> getMyPageBoardStayList(List<TravelStayEntity> travelStayEntities) {
        List<MyPageBoardStay> myPageBoardStays = new ArrayList<>();

        // 각 TravelStayEntity를 MyPageBoardStay로 변환하여 리스트에 추가
        for (TravelStayEntity travelStayEntity: travelStayEntities) {
            MyPageBoardStay myPageBoardStay = new MyPageBoardStay(travelStayEntity);
            myPageBoardStays.add(myPageBoardStay);
        }
        return myPageBoardStays;
    }
}
