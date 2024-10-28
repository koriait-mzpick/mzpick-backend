package com.koreait.mzpick_backend.repository.fashion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionCommentEntity;

import jakarta.transaction.Transactional;

@Repository
public interface FashionCommentRepository extends JpaRepository<FashionCommentEntity, Integer> {
    FashionCommentEntity findByFashionCommentNumber(Integer fashionCommentNumber);
    List<FashionCommentEntity> findByFashionNumber(Integer fashionNumber);
    FashionCommentEntity findByFashionCommentNumberAndFashionNumber (Integer fashionNumber, Integer fashionCommentNumber);

    @Transactional
    void deleteByFashionNumber(Integer fashionNumber);
    @Transactional
    void deleteByFashionCommentNumber(Integer fashionCommentNumber);
}
