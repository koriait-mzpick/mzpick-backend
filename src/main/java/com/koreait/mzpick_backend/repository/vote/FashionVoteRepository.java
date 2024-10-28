package com.koreait.mzpick_backend.repository.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.koreait.mzpick_backend.entity.vote.FashionVoteEntity;

@Repository
public interface FashionVoteRepository extends JpaRepository<FashionVoteEntity, Integer> {
   FashionVoteEntity findByFashionVoteNumber(Integer fashionVoteNumber);
   List<FashionVoteEntity> findByUserId(String userId);
}
