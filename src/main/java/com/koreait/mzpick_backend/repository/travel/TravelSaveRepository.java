package com.koreait.mzpick_backend.repository.travel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelSaveEntity;
import com.koreait.mzpick_backend.entity.travel.TravelSavePK;

// Repository 여행지 저장 레포지토리 //
@Repository
public interface TravelSaveRepository extends JpaRepository<TravelSaveEntity, TravelSavePK> {
    boolean existsByUserIdAndTravelNumber(String userId, Integer travelNumber);

    List<TravelSaveEntity> findByTravelNumber(Integer travelNumber);
    List<TravelSaveEntity> findByUserId(String userId);

}
