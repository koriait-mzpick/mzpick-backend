package com.koreait.mzpick_backend.common.object.mypage.like;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;

import lombok.Getter;

@Getter
public class MyPageLikeFashion {
    
     private Integer mypageBoardNumber;
    private String mypagePhotoList;
    private List<String> mypageHashTagList;
    private String userId;
    private LocalDate mypageBoardDate;

    public MyPageLikeFashion(FashionEntity fashionEntity, List<FashionPhotoEntity> fashionPhotoEntities, List<FashionHashtagEntity> fashionHashtagEntities) {

        
        List<String> myPagePhotoList = new ArrayList<>();
        for (FashionPhotoEntity fashionPhotoEntity: fashionPhotoEntities) myPagePhotoList.add(fashionPhotoEntity.getFashionPhotoLink());

        List<String> myPageHashtagList = new ArrayList<>();
        for (FashionHashtagEntity fashionHashtagEntity: fashionHashtagEntities) myPageHashtagList.add(fashionHashtagEntity.getFashionHashtagContent());

        

        this.userId = fashionEntity.getUserId();
        this.mypageBoardNumber = fashionEntity.getFashionNumber();
        this.mypagePhotoList = myPagePhotoList.get(0);
        this.mypageHashTagList = myPageHashtagList;
        this.mypageBoardDate = fashionEntity.getFashionDate();
    }

    public static List<MyPageLikeFashion> getMyPageLikeFashionList(List<FashionEntity> fashionEntities, List<FashionPhotoEntity> fashionPhotoEntities, List<FashionHashtagEntity> fashionHashtagEntities) {
        List<MyPageLikeFashion> myPageLikeFashions = new ArrayList<>();

        for (FashionEntity fashionEntity: fashionEntities) {
            MyPageLikeFashion myPageLikeFashion = new MyPageLikeFashion(fashionEntity, fashionPhotoEntities, fashionHashtagEntities);
            myPageLikeFashions.add(myPageLikeFashion);
        }
        return myPageLikeFashions;
    }

}
