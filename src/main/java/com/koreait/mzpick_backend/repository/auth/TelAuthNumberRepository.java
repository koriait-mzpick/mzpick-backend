package com.koreait.mzpick_backend.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.auth.TelAuthNumberEntity;

@Repository
public interface TelAuthNumberRepository extends JpaRepository<TelAuthNumberEntity, String> {
    boolean existsByTelNumberAndAuthNumber(String telNumber, String authNumber);
    
}
