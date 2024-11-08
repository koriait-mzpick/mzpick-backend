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
// REST API 컨트롤러 지정 //
@RestController
// API 경로 지정 //
@RequestMapping("/api/v1/mypage")
// 의존성 주입을 위한 어노테이션 //
@RequiredArgsConstructor
public class mypageController {
        // UserService 의존성 주입 //
        private final UserService userService;
        // TravelService 의존성 주입 //
        private final TravelService travelService;
        // TravelCafeService 의존성 주입 //
        private final TravelCafeService travelCafeService;
        // TravelStayService 의존성 주입 //
        private final TravelStayService travelStayService;
        // TravelFoodService 의존성 주입 //
        private final TravelFoodService travelFoodService;
        // FashionService 의존성 주입 //
        private final FashionService fashionService;
        // FashionVoteService 의존성 주입 //
        private final FashionVoteService fashionVoteService;
        // TravelVoteService 의존성 주입 //
        private final TravelVoteService travelVoteService;

        // 회원 탈퇴 메서드 //
        @DeleteMapping("/user")
        public ResponseEntity<ResponseDto> userDelete(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<ResponseDto> response = userService.userDelete(userId);
                return response;
        }

        // 회원 상세정보 조회 메서드 //
        @GetMapping(value = { "/user", "/user/" })
        public ResponseEntity<? super GetUserDetailResponseDto> userDetail(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetUserDetailResponseDto> response = userService.userDetail(userId);
                return response;
        }

        // 저장한 여행 게시글 목록 조회 메서드 //
        @GetMapping("/save-travel")
        public ResponseEntity<? super GetMyPageSaveTravelListResponseDto> myPageTravelSaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveTravelListResponseDto> response = travelService
                                .userSaveTravel(userId);
                return response;
        }

        // 저장한 카페 게시글 목록 조회 메서드 //
        @GetMapping("/save-cafe")
        public ResponseEntity<? super GetMyPageSaveCafeListResponseDto> myPageCafeSaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveCafeListResponseDto> response = travelCafeService
                                .userSaveCafe(userId);
                return response;
        }

        // 저장한 음식점 게시글 목록 조회 메서드 //
        @GetMapping("/save-food")
        public ResponseEntity<? super GetMyPageSaveFoodListResponseDto> myPageFoodSaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveFoodListResponseDto> response = travelFoodService
                                .userSaveFood(userId);
                return response;
        }

        // 저장한 숙소 게시글 목록 조회 메서드 //
        @GetMapping("/save-stay")
        public ResponseEntity<? super GetMyPageSaveStayListResponseDto> myPageStaySaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveStayListResponseDto> response = travelStayService
                                .userSaveStay(userId);
                return response;
        }

        // 저장한 패션 게시글 목록 조회 메서드 //
        @GetMapping("/save-fashion")
        public ResponseEntity<? super GetMyPageSaveFashionListResponseDto> myPageFashionSaveList(
                        @AuthenticationPrincipal String userId) {
                ResponseEntity<? super GetMyPageSaveFashionListResponseDto> response = fashionService
                                .userSaveFashion(userId);
                return response;
        }

        // 작성한 여행 게시글 목록 조회 메서드 //
        @GetMapping("/write-travel")
        public ResponseEntity<? super GetMyPageBoardTravelListResponseDto> myPageBoardTravelList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageBoardTravelListResponseDto> response = travelService
                                .myPageBoardTravelList(userId);
                return response;
        }

        // 작성한 패션 게시글 목록 조회 메서드 //
        @GetMapping("/write-fashion")
        public ResponseEntity<? super GetMyPageBoardFashionListResponseDto> myPageBoardFashionList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageBoardFashionListResponseDto> response = fashionService
                                .myPageBoardFashionList(userId);
                return response;
        }

        // 작성한 음식점 게시글 목록 조회 메서드 //
        @GetMapping("/write-food")
        public ResponseEntity<? super GetMyPageBoardFoodListResponseDto> myPageBoardFoodList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageBoardFoodListResponseDto> response = travelFoodService
                                .myPageBoardFoodList(userId);
                return response;
        }

        // 작성한 카페 게시글 목록 조회 메서드 //
        @GetMapping("/write-cafe")
        public ResponseEntity<? super GetMyPageBoardCafeListResponseDto> myPageBoardCafeList(
                        @AuthenticationPrincipal String userId
        ) {
                ResponseEntity<? super GetMyPageBoardCafeListResponseDto> response = travelCafeService
                                .myPageBoardCafeList(userId);
                return response;
        }

        // 작성한 숙소 게시글 목록 조회 메서드 //
        @GetMapping("/write-stay")
        public ResponseEntity<? super GetMyPageBoardStayListResponseDto> myPageBoardStayList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageBoardStayListResponseDto> response = travelStayService
                                .myPageBoardStayList(userId);
                return response;
        }

        // 좋아요한 여행 게시글 목록 조회 메서드 //
        @GetMapping("/like-travel")
        public ResponseEntity<? super GetMyPageLikeTravelListResponseDto> myPageLikeTravelList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeTravelListResponseDto> response = travelService
                                .myPageLikeTravelList(userId);
                return response;
        }

        // 좋아요한 패션 게시글 목록 조회 메서드 //
        @GetMapping("/like-fashion")
        public ResponseEntity<? super GetMyPageLikeFashionListResponseDto> myPageLikeFashionList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeFashionListResponseDto> response = fashionService
                                .myPageLikeFashionList(userId);
                return response;
        }

        // 좋아요한 음식점 게시글 목록 조회 메서드 //
        @GetMapping("/like-food")
        public ResponseEntity<? super GetMyPageLikeFoodListResponseDto> myPageLikeFoodList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeFoodListResponseDto> response = travelFoodService
                                .myPageLikeFoodList(userId);
                return response;
        }

        // 좋아요한 숙소 게시글 목록 조회 메서드 //
        @GetMapping("/like-stay")
        public ResponseEntity<? super GetMyPageLikeStayListResponseDto> myPageLikeStayList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeStayListResponseDto> response = travelStayService
                                .myPageLikeStayList(userId);
                return response;
        }

        // 좋아요한 카페 게시글 목록 조회 메서드 //
        @GetMapping("/like-cafe")
        public ResponseEntity<? super GetMyPageLikeCafeListResponseDto> myPageLikeCafeList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageLikeCafeListResponseDto> response = travelCafeService
                                .myPageLikeCafeList(userId);
                return response;
        }

        // 투표한 패션 게시글 목록 조회 메서드 //
        @GetMapping("/vote-fashion")
        public ResponseEntity<? super GetMyPageVoteFashionListResponseDto> myPageVoteFashionList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageVoteFashionListResponseDto> response = fashionVoteService
                                .myPageVoteFashionList(userId);
                return response;
        }

        // 투표한 여행 게시글 목록 조회 메서드 //
        @GetMapping("/vote-travel")
        public ResponseEntity<? super GetMyPageVoteTravelListResponseDto> myPageVoteTravelList(
                        @AuthenticationPrincipal String userId

        ) {
                ResponseEntity<? super GetMyPageVoteTravelListResponseDto> response = travelVoteService
                                .myPageVoteTravelList(userId);
                return response;
        }
}
