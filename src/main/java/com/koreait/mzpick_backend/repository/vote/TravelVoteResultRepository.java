package com.koreait.mzpick_backend.repository.vote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.vote.TravelVoteResultEntity;
import com.koreait.mzpick_backend.entity.vote.TravelVoteResultPK;
import com.koreait.mzpick_backend.entity.travel.resultSet.GetTravelVoteResultSet;

// Repository 여행지 투표 결과 //
@Repository
public interface TravelVoteResultRepository extends JpaRepository<TravelVoteResultEntity, TravelVoteResultPK> {
    List<TravelVoteResultEntity> findByTravelVoteNumber(Integer travelVoteNumber);
    boolean existsByUserIdAndTravelVoteNumber(String userId, Integer travelVoteNumber);
    TravelVoteResultEntity findByUserIdAndTravelVoteNumber(String userId, Integer travelVoteNumber);

    @Query(value = 
    "SELECT travel_vote_result_choice as choice, count(*) as count " +
    "FROM mzpick.travel_vote_result " +
    "WHERE travel_vote_number = :travelVoteNumber " +
    "GROUP BY travel_vote_result_choice",
    nativeQuery=true)
    List<GetTravelVoteResultSet> totalVoteResultCount(@Param("travelVoteNumber") Integer travelVoteNumber);
}
