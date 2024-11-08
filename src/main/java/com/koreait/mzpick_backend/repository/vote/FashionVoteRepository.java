package com.koreait.mzpick_backend.repository.vote;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.vote.FashionVoteEntity;

@Repository
public interface FashionVoteRepository extends JpaRepository<FashionVoteEntity, Integer> {
   FashionVoteEntity findByFashionVoteNumber(Integer fashionVoteNumber);
   List<FashionVoteEntity> findByFashionVoteExpireDateGreaterThanEqual(LocalDateTime now);
   List<FashionVoteEntity> findByUserId(String userId);}
