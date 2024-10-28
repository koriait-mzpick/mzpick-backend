package com.koreait.mzpick_backend.repository.stay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStaySaveEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStaySavepk;

import jakarta.transaction.Transactional;

@Repository
public interface TravelStaySaveRepository extends JpaRepository<TravelStaySaveEntity, TravelStaySavepk > {
    boolean existsByUserIdAndTravelStayNumber(String userId, Integer travelStayNumber);

    List<TravelStaySaveEntity> findByTravelStayNumber(Integer travelStayNumber);
    List<TravelStaySaveEntity> findByUserId(String userId);

    @Transactional
    void deleteByTravelStayNumber(Integer travelStayNumber);
}
