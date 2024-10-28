package com.koreait.mzpick_backend.service.user;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.user.GetUserDetailResponseDto;

public interface UserService {
    
    ResponseEntity<ResponseDto> userDelete(String userId);
    ResponseEntity<? super GetUserDetailResponseDto> userDetail(String userId);

}
