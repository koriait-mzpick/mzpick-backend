package com.koreait.mzpick_backend.common.object.stay;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayCategoryEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayLikeEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStaySaveEntity;

import lombok.Getter;

@Getter
public class TravelStayDetail {
    private Integer travelStayNumber;
    private String travelStayTitle;
    private String travelLocathion;
    private String userId;
    private List<String> travelStayCategory;
    private List<String> travelStayPhotoList;
    private List<String> travelStayHashtagList;
    private List<String> travelStayLikeUserList;
    private List<String> travelStaySaveUserList;
    private Integer travelStayViewCount;
    private Integer travelStayLikeCount;
    private Integer travelStaySaveCount;
    private String travelStayContent;
    private LocalDateTime travelStayDate;

    public TravelStayDetail(TravelStayEntity travelStayEntity, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities, List<TravelStayLikeEntity> travelStayLikeEntities, List<TravelStaySaveEntity> travelStaySaveEntities, List<TravelStayCategoryEntity> travelStayCategoryEntities){

        List<String> travelStayCategory = new ArrayList<>();
        for (TravelStayCategoryEntity travelStayCategoryEntity: travelStayCategoryEntities) travelStayCategory.add(travelStayCategoryEntity.getTravelStayCategoryContent());

        List<String> travelStayPhoto = new ArrayList<>();
        for (TravelStayPhotoEntity travelStayPhotoEntity: travelStayPhotoEntities) travelStayPhoto.add(travelStayPhotoEntity.getTravelStayPhotoLink());
        
        List<String> travelStayHashtag = new ArrayList<>();
        for (TravelStayHashtagEntity travelStayHashtagEntitiy: travelStayHashtagEntities) travelStayHashtag.add(travelStayHashtagEntitiy.getTravelStayHashtagContent());
        
        List<String> travelStayLikeUserList = new ArrayList<>();
        for (TravelStayLikeEntity travelStayLikeEntity: travelStayLikeEntities) travelStayLikeUserList.add(travelStayLikeEntity.getUserId());

        List<String> travelStaySaveUserList = new ArrayList<>();
        for (TravelStaySaveEntity travelStaySaveEntity: travelStaySaveEntities) travelStaySaveUserList.add(travelStaySaveEntity.getUserId());

        this.travelStayNumber = travelStayEntity.getTravelStayNumber();
        this.travelStayTitle = travelStayEntity.getTravelStayTitle();
        this.travelLocathion = travelStayEntity.getTravelLocation();
        this.userId = travelStayEntity.getUserId();
        this.travelStayCategory  = travelStayCategory;
        this.travelStayPhotoList = travelStayPhoto;
        this.travelStayHashtagList = travelStayHashtag;
        this.travelStayLikeUserList = travelStayLikeUserList;
        this.travelStaySaveUserList = travelStaySaveUserList;
        this.travelStayLikeCount = travelStayLikeUserList.size();
        this.travelStaySaveCount = travelStaySaveUserList.size();
        this.travelStayViewCount = travelStayEntity.getTravelStayViewCount();
        this.travelStayContent = travelStayEntity.getTravelStayContent();
        this.travelStayDate = travelStayEntity.getTravelStayDate();
        this.travelStayContent = travelStayEntity.getTravelStayContent();
    }
}

