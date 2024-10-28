package com.koreait.mzpick_backend.service.implement.popular_food;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.popular_food.PopularFoodService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PopularFoodServiceImplement implements PopularFoodService{@Override
    public ResponseEntity<ResponseDto> getPopularFood() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPopularFood'");
    }

    @Override
    public ResponseEntity<ResponseDto> postPopularFood(String dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postPopularFood'");
    }
    
}
