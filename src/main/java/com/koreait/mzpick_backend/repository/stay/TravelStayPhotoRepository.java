package com.koreait.mzpick_backend.repository.stay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TravelStayPhotoRepository extends JpaRepository<TravelStayPhotoEntity, Integer> {
        
    List<TravelStayPhotoEntity> findByTravelStayNumber(Integer travelStayNumber);
    
    @Transactional
    void deleteByTravelStayNumber(Integer travelStayNumber);
}
