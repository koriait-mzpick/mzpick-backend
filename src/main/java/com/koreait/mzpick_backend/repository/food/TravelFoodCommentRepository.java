package com.koreait.mzpick_backend.repository.food;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.food.TravelFoodCommentEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TravelFoodCommentRepository extends JpaRepository<TravelFoodCommentEntity, Integer> {
    TravelFoodCommentEntity findByTravelFoodCommentNumber(Integer travelFoodCommentNumber);

    List<TravelFoodCommentEntity> findByTravelFoodNumber(Integer travelFoodNumber);

    TravelFoodCommentEntity findByTravelFoodCommentNumberAndTravelFoodNumber(Integer travelFoodNumber, Integer travelFoodCommentNumber);

    @Transactional
    void deleteByTravelFoodNumber(Integer travelFoodNumber);

    @Transactional
    void deleteByTravelFoodCommentNumber(Integer travelFoodCommentNumber);
}
