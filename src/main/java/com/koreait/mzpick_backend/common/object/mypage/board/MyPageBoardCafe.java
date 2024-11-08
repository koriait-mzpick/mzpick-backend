package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;

import lombok.Getter;
@Getter
public class MyPageBoardCafe {
    
    private Integer mypageBoardNumber;
    private String mypageBoardTitle;
    private String userId;
    private LocalDateTime mypageBoardDate;

    public MyPageBoardCafe(TravelCafeEntity travelCafeEntity) {
        this.userId = travelCafeEntity.getUserId();
        this.mypageBoardNumber = travelCafeEntity.getTravelCafeNumber();
        this.mypageBoardTitle = travelCafeEntity.getTravelCafeTitle();
        this.mypageBoardDate = travelCafeEntity.getTravelCafeDate().minusHours(9);;
    }

    public static List<MyPageBoardCafe> getMyPageBoardCafeList(List<TravelCafeEntity> travelCafeEntities) {
        List<MyPageBoardCafe> myPageBoardCafes = new ArrayList<>();

        for (TravelCafeEntity travelCafeEntity: travelCafeEntities) {
            MyPageBoardCafe myPageBoardCafe = new MyPageBoardCafe(travelCafeEntity);
            myPageBoardCafes.add(myPageBoardCafe);
        }
        return myPageBoardCafes;
    }


}
