package com.koreait.mzpick_backend.repository.food;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.food.TravelFoodLikeEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodLikepk;

@Repository
public interface TravelFoodLikeRepository extends JpaRepository<TravelFoodLikeEntity, TravelFoodLikepk> {
    boolean existsByUserIdAndTravelFoodNumber(String userId, Integer travelFoodNumber);
    List<TravelFoodLikeEntity> findByTravelFoodNumber(Integer travelFoodNumber);
    List<TravelFoodLikeEntity> findByUserId(String userId);
}
