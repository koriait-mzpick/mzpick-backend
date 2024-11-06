package com.koreait.mzpick_backend.service.cafe;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.cafe.PatchTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeListResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeTotalCountResponsDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetTravelCafeHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardCafeListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeCafeListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveCafeListResponseDto;

//service 여행지 서비스 //
public interface TravelCafeService {
    ResponseEntity<? super GetTravelCafeListResponseDto> getTravelCafeList(Integer page, String searchLocation, String hashtag);

    ResponseEntity<? super GetTravelCafeDetailResponseDto> getTravelCafe(Integer travelCafeNumber);

    ResponseEntity<? super GetTravelCafeTotalCountResponsDto> getTravelCafeTotalCount();

    ResponseEntity<ResponseDto> postTravelCafe(PostTravelCafeRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelCafe(PatchTravelCafeRequestDto dto, Integer travelCafeNumber, String userId);

    ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> putLike(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelCafe(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> upTravelCafeViewCount(Integer travelNumber);

    ResponseEntity<? super GetMyPageLikeCafeListResponseDto> myPageLikeCafeList(String userId);

    ResponseEntity<? super GetMyPageBoardCafeListResponseDto> myPageBoardCafeList(String userId);

    ResponseEntity<? super GetTravelCafeHallOfFameResponseDto> travelCafeHallOfFame();

    ResponseEntity<? super GetMyPageSaveCafeListResponseDto> userSaveCafe(String userId);

}
