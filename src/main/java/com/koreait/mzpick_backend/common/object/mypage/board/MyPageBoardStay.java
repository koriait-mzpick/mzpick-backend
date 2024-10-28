package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;

import lombok.Getter;
@Getter
public class MyPageBoardStay {
    
    private Integer mypageBoardNumber;
    private String mypageBoardTitle;
    private String userId;
    private LocalDate mypageBoardDate;

    public MyPageBoardStay(TravelStayEntity travelStayEntity) {
        this.userId = travelStayEntity.getUserId();
        this.mypageBoardNumber = travelStayEntity.getTravelStayNumber();
        this.mypageBoardTitle = travelStayEntity.getTravelStayTitle();
        this.mypageBoardDate = travelStayEntity.getTravelStayDate();
    }

    public static List<MyPageBoardStay> getMyPageBoardStayList(List<TravelStayEntity> travelStayEntities) {
        List<MyPageBoardStay> myPageBoardStays = new ArrayList<>();

        for (TravelStayEntity travelStayEntity: travelStayEntities) {
            MyPageBoardStay myPageBoardStay = new MyPageBoardStay(travelStayEntity);
            myPageBoardStays.add(myPageBoardStay);
        }
        return myPageBoardStays;
    }


}
