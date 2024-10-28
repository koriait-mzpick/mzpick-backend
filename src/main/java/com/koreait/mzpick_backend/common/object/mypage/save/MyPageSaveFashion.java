package com.koreait.mzpick_backend.common.object.mypage.save;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;

import lombok.Getter;

@Getter
public class MyPageSaveFashion {
    private Integer FashionNumber;
    private String FashionPhoto;
    private List<String> FashionHashtagList;
    private LocalDate FashionDate;

    public MyPageSaveFashion(FashionEntity FashionEntity, List<FashionPhotoEntity> FashionPhotoEntities, List<FashionHashtagEntity> FashionHashtagEntities) {
        List<String> FashionPhotoList = new ArrayList<>();
        for (FashionPhotoEntity FashionPhotoEntity : FashionPhotoEntities)
            FashionPhotoList.add(FashionPhotoEntity.getFashionPhotoLink());

        List<String> FashionHashtagList = new ArrayList<>();
        for (FashionHashtagEntity FashionHashtagEntity : FashionHashtagEntities)
            FashionHashtagList.add(FashionHashtagEntity.getFashionHashtagContent());

        this.FashionNumber = FashionEntity.getFashionNumber();
        this.FashionPhoto = FashionPhotoList.get(0);
        this.FashionHashtagList = FashionHashtagList;
        this.FashionDate = FashionEntity.getFashionDate();
    }

    public static List<MyPageSaveFashion> getList(List<FashionEntity> FashionEntities, List<FashionPhotoEntity> FashionPhotoEntities, List<FashionHashtagEntity> FashionHashtagEntities) { 
        List<MyPageSaveFashion> myPageSaveFashions = new ArrayList<>();
        for (FashionEntity FashionEntity : FashionEntities) {
            MyPageSaveFashion myPageSaveFashion = new MyPageSaveFashion(FashionEntity, FashionPhotoEntities, FashionHashtagEntities);
            myPageSaveFashions.add(myPageSaveFashion);
        }
        return myPageSaveFashions;
    }
}
