package com.koreait.mzpick_backend.controller;

import com.koreait.mzpick_backend.dto.response.hallOfFame.*;
import com.koreait.mzpick_backend.service.cafe.TravelCafeService;
import com.koreait.mzpick_backend.service.fashion.FashionService;
import com.koreait.mzpick_backend.service.food.TravelFoodService;
import com.koreait.mzpick_backend.service.stay.TravelStayService;
import com.koreait.mzpick_backend.service.travel.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/hall-of-fame")
@RequiredArgsConstructor
public class hallOfFameController {

    private final TravelService travelService;
    private final TravelCafeService travelCafeService;
    private final TravelFoodService travelFoodService;
    private final TravelStayService travelStayService;
    private final FashionService fashionService;

    @GetMapping(value = {"/travel","/travel/"})
    public ResponseEntity<? super GetTravelHallOfFameResponseDto> travelHallOfFame(){
        ResponseEntity<? super GetTravelHallOfFameResponseDto> response = travelService.travelHallOfFame();
        return response;
    }

    @GetMapping(value = {"/fashion","/fashion/"})
    public ResponseEntity<? super GetFashionHallOfFameResponseDto> FashionHallOfFame(){
        ResponseEntity<? super GetFashionHallOfFameResponseDto> response = fashionService.FashionHallOfFame();
        return response;
    }

    @GetMapping(value = {"/cafe","/cafe/"})
    public ResponseEntity<? super GetTravelCafeHallOfFameResponseDto> travelCafeHallOfFame(){
        ResponseEntity<? super GetTravelCafeHallOfFameResponseDto> response = travelCafeService.travelCafeHallOfFame();
        return response;
    }

    @GetMapping(value = {"/food","/food/"})
    public ResponseEntity<? super GetTravelFoodHallOfFameResponseDto> travelFoodHallOfFame(){
        ResponseEntity<? super GetTravelFoodHallOfFameResponseDto> response = travelFoodService.travelFoodHallOfFame();
        return response;
    }

    @GetMapping(value = {"/stay","/stay/"})
    public ResponseEntity<? super GetTravelStayHallOfFameResponseDto> travelStayHallOfFame(){
        ResponseEntity<? super GetTravelStayHallOfFameResponseDto> response = travelStayService.travelStayHallOfFame();
        return response;
    }
}
