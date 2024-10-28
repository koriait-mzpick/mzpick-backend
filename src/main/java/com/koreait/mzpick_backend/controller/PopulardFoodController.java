package com.koreait.mzpick_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.popular_food.PopularFoodService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/popular-food")
@RequiredArgsConstructor
public class PopulardFoodController {
    
    private final PopularFoodService popularFoodService;

    // @GetMapping(value={"", "/"})
    // public ResponseEntity<ResponseDto> getPopularFood() {
    //     ResponseEntity<ResponseDto> response = popularFoodService.getPopularFood();
    //     return response;
    // }

    // @PostMapping("/save")
    // public ResponseEntity<ResponseDto> postPopularFood(
    //     @RequestBody @Valid String dto,
    //     @AuthenticationPrincipal String userId
    // ) {
    //     ResponseEntity<ResponseDto> response = popularFoodService.postPopularFood(dto, userId);
    //     return response;
    // }
}
