package com.koreait.mzpick_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardCafeListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardFoodListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardStayListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeCafeListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeFoodListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeStayListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveCafeListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveFoodListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveStayListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.user.GetUserDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.vote.GetMyPageVoteFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.vote.GetMyPageVoteTravelListResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeService;
import com.koreait.mzpick_backend.service.fashion.FashionService;
import com.koreait.mzpick_backend.service.food.TravelFoodService;
import com.koreait.mzpick_backend.service.stay.TravelStayService;
import com.koreait.mzpick_backend.service.travel.TravelService;
import com.koreait.mzpick_backend.service.user.UserService;
import com.koreait.mzpick_backend.service.vote.FashionVoteService;
import com.koreait.mzpick_backend.service.vote.TravelVoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/mypage")
@RequiredArgsConstructor
public class mypageController {
        private final UserService userService;
        private final TravelService travelService;
        private final TravelCafeService travelCafeService;
        private final TravelStayService travelStayService;
        private final TravelFoodService travelFoodService;
        private final FashionService fashionService;
        private final FashionVoteService fashionVoteService;
        private final TravelVoteService travelVoteService;

        @DeleteMapping("/user")
        public ResponseEntity<ResponseDto> userDelete(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<ResponseDto> response = userService.userDelete(userId);
                return response;
        }

        @GetMapping(value = { "/user", "/user/" })
        public ResponseEntity<? super GetUserDetailResponseDto> userDetail(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetUserDetailResponseDto> response = userService.userDetail(userId);
                return response;
        }

        @GetMapping("/travel-save")
        public ResponseEntity<? super GetMyPageSaveTravelListResponseDto> myPageTravelSaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveTravelListResponseDto> response = travelService
                                .userSaveTravel(userId);
                return response;
        }

        @GetMapping("/cafe-save")
        public ResponseEntity<? super GetMyPageSaveCafeListResponseDto> myPageCafeSaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveCafeListResponseDto> response = travelCafeService
                                .userSaveCafe(userId);
                return response;
        }

        @GetMapping("/food-save")
        public ResponseEntity<? super GetMyPageSaveFoodListResponseDto> myPageFoodSaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveFoodListResponseDto> response = travelFoodService
                                .userSaveFood(userId);
                return response;
        }

        @GetMapping("/stay-save")
        public ResponseEntity<? super GetMyPageSaveStayListResponseDto> myPageStaySaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveStayListResponseDto> response = travelStayService
                                .userSaveStay(userId);
                return response;
        }

        @GetMapping("/fashion-save")
        public ResponseEntity<? super GetMyPageSaveFashionListResponseDto> myPageFashionSaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveFashionListResponseDto> response = fashionService
                                .userSaveFashion(userId);
                return response;
        }

        @GetMapping("/write-travel")

        public ResponseEntity<? super GetMyPageBoardTravelListResponseDto> myPageBoardTravelList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageBoardTravelListResponseDto> response = travelService
                                .myPageBoardTravelList(userId);
                return response;
        }

        @GetMapping("/write-fashion")
        public ResponseEntity<? super GetMyPageBoardFashionListResponseDto> myPageBoardFashionList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageBoardFashionListResponseDto> response = fashionService
                                .myPageBoardFashionList(userId);
                return response;
        }

        @GetMapping("/write-food")
        public ResponseEntity<? super GetMyPageBoardFoodListResponseDto> myPageBoardFoodList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageBoardFoodListResponseDto> response = travelFoodService
                                .myPageBoardFoodList(userId);
                return response;
        }


        @GetMapping("/write-cafe")
        public ResponseEntity<? super GetMyPageBoardCafeListResponseDto> myPageBoardCafeList(
                        @AuthenticationPrincipal String userId
        ) {
                ResponseEntity<? super GetMyPageBoardCafeListResponseDto> response = travelCafeService
                                .myPageBoardCafeList(userId);
                return response;
        }

        @GetMapping("/write-stay")
        public ResponseEntity<? super GetMyPageBoardStayListResponseDto> myPageBoardStayList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageBoardStayListResponseDto> response = travelStayService
                                .myPageBoardStayList(userId);
                return response;
        }

        // 좋아요 가져오기
        @GetMapping("/like-travel")
        public ResponseEntity<? super GetMyPageLikeTravelListResponseDto> myPageLikeTravelList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeTravelListResponseDto> response = travelService
                                .myPageLikeTravelList(userId);
                return response;
        }

        @GetMapping("/like-fashion")
        public ResponseEntity<? super GetMyPageLikeFashionListResponseDto> myPageLikeFashionList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeFashionListResponseDto> response = fashionService
                                .myPageLikeFashionList(userId);
                return response;
        }

        @GetMapping("/like-food")
        public ResponseEntity<? super GetMyPageLikeFoodListResponseDto> myPageLikeFoodList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeFoodListResponseDto> response = travelFoodService
                                .myPageLikeFoodList(userId);
                return response;
        }

        @GetMapping("/like-stay")
        public ResponseEntity<? super GetMyPageLikeStayListResponseDto> myPageLikeStayList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeStayListResponseDto> response = travelStayService
                                .myPageLikeStayList(userId);
                return response;
        }

        @GetMapping("/like-cafe")
        public ResponseEntity<? super GetMyPageLikeCafeListResponseDto> myPageLikeCafeList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeCafeListResponseDto> response = travelCafeService
                                .myPageLikeCafeList(userId);
                return response;
        }

        @GetMapping("/vote-fashion")
        public ResponseEntity<? super GetMyPageVoteFashionListResponseDto> myPageVoteFashionList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageVoteFashionListResponseDto> response = fashionVoteService
                                .myPageVoteFashionList(userId);
                return response;
        }

        @GetMapping("/vote-travel")
        public ResponseEntity<? super GetMyPageVoteTravelListResponseDto> myPageVoteTravelList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageVoteTravelListResponseDto> response = travelVoteService
                                .myPageVoteTravelList(userId);
                return response;
        }
}
