package com.koreait.mzpick_backend.repository.cafe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TravelCafeHashtagRepository extends JpaRepository<TravelCafeHashtagEntity, Integer> {
    List<TravelCafeHashtagEntity> findByTravelCafeNumber(Integer travelCafeNumber);

    @Transactional
    void deleteByTravelCafeNumber(Integer travelCafeNumber);
}
