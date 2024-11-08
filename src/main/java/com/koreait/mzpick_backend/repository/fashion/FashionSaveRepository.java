package com.koreait.mzpick_backend.repository.fashion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionSaveEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionSavepk;

import jakarta.transaction.Transactional;

@Repository
public interface FashionSaveRepository extends JpaRepository<FashionSaveEntity, FashionSavepk> {
    @Transactional
    void deleteByFashionNumber(Integer fashionNumber);
    boolean existsByUserIdAndFashionNumber(String userId, Integer FashionNumber);

    List<FashionSaveEntity> findByFashionNumber(Integer FashionNumber);
    List<FashionSaveEntity> findByUserId(String userId);
}
