package com.koreait.mzpick_backend.repository.stay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TravelStayHashtagRepository extends JpaRepository<TravelStayHashtagEntity, Integer> {
    List<TravelStayHashtagEntity> findByTravelStayNumber(Integer travelStayNumber);

    @Transactional
    void deleteByTravelStayNumber(Integer travelStayNumber);
}
