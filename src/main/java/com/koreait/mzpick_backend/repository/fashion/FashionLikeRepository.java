package com.koreait.mzpick_backend.repository.fashion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionLikeEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionLikepk;

@Repository
public interface FashionLikeRepository extends JpaRepository<FashionLikeEntity, FashionLikepk> {
    boolean existsByUserIdAndFashionNumber(String userId, Integer fashionNumber);
    List<FashionLikeEntity> findByFashionNumber(Integer fashionNumber);
    List<FashionLikeEntity> findByUserId(String userId);
}
