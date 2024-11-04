package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetTravelHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelTotalCountResponsDto;

//service 여행지 서비스 //
public interface TravelService {
    ResponseEntity<? super GetTravelListResponseDto> getTravelList(Integer page);

    ResponseEntity<? super GetTravelDetailResponseDto> getTravel(Integer travelNumber);

    ResponseEntity<? super GetTravelTotalCountResponsDto> travelTotalCount();

    ResponseEntity<ResponseDto> postTravel(PostTravelRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravel(PatchTravelRequestDto dto, Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravel(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> putLike(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> upTravelViewCount(Integer travelNumber);
    
    ResponseEntity<? super GetMyPageLikeTravelListResponseDto> myPageLikeTravelList(String userId);

    ResponseEntity<? super GetMyPageBoardTravelListResponseDto> myPageBoardTravelList(String userId);

    ResponseEntity<? super GetTravelHallOfFameResponseDto> travelHallOfFame();

    ResponseEntity<? super GetMyPageSaveTravelListResponseDto> userSaveTravel(String userId);

}
