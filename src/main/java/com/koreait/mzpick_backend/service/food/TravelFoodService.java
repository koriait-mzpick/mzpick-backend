package com.koreait.mzpick_backend.service.food;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.food.PatchTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodListResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodTotalCountResponsDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetTravelFoodHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardFoodListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeFoodListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveFoodListResponseDto;

//service 여행지 서비스 //
public interface TravelFoodService {
    ResponseEntity<? super GetTravelFoodListResponseDto> getTravelFoodList(Integer page);

    ResponseEntity<? super GetTravelFoodDetailResponseDto> getTravelFood(Integer travelNumber);
    
    ResponseEntity<? super GetTravelFoodTotalCountResponsDto> travelFoodTotalCount();

    ResponseEntity<ResponseDto> postTravelFood(PostTravelFoodRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelFood(PatchTravelFoodRequestDto dto, Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelFood(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> putLike(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> upTravelFoodViewCount(Integer travelNumber);

    ResponseEntity<? super GetMyPageLikeFoodListResponseDto> myPageLikeFoodList(String userId);

    ResponseEntity<? super GetMyPageBoardFoodListResponseDto> myPageBoardFoodList(String userId);

    ResponseEntity<? super GetTravelFoodHallOfFameResponseDto> travelFoodHallOfFame();

    ResponseEntity<? super GetMyPageSaveFoodListResponseDto> userSaveFood(String userId);

}
