package com.koreait.mzpick_backend.repository.cafe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeSaveEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeSavepk;

@Repository
public interface TravelCafeSaveRepository extends JpaRepository<TravelCafeSaveEntity, TravelCafeSavepk> {
    boolean existsByUserIdAndTravelCafeNumber(String userId, Integer travelCafeNumber);

    List<TravelCafeSaveEntity> findByTravelCafeNumber(Integer travelCafeNumber);
    List<TravelCafeSaveEntity> findByUserId(String userId);

}
