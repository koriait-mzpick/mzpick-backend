package com.koreait.mzpick_backend.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.auth.UserEntity;


@Repository
public interface  UserRepository extends JpaRepository<UserEntity, String>{
    
    boolean existsByUserId(String userId);
    boolean existsByTelNumber(String telNumber);

    UserEntity findByUserId(String userId);
    UserEntity findBySnsIdAndJoinPath(String sns, String joinPath);
    
}
