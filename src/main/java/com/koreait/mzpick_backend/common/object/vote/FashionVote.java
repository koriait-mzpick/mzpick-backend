package com.koreait.mzpick_backend.common.object.vote;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.FashionVoteEntity;
import com.koreait.mzpick_backend.entity.vote.FashionVoteResultEntity;

import lombok.Getter;

@Getter
// 패션 투표 정보를 담는 클래스
public class FashionVote {
    // 투표 번호
    private Integer fashionVoteNumber;
    // 작성자 ID
    private String userId;
    // 투표 제목
    private String fashionVoteTitle;
    // 첫 번째 투표 사진 URL
    private String fashionVotePhoto1;
    // 두 번째 투표 사진 URL
    private String fashionVotePhoto2;
    // 첫 번째 투표 선택지
    private String fashionVoteChoice1;
    // 두 번째 투표 선택지
    private String fashionVoteChoice2;
    // 투표한 사용자 ID 목록
    private List<String> fashionVoteChoiceUserList;
    // 투표 선택 내용 목록
    private List<String> fashionVoteChoiceContentList;
    // 투표 작성일시
    private LocalDateTime fashionVoteDate;
    // 투표 만료일시
    private LocalDateTime fashionVoteExpireDate;

    // FashionVoteEntity와 관련 엔티티들을 FashionVote로 변환하는 생성자
    public FashionVote (FashionVoteEntity fashionVoteEntity, List<FashionVoteResultEntity> fashionVoteResultEntitys){
        // 투표한 사용자 목록 생성
        List<String> fashionvotechoiceUserList = new ArrayList<>();
        for(FashionVoteResultEntity fashionVoteResultEntity : fashionVoteResultEntitys) fashionvotechoiceUserList.add(fashionVoteResultEntity.getUserId());
        // 투표 선택 내용 목록 생성
        List<String> fashionVoteChoiceContentList = new ArrayList<>();
        for(FashionVoteResultEntity fashionVoteResultEntity : fashionVoteResultEntitys) fashionVoteChoiceContentList.add(fashionVoteResultEntity.getFashionVoteResultChoice());
        
        this.fashionVoteNumber = fashionVoteEntity.getFashionVoteNumber();
        this.fashionVoteTitle = fashionVoteEntity.getFashionVoteTitle();
        this.userId = fashionVoteEntity.getUserId();
        this.fashionVotePhoto1 = fashionVoteEntity.getFashionVotePhoto1();
        this.fashionVotePhoto2 = fashionVoteEntity.getFashionVotePhoto2();
        this.fashionVoteChoice1 = fashionVoteEntity.getFashionVoteChoice1();
        this.fashionVoteChoice2 = fashionVoteEntity.getFashionVoteChoice2();
        this.fashionVoteChoiceUserList = fashionvotechoiceUserList;
        this.fashionVoteChoiceContentList = fashionVoteChoiceContentList;
        // 시간대 보정을 위해 9시간을 뺌
        this.fashionVoteDate = fashionVoteEntity.getFashionVoteDate().minusHours(9);
        fashionVoteExpireDate = fashionVoteEntity.getFashionVoteExpireDate().minusHours(9);
    }
}
