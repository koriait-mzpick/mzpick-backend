package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;

import lombok.Getter;

@Getter
public class MyPageBoardFashion {
    
    private Integer mypageBoardNumber;
    private String mypageBoardTitle;
    private String userId;
    private LocalDateTime mypageBoardDate;

    public MyPageBoardFashion(FashionEntity fashionEntity) {
        this.userId = fashionEntity.getUserId();
        this.mypageBoardNumber = fashionEntity.getFashionNumber();
        this.mypageBoardTitle = fashionEntity.getFashionTitle();
        this.mypageBoardDate = fashionEntity.getFashionDate().minusHours(9);
    }

    public static List<MyPageBoardFashion> getMyPageBoardFashionList(List<FashionEntity> fashionEntities) {
        List<MyPageBoardFashion> myPageBoardFashions = new ArrayList<>();

        for (FashionEntity fashionEntity: fashionEntities) {
            MyPageBoardFashion myPageBoardFashion = new MyPageBoardFashion(fashionEntity);
            myPageBoardFashions.add(myPageBoardFashion);
        }
        return myPageBoardFashions;
    }
}
