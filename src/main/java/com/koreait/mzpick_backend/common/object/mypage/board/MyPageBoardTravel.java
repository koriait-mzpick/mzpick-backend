package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;

import lombok.Getter;
@Getter
public class MyPageBoardTravel {
    
    private Integer mypageBoardNumber;
    private String mypageBoardTitle;
    private String userId;
    private LocalDate mypageBoardDate;

    public MyPageBoardTravel(TravelEntity travelEntity) {
        this.userId = travelEntity.getUserId();
        this.mypageBoardNumber = travelEntity.getTravelNumber();
        this.mypageBoardTitle = travelEntity.getTravelTitle();
        this.mypageBoardDate = travelEntity.getTravelDate();
    }

    public static List<MyPageBoardTravel> getMyPageBoardList(List<TravelEntity> travelEntities) {
        List<MyPageBoardTravel> myPageBoards = new ArrayList<>();

        for (TravelEntity travelEntity: travelEntities) {
            MyPageBoardTravel myPageBoard = new MyPageBoardTravel(travelEntity);
            myPageBoards.add(myPageBoard);
        }
        return myPageBoards;
    }


}
