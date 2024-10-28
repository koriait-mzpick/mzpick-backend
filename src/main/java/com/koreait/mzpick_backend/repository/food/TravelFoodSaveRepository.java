package com.koreait.mzpick_backend.repository.food;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.food.TravelFoodSaveEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodSavepk;

@Repository
public interface TravelFoodSaveRepository extends JpaRepository<TravelFoodSaveEntity, TravelFoodSavepk> {
    boolean existsByUserIdAndTravelFoodNumber(String userId, Integer travelFoodNumber);

    List<TravelFoodSaveEntity> findByTravelFoodNumber(Integer travelFoodNumber);
    List<TravelFoodSaveEntity> findByUserId(String userId);
}
