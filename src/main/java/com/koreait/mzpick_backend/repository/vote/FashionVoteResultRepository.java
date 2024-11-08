package com.koreait.mzpick_backend.repository.vote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.resultSet.GetFashionVoteResultSet;
import com.koreait.mzpick_backend.entity.vote.FashionVoteResultEntity;
import com.koreait.mzpick_backend.entity.vote.FashionVoteResultpk;

@Repository
public interface FashionVoteResultRepository extends JpaRepository<FashionVoteResultEntity, FashionVoteResultpk> {
    List<FashionVoteResultEntity> findByFashionVoteNumber(Integer FashionVoteNumber);
    boolean existsByUserIdAndFashionVoteNumber(String userId, Integer FashionVoteNumber);
    FashionVoteResultEntity findByUserIdAndFashionVoteNumber(String userId, Integer fashionVoteNumber);


    @Query(value = 
    "SELECT fashion_vote_result_choice as choice, count(*) as count " +
    "FROM mzpick.fashion_vote_result " +
    "WHERE fashion_vote_number = :fashionVoteNumber " +
    "GROUP BY fashion_vote_result_choice",
    nativeQuery=true)
    List<GetFashionVoteResultSet> totalVoteResultCount(@Param("fashionVoteNumber") Integer fashionVoteNumber);
}
