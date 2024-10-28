package com.koreait.mzpick_backend.repository.fashion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;

import jakarta.transaction.Transactional;

@Repository
public interface FashionPhotoRepository extends JpaRepository<FashionPhotoEntity, Integer> {
    List<FashionPhotoEntity> findByFashionNumber(Integer fashionNumber);
    
    
    @Transactional
    void deleteByFashionNumber(Integer fashionNumber);
}
