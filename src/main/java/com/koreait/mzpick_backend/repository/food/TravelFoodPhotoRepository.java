package com.koreait.mzpick_backend.repository.food;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TravelFoodPhotoRepository extends JpaRepository<TravelFoodPhotoEntity, Integer> {
    List<TravelFoodPhotoEntity> findByTravelFoodNumber(Integer travelFoodNumber);

    @Transactional
    void deleteByTravelFoodNumber(Integer travelFoodNumber);
}
