package com.koreait.mzpick_backend.repository.travel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;

import jakarta.transaction.Transactional;

// Repository 여행지 해시태그 레포지토리 //
@Repository
public interface TravelHashtagRepository extends JpaRepository<TravelHashtagEntity, Integer> {
    List<TravelHashtagEntity> findByTravelNumber(Integer travelNumber);


    @Transactional
    void deleteByTravelNumber(Integer travelNumber);
}
