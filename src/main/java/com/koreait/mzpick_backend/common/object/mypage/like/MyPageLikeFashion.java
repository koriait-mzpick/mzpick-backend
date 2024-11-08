package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;

import lombok.Getter;
// 마이페이지의 패션 좋아요 정보를 담는 클래스
@Getter
public class MyPageLikeFashion {
    
    // 게시글 번호
    private Integer mypageBoardNumber;
    // 게시글 대표 사진 링크
    private String mypagePhotoList;
    // 게시글 해시태그 목록
    private List<String> mypageHashTagList;
    // 작성자 ID
    private String userId;
    // 게시글 작성 날짜
    private LocalDateTime mypageBoardDate;

    // FashionEntity와 관련 엔티티들을 MyPageLikeFashion으로 변환하는 생성자
    public MyPageLikeFashion(FashionEntity fashionEntity, List<FashionPhotoEntity> fashionPhotoEntities, List<FashionHashtagEntity> fashionHashtagEntities) {

        // 사진 링크 목록 생성
        List<String> myPagePhotoList = new ArrayList<>();
        for (FashionPhotoEntity fashionPhotoEntity: fashionPhotoEntities) myPagePhotoList.add(fashionPhotoEntity.getFashionPhotoLink());

        // 해시태그 목록 생성
        List<String> myPageHashtagList = new ArrayList<>();
        for (FashionHashtagEntity fashionHashtagEntity: fashionHashtagEntities) myPageHashtagList.add(fashionHashtagEntity.getFashionHashtagContent());

        this.userId = fashionEntity.getUserId();
        this.mypageBoardNumber = fashionEntity.getFashionNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        // 시간대 보정을 위해 9시간을 뺌
        this.mypageBoardDate = fashionEntity.getFashionDate().minusHours(9);
    }

    // FashionEntity 리스트와 관련 엔티티들을 MyPageLikeFashion 리스트로 변환하는 정적 메소드
    public static List<MyPageLikeFashion> getMyPageLikeFashionList(List<FashionEntity> fashionEntities, List<FashionPhotoEntity> fashionPhotoEntities, List<FashionHashtagEntity> fashionHashtagEntities) {
        List<MyPageLikeFashion> myPageLikeFashions = new ArrayList<>();

        // 각 FashionEntity를 MyPageLikeFashion으로 변환하여 리스트에 추가
        for (FashionEntity fashionEntity: fashionEntities) {
            MyPageLikeFashion myPageLikeFashion = new MyPageLikeFashion(fashionEntity, fashionPhotoEntities, fashionHashtagEntities);
            myPageLikeFashions.add(myPageLikeFashion);
        }
        return myPageLikeFashions;
    }

}
