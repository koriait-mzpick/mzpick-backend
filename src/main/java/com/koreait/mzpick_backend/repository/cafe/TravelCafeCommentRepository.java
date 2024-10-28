package com.koreait.mzpick_backend.repository.cafe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeCommentEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TravelCafeCommentRepository extends JpaRepository<TravelCafeCommentEntity, Integer> {
    TravelCafeCommentEntity findByTravelCafeCommentNumber(Integer travelCafeCommentNumber);
    List<TravelCafeCommentEntity> findByTravelCafeNumber(Integer travelCafeNumber);
    TravelCafeCommentEntity findByTravelCafeCommentNumberAndTravelCafeNumber(Integer travelCafeNumber, Integer travelCafeCommentNumber);
    
    @Transactional
    void deleteByTravelCafeNumber(Integer travelCafeNumber);

    @Transactional
    void deleteByTravelCafeCommentNumber(Integer travelCafeCommentNumber);
}
