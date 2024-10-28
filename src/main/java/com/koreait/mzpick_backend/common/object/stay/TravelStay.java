package com.koreait.mzpick_backend.common.object.stay;

import java.time.LocalDate;
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
public class TravelStay {
    private Integer traveStayNumber;
    private String travelStayPhoto;
    private List<String> travelStayHashtag;
    private List<String> travelStayCategory;
    private List<String> travelStayLikeUserList;
    private List<String> travelStaySaveUserList;
    private Integer travelStayViewCount;
    private Integer travelStayLikeCount;
    private Integer travelStaySaveCount;
    private LocalDate travelStayDate;

    public TravelStay(TravelStayEntity travelStayEntity, List<TravelStayPhotoEntity> travelStayPhotoEntities,
            List<TravelStayHashtagEntity> travelStayHashtagEntities,
            List<TravelStayCategoryEntity> travelStayCategoryEntities,
            List<TravelStayLikeEntity> travelStayLikeEntities, List<TravelStaySaveEntity> travelStaySaveEntities) {
        List<String> travelStayPhoto = new ArrayList<>();
        for (TravelStayPhotoEntity travelStayPhotoEntity : travelStayPhotoEntities)
            travelStayPhoto.add(travelStayPhotoEntity.getTravelStayPhotoLink());

        List<String> travelStayHashtag = new ArrayList<>();
        for (TravelStayHashtagEntity travelStayHashtagEntity : travelStayHashtagEntities)
            travelStayHashtag.add(travelStayHashtagEntity.getTravelStayHashtagContent());

        List<String> travelStayCategory = new ArrayList<>();
        for (TravelStayCategoryEntity TravelStayCategoryEntity : travelStayCategoryEntities)
            travelStayCategory.add(TravelStayCategoryEntity.getTravelStayCategoryContent());

        List<String> travelStayLikeUserList = new ArrayList<>();
        for (TravelStayLikeEntity travelStayLikeEntity : travelStayLikeEntities)
            travelStayLikeUserList.add(travelStayLikeEntity.getUserId());

        List<String> travelStaySaveUserList = new ArrayList<>();
        for (TravelStaySaveEntity travelStaySaveEntity : travelStaySaveEntities)
            travelStaySaveUserList.add(travelStaySaveEntity.getUserId());

        this.traveStayNumber = travelStayEntity.getTravelStayNumber();
        this.travelStayPhoto = travelStayPhoto.get(0);
        this.travelStayHashtag = travelStayHashtag;
        this.travelStayCategory = travelStayCategory;
        this.travelStayLikeUserList = travelStayLikeUserList;
        this.travelStaySaveUserList = travelStaySaveUserList;
        this.travelStayLikeCount = travelStayEntity.getTravelStayLikeCount();
        this.travelStaySaveCount = travelStayEntity.getTravelStaySaveCount();
        this.travelStayViewCount = travelStayEntity.getTravelStayViewCount();
        this.travelStayDate = travelStayEntity.getTravelStayDate();

    }

    public static List<TravelStay> getList(List<TravelStayEntity> travelStayEntities, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities, List<TravelStayCategoryEntity> travelStayCategoryEntities, List<TravelStayLikeEntity> travelStayLikeEntities, List<TravelStaySaveEntity> travelStaySaveEntities) {
        List<TravelStay> travelStays = new ArrayList<>();

        for (TravelStayEntity travelStayEntity : travelStayEntities) {
            TravelStay travelStay = new TravelStay(travelStayEntity, travelStayPhotoEntities, travelStayHashtagEntities, travelStayCategoryEntities, travelStayLikeEntities, travelStaySaveEntities);
            travelStays.add(travelStay);
        }

        return travelStays;
    }
}
