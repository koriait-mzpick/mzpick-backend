package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;

import lombok.Getter;

@Getter
public class MyPageBoardStay {
    
    private Integer mypageBoardNumber;
    private String mypageBoardTitle;
    private String userId;
    private LocalDate mypageBoardDate;

    public MyPageBoardStay(FashionEntity fashionEntity) {
        this.userId = fashionEntity.getUserId();
        this.mypageBoardNumber = fashionEntity.getFashionNumber();
        this.mypageBoardTitle = fashionEntity.getFashionTitle();
        this.mypageBoardDate = fashionEntity.getFashionDate();
    }

    public static List<MyPageBoardStay> getMyPageBoardStayList(List<FashionEntity> fashionEntities) {
        List<MyPageBoardStay> myPageBoardStays = new ArrayList<>();

        for (FashionEntity fashionEntity: fashionEntities) {
            MyPageBoardStay myPageBoardStay = new MyPageBoardStay(fashionEntity);
            myPageBoardStays.add(myPageBoardStay);
        }
        return myPageBoardStays;
    }


}
