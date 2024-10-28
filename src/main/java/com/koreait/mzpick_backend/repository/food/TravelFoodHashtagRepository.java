package com.koreait.mzpick_backend.repository.food;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TravelFoodHashtagRepository extends JpaRepository<TravelFoodHashtagEntity, Integer> {
    List<TravelFoodHashtagEntity> findByTravelFoodNumber(Integer travelFoodNumber);

    @Transactional
    void deleteByTravelFoodNumber(Integer travelFoodNumber);
}
