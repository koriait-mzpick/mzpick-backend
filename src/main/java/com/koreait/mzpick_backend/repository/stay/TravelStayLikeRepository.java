package com.koreait.mzpick_backend.repository.stay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayLikeEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayLikepk;

import jakarta.transaction.Transactional;

@Repository
public interface TravelStayLikeRepository extends JpaRepository<TravelStayLikeEntity, TravelStayLikepk> {
    boolean existsByUserIdAndTravelStayNumber(String userId, Integer travelStayNumber);

    List<TravelStayLikeEntity> findByTravelStayNumber(Integer travelStayNumber);
    List<TravelStayLikeEntity> findByUserId(String userId);
    
    @Transactional
    void deleteByTravelStayNumber(Integer travelStayNumber);
}

