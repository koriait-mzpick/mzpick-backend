package com.koreait.mzpick_backend.common.object.mypage.vote;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.FashionVoteEntity;

import lombok.Getter;
// 마이페이지의 패션 투표 정보를 담는 클래스
@Getter
public class MyPageVoteFashion {
    // 투표 게시글 번호
    private Integer mypageVoteNumber;
    // 투표 게시글 제목 
    private String mypageVoteTitle;
    // 작성자 ID
    private String userId;
    // 투표 게시글 작성 날짜
    private LocalDateTime mypageVoteDate;
    
    // FashionVoteEntity를 MyPageVoteFashion으로 변환하는 생성자
    public MyPageVoteFashion(FashionVoteEntity fashionVoteEntity) {
        this.mypageVoteNumber = fashionVoteEntity.getFashionVoteNumber();
        this.mypageVoteTitle = fashionVoteEntity.getFashionVoteTitle();
        this.userId = fashionVoteEntity.getUserId();
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageVoteDate = fashionVoteEntity.getFashionVoteDate().minusHours(9);
    }

    // FashionVoteEntity 리스트를 MyPageVoteFashion 리스트로 변환하는 정적 메소드
    public static List<MyPageVoteFashion> getMyPageVoteFashionList(List<FashionVoteEntity> fashionVoteEntities) {
        List<MyPageVoteFashion> myPageVoteFashions = new ArrayList<>();

        // 각 FashionVoteEntity를 MyPageVoteFashion으로 변환하여 리스트에 추가
        for (FashionVoteEntity fashionVoteEntity: fashionVoteEntities) {
            MyPageVoteFashion myPageVoteFashion = new MyPageVoteFashion(fashionVoteEntity);
            myPageVoteFashions.add(myPageVoteFashion);
        }
        return myPageVoteFashions;
    }
}
