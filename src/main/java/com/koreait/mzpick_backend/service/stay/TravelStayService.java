package com.koreait.mzpick_backend.service.stay;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.stay.PatchTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetTravelStayHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardStayListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeStayListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveStayListResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayListResponseDto;

//service 여행지 서비스 //
public interface TravelStayService {
    ResponseEntity<? super GetTravelStayListResponseDto> getTravelStayList(Integer page);

    ResponseEntity<? super GetTravelStayDetailResponseDto> getTravelStay(Integer travelStayNumber);

    ResponseEntity<ResponseDto> postTravelStay(PostTravelStayRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelStay(PatchTravelStayRequestDto dto, Integer travelStayNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelStay(Integer travelStayNumber, String userId);

    ResponseEntity<ResponseDto> putLike(Integer travelStayNumber, String userId);

    ResponseEntity<ResponseDto> putSave(Integer travelStayNumber, String userId);

    ResponseEntity<ResponseDto> upTravelStayViewCount(Integer travelStayNumber);

    ResponseEntity<? super GetMyPageLikeStayListResponseDto> myPageLikeStayList(String userId);

    ResponseEntity<? super GetMyPageBoardStayListResponseDto> myPageBoardStayList(String userId);

    ResponseEntity<? super GetTravelStayHallOfFameResponseDto> travelStayHallOfFame();

    ResponseEntity<? super GetMyPageSaveStayListResponseDto> userSaveStay(String userId);

}
