package com.koreait.mzpick_backend.common.object.travel;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;
import com.koreait.mzpick_backend.entity.travel.TravelSaveEntity;

import lombok.Getter;

@Getter
public class Travel {
    private Integer travelNumber;
    private String userId;
    private String travelLocation;
    private String travelPhoto;
    private List<String> travelHashtagList;
    private List<String> travelLikeUserList;
    private List<String> travelSaveUserList;
    private Integer travelSaveCount;
    private Integer travelLikeCount;
    private Integer travelViewCount;
    private LocalDateTime travelDate;

    public Travel(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities,  List<TravelLikeEntity> travelLikeEntities, List<TravelSaveEntity> travelSaveEntities ) {
        
        List<String> travelPhotoList = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) travelPhotoList.add(travelPhotoEntity.getTravelPhotoLink());
        
        List<String> travelHashtagList = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntity: travelHashtagEntities) travelHashtagList.add(travelHashtagEntity.getTravelHashtagContent());
        
        List<String> travelLikeUserList = new ArrayList<>();
        for (TravelLikeEntity travelLikeEntity : travelLikeEntities) travelLikeUserList.add(travelLikeEntity.getUserId());

        List<String> travelSaveUserList = new ArrayList<>();
        for (TravelSaveEntity travelSaveEntity : travelSaveEntities) travelSaveUserList.add(travelSaveEntity.getUserId());

        this.travelNumber = travelEntity.getTravelNumber();
        this.userId = travelEntity.getUserId();
        this.travelLocation = travelEntity.getTravelLocation();
        this.travelPhoto = travelPhotoList.size() != 0 ? travelPhotoList.get(0) : null;
        this.travelHashtagList = travelHashtagList;
        this.travelLikeUserList = travelLikeUserList;
        this.travelSaveUserList = travelSaveUserList;
        this.travelLikeCount = travelEntity.getTravelLikeCount();
        this.travelSaveCount = travelEntity.getTravelSaveCount();
        this.travelViewCount = travelEntity.getTravelViewCount();
        this.travelDate = travelEntity.getTravelDate();
        
    }

    public static List<Travel> getList(List<TravelEntity> travelEntities,List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities,  List<TravelLikeEntity> travelLikeEntities, List<TravelSaveEntity> travelSaveEntities) {
        List<Travel> travels = new ArrayList<>();

        for (TravelEntity travelEntity: travelEntities) {
            Travel travel = new Travel(travelEntity, travelPhotoEntities, travelHashtagEntities, travelLikeEntities, travelSaveEntities);
            travels.add(travel);
        }
        return travels;
    }
}