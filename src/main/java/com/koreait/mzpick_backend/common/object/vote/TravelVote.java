package com.koreait.mzpick_backend.common.object.vote;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.TravelVoteEntity;
import com.koreait.mzpick_backend.entity.vote.TravelVoteResultEntity;

import lombok.Getter;

// 여행지 투표 관련 객체 //
@Getter
public class TravelVote {
    // 여행지 투표 번호 //
    private Integer travelVoteNumber;
    // 작성자 아이디 //
    private String userId;
    // 여행지 투표 제목 //
    private String travelVoteTitle;
    // 여행지 투표 사진1 //
    private String travelVotePhoto1;
    // 여행지 투표 사진2 //
    private String travelVotePhoto2;
    // 여행지 투표 선택지1 //
    private String travelVoteChoice1;
    // 여행지 투표 선택지2 //
    private String travelVoteChoice2;
    // 여행지 투표 참여자 리스트 //
    private List<String> travelVoteChoiceUserList;
    // 여행지 투표 선택 내용 리스트 //
    private List<String> travelVoteChoiceContentList;
    // 여행지 투표 작성일 //
    private LocalDateTime travelVoteDate;
    // 여행지 투표 만료일 //
    private LocalDateTime travelVoteExpireDate;

    // 여행지 투표 생성자 //
    public TravelVote(TravelVoteEntity travelVoteEntity, List<TravelVoteResultEntity> travelVoteResultEntitys ){
        // 여행지 투표 참여자 리스트 생성 //
        List<String> travelVoteChoiceUserList = new ArrayList<>();
        for(TravelVoteResultEntity travelVoteResultEntity : travelVoteResultEntitys) travelVoteChoiceUserList.add(travelVoteResultEntity.getUserId());
        // 여행지 투표 선택 내용 리스트 생성 //
        List<String> travelVoteChoiceContentList = new ArrayList<>();
        for(TravelVoteResultEntity travelVoteResultEntity : travelVoteResultEntitys) travelVoteChoiceContentList.add(travelVoteResultEntity.getTravelVoteResultChoice());
        // 여행지 투표 정보 설정 //
        this.travelVoteNumber = travelVoteEntity.getTravelVoteNumber();
        this.travelVoteTitle = travelVoteEntity.getTravelVoteTitle();
        this.userId = travelVoteEntity.getUserId();
        this.travelVotePhoto1 = travelVoteEntity.getTravelVotePhoto1();
        this.travelVotePhoto2 = travelVoteEntity.getTravelVotePhoto2();
        this.travelVoteChoice1 = travelVoteEntity.getTravelVoteChoice1();
        this.travelVoteChoice2 = travelVoteEntity.getTravelVoteChoice2();
        this.travelVoteChoiceUserList = travelVoteChoiceUserList;
        this.travelVoteChoiceContentList = travelVoteChoiceContentList;
        this.travelVoteDate = travelVoteEntity.getTravelVoteDate();
        this.travelVoteExpireDate = travelVoteEntity.getTravelVoteExpireDate().minusHours(9);
    }
}
