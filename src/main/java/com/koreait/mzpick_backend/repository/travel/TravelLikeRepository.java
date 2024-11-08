package com.koreait.mzpick_backend.repository.travel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikePK;

import jakarta.transaction.Transactional;

// Repository 여행지 좋아요 레포지토리 //
@Repository
public interface TravelLikeRepository extends JpaRepository<TravelLikeEntity, TravelLikePK> {
    boolean existsByUserIdAndTravelNumber(String userId, Integer travelNumber);
    List<TravelLikeEntity> findByTravelNumber(Integer travelNumber);
    List<TravelLikeEntity> findByUserId(String userId); 

    @Transactional
    void deleteByTravelNumber(Integer travelNumber);
}
