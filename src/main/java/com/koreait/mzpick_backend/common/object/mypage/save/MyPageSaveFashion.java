package com.koreait.mzpick_backend.common.object.mypage.save;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;

import lombok.Getter;
// 마이페이지의 패션 저장 정보를 담는 클래스
@Getter
public class MyPageSaveFashion {
    // 게시글 번호
    private Integer fashionNumber;
    // 게시글 대표 사진 링크
    private String fashionPhoto;
    // 게시글 해시태그 목록
    private List<String> fashionHashtagList;
    // 게시글 작성 날짜
    private LocalDateTime fashionDate;

    // FashionEntity와 관련 엔티티들을 MyPageSaveFashion으로 변환하는 생성자
    public MyPageSaveFashion(FashionEntity fashionEntity, List<FashionPhotoEntity> fashionPhotoEntities, List<FashionHashtagEntity> fashionHashtagEntities) {
        // 사진 링크 목록 생성
        List<String> fashionPhotoList = new ArrayList<>();
        for (FashionPhotoEntity fashionPhotoEntity : fashionPhotoEntities)
            fashionPhotoList.add(fashionPhotoEntity.getFashionPhotoLink());

        // 해시태그 목록 생성
        List<String> fashionHashtagList = new ArrayList<>();
        for (FashionHashtagEntity fashionHashtagEntity : fashionHashtagEntities)
            fashionHashtagList.add(fashionHashtagEntity.getFashionHashtagContent());

        this.fashionNumber = fashionEntity.getFashionNumber();
        this.fashionPhoto = fashionPhotoList.get(0);
        this.fashionHashtagList = fashionHashtagList;
        // 시간대 보정을 위해 9시간을 뺌
        this.fashionDate = fashionEntity.getFashionDate().minusHours(9);
    }

    // FashionEntity 리스트와 관련 엔티티들을 MyPageSaveFashion 리스트로 변환하는 정적 메소드
    public static List<MyPageSaveFashion> getList(List<FashionEntity> FashionEntities, List<FashionPhotoEntity> FashionPhotoEntities, List<FashionHashtagEntity> FashionHashtagEntities) { 
        List<MyPageSaveFashion> myPageSaveFashions = new ArrayList<>();
        // 각 FashionEntity를 MyPageSaveFashion으로 변환하여 리스트에 추가
        for (FashionEntity FashionEntity : FashionEntities) {
            MyPageSaveFashion myPageSaveFashion = new MyPageSaveFashion(FashionEntity, FashionPhotoEntities, FashionHashtagEntities);
            myPageSaveFashions.add(myPageSaveFashion);
        }
        return myPageSaveFashions;
    }
}
