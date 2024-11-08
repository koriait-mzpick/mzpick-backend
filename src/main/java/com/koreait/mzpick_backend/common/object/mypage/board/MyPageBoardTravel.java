package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;

import lombok.Getter;
// 마이페이지의 여행 게시글 정보를 담는 클래스
@Getter
public class MyPageBoardTravel {
    
    // 게시글 번호
    private Integer mypageBoardNumber;
    // 게시글 제목
    private String mypageBoardTitle;
    // 작성자 ID
    private String userId;
    // 게시글 작성 날짜
    private LocalDateTime mypageBoardDate;

    // TravelEntity를 MyPageBoardTravel로 변환하는 생성자
    public MyPageBoardTravel(TravelEntity travelEntity) {
        this.userId = travelEntity.getUserId();
        this.mypageBoardNumber = travelEntity.getTravelNumber();
        this.mypageBoardTitle = travelEntity.getTravelTitle();
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageBoardDate = travelEntity.getTravelDate().minusHours(9);
    }

    // TravelEntity 리스트를 MyPageBoardTravel 리스트로 변환하는 정적 메소드
    public static List<MyPageBoardTravel> getMyPageBoardList(List<TravelEntity> travelEntities) {
        List<MyPageBoardTravel> myPageBoards = new ArrayList<>();

        // 각 TravelEntity를 MyPageBoardTravel로 변환하여 리스트에 추가
        for (TravelEntity travelEntity: travelEntities) {
            MyPageBoardTravel myPageBoard = new MyPageBoardTravel(travelEntity);
            myPageBoards.add(myPageBoard);
        }
        return myPageBoards;
    }
}
