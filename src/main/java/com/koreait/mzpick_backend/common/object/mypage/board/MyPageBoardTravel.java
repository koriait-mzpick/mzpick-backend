package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;

import lombok.Getter;
@Getter
public class MyPageBoardTravel {
    
    private Integer mypageBoardNumber;
    private String mypageBoardTitle;
    private String userId;
    private LocalDate mypageBoardDate;

    public MyPageBoardTravel(FashionEntity fashionEntity) {
        this.userId = fashionEntity.getUserId();
        this.mypageBoardNumber = fashionEntity.getFashionNumber();
        this.mypageBoardTitle = fashionEntity.getFashionTitle();
        this.mypageBoardDate = fashionEntity.getFashionDate();
    }

    public static List<MyPageBoardTravel> getMyPageBoardTravelList(List<FashionEntity> fashionEntities) {
        List<MyPageBoardTravel> myPageBoardTravels = new ArrayList<>();

        for (FashionEntity fashionEntity: fashionEntities) {
            MyPageBoardTravel myPageBoardTravel = new MyPageBoardTravel(fashionEntity);
            myPageBoardTravels.add(myPageBoardTravel);
        }
        return myPageBoardTravels;
    }


}
