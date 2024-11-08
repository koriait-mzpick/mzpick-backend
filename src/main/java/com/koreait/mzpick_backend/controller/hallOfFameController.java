package com.koreait.mzpick_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.hallOfFame.GetFashionHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetTravelCafeHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetTravelFoodHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetTravelHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetTravelStayHallOfFameResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeService;
import com.koreait.mzpick_backend.service.fashion.FashionService;
import com.koreait.mzpick_backend.service.food.TravelFoodService;
import com.koreait.mzpick_backend.service.stay.TravelStayService;
import com.koreait.mzpick_backend.service.travel.TravelService;

import lombok.RequiredArgsConstructor;

// REST API 컨트롤러 지정 //
@RestController
// API 경로 지정 //
@RequestMapping("/api/v1/hall-of-fame")
// 의존성 주입을 위한 어노테이션 //
@RequiredArgsConstructor
public class hallOfFameController {

    // TravelService 의존성 주입 //
    private final TravelService travelService;
    // TravelCafeService 의존성 주입 //
    private final TravelCafeService travelCafeService;
    // TravelFoodService 의존성 주입 //
    private final TravelFoodService travelFoodService;
    // TravelStayService 의존성 주입 //
    private final TravelStayService travelStayService;
    // FashionService 의존성 주입 //
    private final FashionService fashionService;

    // 여행 명예의 전당 조회 메서드 //
    @GetMapping(value = {"/travel","/travel/"})
    public ResponseEntity<? super GetTravelHallOfFameResponseDto> travelHallOfFame(){
        ResponseEntity<? super GetTravelHallOfFameResponseDto> response = travelService.travelHallOfFame();
        return response;
    }

    // 패션 명예의 전당 조회 메서드 //
    @GetMapping(value = {"/fashion","/fashion/"})
    public ResponseEntity<? super GetFashionHallOfFameResponseDto> FashionHallOfFame(){
        ResponseEntity<? super GetFashionHallOfFameResponseDto> response = fashionService.FashionHallOfFame();
        return response;
    }

    // 카페 명예의 전당 조회 메서드 //
    @GetMapping(value = {"/cafe","/cafe/"})
    public ResponseEntity<? super GetTravelCafeHallOfFameResponseDto> travelCafeHallOfFame(){
        ResponseEntity<? super GetTravelCafeHallOfFameResponseDto> response = travelCafeService.travelCafeHallOfFame();
        return response;
    }

    // 음식점 명예의 전당 조회 메서드 //
    @GetMapping(value = {"/food","/food/"})
    public ResponseEntity<? super GetTravelFoodHallOfFameResponseDto> travelFoodHallOfFame(){
        ResponseEntity<? super GetTravelFoodHallOfFameResponseDto> response = travelFoodService.travelFoodHallOfFame();
        return response;
    }

    // 숙소 명예의 전당 조회 메서드 //
    @GetMapping(value = {"/stay","/stay/"})
    public ResponseEntity<? super GetTravelStayHallOfFameResponseDto> travelStayHallOfFame(){
        ResponseEntity<? super GetTravelStayHallOfFameResponseDto> response = travelStayService.travelStayHallOfFame();
        return response;
    }
}
