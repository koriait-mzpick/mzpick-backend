package com.koreait.mzpick_backend.common.object.mypage.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;

import lombok.Getter;
// 마이페이지의 패션 게시글 정보를 담는 클래스
@Getter
public class MyPageBoardFashion {
    
    // 게시글 번호
    private Integer mypageBoardNumber;
    // 게시글 제목
    private String mypageBoardTitle;
    // 작성자 ID
    private String userId;
    // 게시글 작성 날짜
    private LocalDateTime mypageBoardDate;

    // FashionEntity를 MyPageBoardFashion으로 변환하는 생성자
    public MyPageBoardFashion(FashionEntity fashionEntity) {
        this.userId = fashionEntity.getUserId();
        this.mypageBoardNumber = fashionEntity.getFashionNumber();
        this.mypageBoardTitle = fashionEntity.getFashionTitle();
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageBoardDate = fashionEntity.getFashionDate().minusHours(9);
    }

    // FashionEntity 리스트를 MyPageBoardFashion 리스트로 변환하는 정적 메소드
    public static List<MyPageBoardFashion> getMyPageBoardFashionList(List<FashionEntity> fashionEntities) {
        List<MyPageBoardFashion> myPageBoardFashions = new ArrayList<>();

        // 각 FashionEntity를 MyPageBoardFashion으로 변환하여 리스트에 추가
        for (FashionEntity fashionEntity: fashionEntities) {
            MyPageBoardFashion myPageBoardFashion = new MyPageBoardFashion(fashionEntity);
            myPageBoardFashions.add(myPageBoardFashion);
        }
        return myPageBoardFashions;
    }
}
