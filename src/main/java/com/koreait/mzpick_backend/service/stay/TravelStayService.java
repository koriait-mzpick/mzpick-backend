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
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayLikeResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayListResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStaySaveResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayTotalCountResponsDto;

//service 여행지 서비스 //
public interface TravelStayService {
    ResponseEntity<? super GetTravelStayListResponseDto> getTravelStayList(Integer page, String searchLocation, String hashtag);

    ResponseEntity<? super GetTravelStayDetailResponseDto> getTravelStay(Integer travelStayNumber);
    
    ResponseEntity<? super GetTravelStayTotalCountResponsDto> travelStayTotalCount();

    ResponseEntity<ResponseDto> postTravelStay(PostTravelStayRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelStay(PatchTravelStayRequestDto dto, Integer travelStayNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelStay(Integer travelStayNumber, String userId);

    ResponseEntity<? super GetTravelStayLikeResponseDto> getTravelStayLike(Integer travelStayNumber);

    ResponseEntity<ResponseDto> putLike(Integer travelStayNumber, String userId);

    ResponseEntity<? super GetTravelStaySaveResponseDto> getTravelStaySave(Integer travelStayNumber);

    ResponseEntity<ResponseDto> putSave(Integer travelStayNumber, String userId);

    ResponseEntity<ResponseDto> upTravelStayViewCount(Integer travelStayNumber);

    ResponseEntity<? super GetMyPageLikeStayListResponseDto> myPageLikeStayList(String userId);

    ResponseEntity<? super GetMyPageBoardStayListResponseDto> myPageBoardStayList(String userId);

    ResponseEntity<? super GetTravelStayHallOfFameResponseDto> travelStayHallOfFame();

    ResponseEntity<? super GetMyPageSaveStayListResponseDto> userSaveStay(String userId);

}
