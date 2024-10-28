package com.koreait.mzpick_backend.common.object.fashion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionLikeEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionSaveEntity;

import lombok.Getter;

@Getter
public class Fashion {
    private Integer fashionNumber;
    private String userId;
    private String fashionPhoto;
    private List<String> fashionHashtagList;
    private List<String> fashionLikeUserList;
    private List<String> fashionSaveUserList;
    private Integer fashionSaveCount;
    private Integer fashionLikeCount;
    private Integer totalPrice;
    private Integer fashionViewCount;
    private LocalDate fashionDate;

    public Fashion(FashionEntity fashionEntity, List<FashionPhotoEntity> fashionPhotoEntities, List<FashionHashtagEntity> fashionHashtagEntities, List<FashionLikeEntity> fashionLikeEntities, List<FashionSaveEntity> fashionSaveEntities) {

        List<String> fashionPhotoList = new ArrayList<>();
        for (FashionPhotoEntity fashionPhotoEntity : fashionPhotoEntities) fashionPhotoList.add(fashionPhotoEntity.getFashionPhotoLink());
        List<String> fashionHashtagList = new ArrayList<>();
        for (FashionHashtagEntity fashionHashtagEntity : fashionHashtagEntities) fashionHashtagList.add(fashionHashtagEntity.getFashionHashtagContent());
        List<String> fashionLikeUserList = new ArrayList<>();
        for (FashionLikeEntity fashionLikeEntity : fashionLikeEntities) fashionLikeUserList.add(fashionLikeEntity.getUserId());
        List<String> fashionSaveUserList = new ArrayList<>();
        for (FashionSaveEntity fashionSaveEntity : fashionSaveEntities) fashionSaveUserList.add(fashionSaveEntity.getUserId());

        this.fashionNumber = fashionEntity.getFashionNumber();
        this.userId = fashionEntity.getUserId();
        this.fashionPhoto = fashionPhotoList.get(0);
        this.fashionHashtagList = fashionHashtagList;
        this.fashionLikeUserList = fashionLikeUserList;
        this.fashionSaveUserList = fashionSaveUserList;
        this.totalPrice = fashionEntity.getFashionTotalPrice();
        this.fashionLikeCount = fashionEntity.getFashionLikeCount();
        this.fashionSaveCount = fashionEntity.getFashionSaveCount();
        this.fashionViewCount = fashionEntity.getFashionViewCount();
        this.fashionDate = fashionEntity.getFashionDate();
    }

}
