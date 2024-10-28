package com.koreait.mzpick_backend.repository.stay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayCommentEntity;

import jakarta.transaction.Transactional;


@Repository
public interface TravelStayCommentRepository extends JpaRepository<TravelStayCommentEntity, Integer> {
     TravelStayCommentEntity findByTravelStayCommentNumber(Integer travelStayCommentNumber);

    List<TravelStayCommentEntity> findByTravelStayNumber(Integer travelStayNumber);

    TravelStayCommentEntity findByTravelStayCommentNumberAndTravelStayNumber(Integer travelStayNumber, Integer travelStayCommentNumber);

    @Transactional
    void deleteByTravelStayNumber(Integer travelStayNumber);

    @Transactional
    void deleteByTravelStayCommentNumber(Integer travelStayCommentNumber);
}
