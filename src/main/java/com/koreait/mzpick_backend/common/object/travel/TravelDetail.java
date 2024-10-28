package com.koreait.mzpick_backend.common.object.travel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;
import com.koreait.mzpick_backend.entity.travel.TravelSaveEntity;

import lombok.Getter;

@Getter
public class TravelDetail {
    private Integer travelNumber;
    private String travelTitle;
    private List<String> travelPhotoList;
    private List<String> travelHashtagList;
    private List<String> travelLikeList;
    private List<String> travelSaveList;
    private Integer travelViewCount;
    private Integer travelLikeCount;
    private Integer travelSaveCount;
    private LocalDate travelDate;

    public TravelDetail(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities, List<TravelSaveEntity> travelSaveEntities){

        List<String> travelPhotoList = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) travelPhotoList.add(travelPhotoEntity.getTravelPhotoLink());
        
        List<String> travelHashtagList = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntitiy: travelHashtagEntities) travelHashtagList.add(travelHashtagEntitiy.getTravelHashtagContent());
        
        List<String> travelLikeUserList = new ArrayList<>();
        for (TravelLikeEntity travelLikeEntity: travelLikeEntities) travelLikeUserList.add(travelLikeEntity.getUserId());

        List<String> travelSaveUserList = new ArrayList<>();
        for (TravelSaveEntity travelSaveEntity: travelSaveEntities) travelSaveUserList.add(travelSaveEntity.getUserId());

        this.travelNumber = travelEntity.getTravelNumber();
        this.travelTitle = travelEntity.getTravelTitle();
        this.travelPhotoList = travelPhotoList;
        this.travelHashtagList = travelHashtagList;
        this.travelLikeList = travelLikeUserList;
        this.travelSaveList = travelSaveUserList;
        this.travelSaveCount = travelSaveList.size();
        this.travelLikeCount = travelLikeList.size();
        this.travelViewCount = travelEntity.getTravelViewCount();
        this.travelDate = travelEntity.getTravelDate();
    }
}

