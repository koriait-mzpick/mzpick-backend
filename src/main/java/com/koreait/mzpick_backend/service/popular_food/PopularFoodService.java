package com.koreait.mzpick_backend.service.popular_food;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface PopularFoodService {
    
    ResponseEntity<ResponseDto> getPopularFood();
    ResponseEntity<ResponseDto> postPopularFood(String dto, String userId);
}
