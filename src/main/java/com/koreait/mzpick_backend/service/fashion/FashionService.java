package com.koreait.mzpick_backend.service.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.fashion.PatchFashionRequestDto;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionTotalCountResponsDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetFashionHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveFashionListResponseDto;

public interface FashionService {
    ResponseEntity<? super GetFashionListResponseDto> getFashionList(Integer page);

    ResponseEntity<? super GetFashionDetailResponseDto> getFashion(Integer fashionNumber);
    
    ResponseEntity<? super GetFashionTotalCountResponsDto> getFashionTotalCount();

    ResponseEntity<ResponseDto> postFashion(PostFashionRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchFashion(PatchFashionRequestDto dto, Integer fashionNumber, String userId);

    ResponseEntity<ResponseDto> deleteFashion(Integer fashionNumber, String userId);

    ResponseEntity<ResponseDto> putLike(Integer fashionNumber, String userId);

    ResponseEntity<ResponseDto> putSave(Integer fashionNumber, String userId);

    ResponseEntity<ResponseDto> upFashionViewCount(Integer travelNumber);

    ResponseEntity<? super GetMyPageLikeFashionListResponseDto> myPageLikeFashionList(String userId);
    
    ResponseEntity<? super GetMyPageBoardFashionListResponseDto> myPageBoardFashionList(String userId);

    ResponseEntity<? super GetFashionHallOfFameResponseDto> FashionHallOfFame();

    ResponseEntity<? super GetMyPageSaveFashionListResponseDto> userSaveFashion(String userId);

}
