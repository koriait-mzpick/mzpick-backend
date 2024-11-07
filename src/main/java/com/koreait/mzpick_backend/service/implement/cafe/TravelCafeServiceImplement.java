package com.koreait.mzpick_backend.service.implement.cafe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.cafe.TravelCafe;
import com.koreait.mzpick_backend.common.object.cafe.TravelCafeDetail;
import com.koreait.mzpick_backend.common.object.mypage.like.MyPageLikeCafe;
import com.koreait.mzpick_backend.common.object.mypage.save.MyPageSaveCafe;
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
import com.koreait.mzpick_backend.entity.cafe.TravelCafeCategoryEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeLikeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafePhotoEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeSaveEntity;
import com.koreait.mzpick_backend.entity.cafe.resultSet.GetTravelCafeHallOfFamePhotoListResultSet;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeCategoryRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeCommentRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeHashtagRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeLikeRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafePhotoRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeSaveRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.cafe.TravelCafeService;

import lombok.RequiredArgsConstructor;

//service 여행지 관련 서비스 //
@Service
@RequiredArgsConstructor
public class TravelCafeServiceImplement implements TravelCafeService {

    private final TravelCafeRepository travelCafeRepository;
    private final TravelCafeHashtagRepository travelCafeHashtagRepository;
    private final TravelCafePhotoRepository travelCafePhotoRepository;
    private final TravelCafeCommentRepository travelCafeCommentRepository;
    private final TravelCafeLikeRepository travelCafeLikeRepository;
    private final TravelCafeSaveRepository travelCafeSaveRepository;
    private final TravelCafeCategoryRepository travelCafeCategoryRepository;
    private final UserRepository userRepository;

    // Get 여행지 게시글 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetTravelCafeListResponseDto> getTravelCafeList(Integer page, String searchLocation, String hashtag) {
        List<TravelCafe> travelCafes = new ArrayList<>();
        try {
            Integer paging = 8 * (page - 1);
            List<TravelCafeEntity> travelCafeEntities = travelCafeRepository.findByPaging(paging, searchLocation, hashtag);
            for (TravelCafeEntity travelCafeEntity : travelCafeEntities) {
                Integer travelCafeNumber = travelCafeEntity.getTravelCafeNumber();
                List<TravelCafeHashtagEntity> travelCafeHashtagEntities = travelCafeHashtagRepository
                        .findByTravelCafeNumber(travelCafeNumber);
                List<TravelCafePhotoEntity> travelCafePhotoEntities = travelCafePhotoRepository
                        .findByTravelCafeNumber(travelCafeNumber);
                List<TravelCafeCategoryEntity> travelCafeCategoryEntities = travelCafeCategoryRepository
                        .findByTravelCafeNumber(travelCafeNumber);
                List<TravelCafeLikeEntity> travelCafeLikeEntities = travelCafeLikeRepository
                        .findByTravelCafeNumber(travelCafeNumber);
                List<TravelCafeSaveEntity> travelCafeSaveEntities = travelCafeSaveRepository
                        .findByTravelCafeNumber(travelCafeNumber);
                TravelCafe travelCafe = new TravelCafe(travelCafeEntity, travelCafePhotoEntities,
                        travelCafeHashtagEntities, travelCafeCategoryEntities, travelCafeLikeEntities,
                        travelCafeSaveEntities);
                travelCafes.add(travelCafe);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTravelCafeListResponseDto.success(travelCafes);
    }

    // Get 해당 여행 게시글 상세보기 //
    @Override
    public ResponseEntity<? super GetTravelCafeDetailResponseDto> getTravelCafe(Integer travelCafeNumber) {
        TravelCafeDetail travelCafeDetail = null;
        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null)
                return ResponseDto.noExistBoard();

            List<TravelCafeHashtagEntity> travelCafeHashtagEntities = travelCafeHashtagRepository
                    .findByTravelCafeNumber(travelCafeNumber);
            List<TravelCafePhotoEntity> travelCafePhotoEntities = travelCafePhotoRepository
                    .findByTravelCafeNumber(travelCafeNumber);
            List<TravelCafeLikeEntity> travelCafeLikeEntities = travelCafeLikeRepository
                    .findByTravelCafeNumber(travelCafeNumber);
            List<TravelCafeSaveEntity> travelCafeSaveEntities = travelCafeSaveRepository
                    .findByTravelCafeNumber(travelCafeNumber);
            List<TravelCafeCategoryEntity> travelCafeCategoryEntities = travelCafeCategoryRepository
                    .findByTravelCafeNumber(travelCafeNumber);
            travelCafeDetail = new TravelCafeDetail(travelCafeEntity, travelCafePhotoEntities,
                    travelCafeHashtagEntities, travelCafeLikeEntities, travelCafeSaveEntities,
                    travelCafeCategoryEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelCafeDetailResponseDto.success(travelCafeDetail);
    }

    // Post 여행지 게시글 작성하기 //
    @Override
    public ResponseEntity<ResponseDto> postTravelCafe(PostTravelCafeRequestDto dto, String userId) {
        try {
            TravelCafeEntity travelCafeEntity = new TravelCafeEntity(dto, userId);
            travelCafeRepository.save(travelCafeEntity);

            Integer travelCafeNumber = travelCafeEntity.getTravelCafeNumber();

            List<String> travelCafeHashtagContentList = dto.getTravelCafeHashtagContentList();
            List<TravelCafeHashtagEntity> travelCafeHashtagEntities = new ArrayList<>();
            for (String travelCafeHashtagContent : travelCafeHashtagContentList) {
                TravelCafeHashtagEntity travelCafeHashtagEntity = new TravelCafeHashtagEntity(travelCafeNumber,
                        travelCafeHashtagContent);
                travelCafeHashtagEntities.add(travelCafeHashtagEntity);
            }
            travelCafeHashtagRepository.saveAll(travelCafeHashtagEntities);

            List<String> travelCafePhotoList = dto.getTravelCafePhotoList();
            List<TravelCafePhotoEntity> travelCafePhotoEntities = new ArrayList<>();
            for (String travelCafePhotoLink : travelCafePhotoList) {
                TravelCafePhotoEntity travelCafePhotoEntity = new TravelCafePhotoEntity(travelCafeNumber,
                        travelCafePhotoLink);
                travelCafePhotoEntities.add(travelCafePhotoEntity);
            }
            travelCafePhotoRepository.saveAll(travelCafePhotoEntities);

            List<String> travelCafeCategoryList = dto.getTravelCafeCategoryList();
            List<TravelCafeCategoryEntity> travelCafeCategoryEntities = new ArrayList<>();
            for (String travelCafeCategory : travelCafeCategoryList) {
                TravelCafeCategoryEntity travelCafeCategoryEntity = new TravelCafeCategoryEntity(travelCafeNumber,
                        travelCafeCategory);
                travelCafeCategoryEntities.add(travelCafeCategoryEntity);
            }
            travelCafeCategoryRepository.saveAll(travelCafeCategoryEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    // Delete 해당 여행지 게시판 삭제하기 //
    @Override
    public ResponseEntity<ResponseDto> deleteTravelCafe(Integer travelCafeNumber, String userId) {
        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null)
                return ResponseDto.noExistBoard();
            String user = travelCafeEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            // travelHashtagRepository.deleteByTravelNumber(travelNumber);
            // travelPhotoRepository.deleteByTravelNumber(travelNumber);
            // travelCommentRepository.deleteByTravelNumber(travelNumber);
            travelCafeRepository.delete(travelCafeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    // patch 해당 여행지 게시글 수정하기 //
    @Override
    public ResponseEntity<ResponseDto> patchTravelCafe(PatchTravelCafeRequestDto dto, Integer travelCafeNumber,
            String userId) {
        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null)
                return ResponseDto.noExistBoard();

            String user = travelCafeEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            travelCafeHashtagRepository.deleteByTravelCafeNumber(travelCafeNumber);
            travelCafePhotoRepository.deleteByTravelCafeNumber(travelCafeNumber);
            travelCafeCategoryRepository.deleteByTravelCafeNumber(travelCafeNumber);
            travelCafeEntity.patch(dto, userId);

            List<String> travelCafeHashtagContentList = dto.getTravelCafeHashtagContentList();
            List<TravelCafeHashtagEntity> travelCafeHashtagEntities = new ArrayList<>();
            for (String travelCafeHashtagContent : travelCafeHashtagContentList) {
                TravelCafeHashtagEntity travelCafeHashtagEntity = new TravelCafeHashtagEntity(travelCafeNumber,
                        travelCafeHashtagContent);
                travelCafeHashtagEntities.add(travelCafeHashtagEntity);
            }
            travelCafeHashtagRepository.saveAll(travelCafeHashtagEntities);

            List<String> travelCafePhotoList = dto.getTravelCafePhotoList();
            List<TravelCafePhotoEntity> travelCafePhotoEntities = new ArrayList<>();
            for (String travelCafePhotoLink : travelCafePhotoList) {
                TravelCafePhotoEntity travelCafePhotoEntity = new TravelCafePhotoEntity(travelCafeNumber,
                        travelCafePhotoLink);
                travelCafePhotoEntities.add(travelCafePhotoEntity);
            }
            travelCafePhotoRepository.saveAll(travelCafePhotoEntities);

            List<String> travelCafeCategoryList = dto.getTravelCafeCategoryList();
            List<TravelCafeCategoryEntity> travelCafeCategoryEntities = new ArrayList<>();
            for (String travelCafeCategory : travelCafeCategoryList) {
                TravelCafeCategoryEntity travelCafeCategoryEntity = new TravelCafeCategoryEntity(travelCafeNumber,
                        travelCafeCategory);
                travelCafeCategoryEntities.add(travelCafeCategoryEntity);
            }
            travelCafeCategoryRepository.saveAll(travelCafeCategoryEntities);

            travelCafeRepository.save(travelCafeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> putLike(Integer travelCafeNumber, String userId) {

        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            boolean isLike = travelCafeLikeRepository.existsByUserIdAndTravelCafeNumber(userId, travelCafeNumber);

            TravelCafeLikeEntity travelCafeLikeEntity = new TravelCafeLikeEntity(travelCafeNumber, userId);

            if (isLike) {
                travelCafeLikeRepository.delete(travelCafeLikeEntity);
                travelCafeEntity.downLikeCount();
            } else {
                travelCafeLikeRepository.save(travelCafeLikeEntity);
                travelCafeEntity.upLikeCount();
            }

            travelCafeRepository.save(travelCafeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    // put 해당 여행지 게시글 조회수 업 시키기 //
    @Override
    public ResponseEntity<ResponseDto> upTravelCafeViewCount(Integer travelCafeNumber) {
        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null)
                return ResponseDto.noExistBoard();

            travelCafeEntity.upViewCount();
            travelCafeRepository.save(travelCafeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> putSave(Integer travelCafeNumber, String userId) {
        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            boolean isSave = travelCafeSaveRepository.existsByUserIdAndTravelCafeNumber(userId, travelCafeNumber);

            TravelCafeSaveEntity travelCafeSaveEntity = new TravelCafeSaveEntity(travelCafeNumber, userId);

            if (isSave) {
                travelCafeSaveRepository.delete(travelCafeSaveEntity);
                travelCafeEntity.downSaveCount();
            } else {
                travelCafeSaveRepository.save(travelCafeSaveEntity);
                travelCafeEntity.upSaveCount();
            }

            travelCafeRepository.save(travelCafeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetTravelCafeHallOfFameResponseDto> travelCafeHallOfFame() {
        List<GetTravelCafeHallOfFamePhotoListResultSet> resultSets = new ArrayList<>();
        try {

            String pattern = "yyyy-MM-dd";

            // 현재 날짜
            Date now = Calendar.getInstance().getTime();
            SimpleDateFormat nowDateFormat = new SimpleDateFormat(pattern);
            String nowDate = nowDateFormat.format(now);

            // Date nowLocalDate = new SimpleDateFormat(pattern).parse(nowDate);

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern);
            Calendar calendar = Calendar.getInstance();

            // 지난주 날짜 구하기
            calendar.setTime(now);
            calendar.add(Calendar.DATE, -7);

            Date lastWeek = calendar.getTime();
            String lastWeekDate = nowDateFormat.format(lastWeek);

            // 만료 주차 구하기 코드
            calendar.setTime(lastWeek);

            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            String startDate = simpleDateFormat1.format(calendar.getTime());

            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            String endDate = simpleDateFormat2.format(calendar.getTime());

            resultSets = travelCafeRepository.getTravelHallOfFamePhotoList(startDate, endDate);
            if (resultSets.isEmpty())
                return ResponseDto.noExistBoard();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelCafeHallOfFameResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetMyPageSaveCafeListResponseDto> userSaveCafe(String userId) {
        List<MyPageSaveCafe> myPageCafeSaveList = new ArrayList<>();
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            List<TravelCafeSaveEntity> travelCafeSaveEntities = travelCafeSaveRepository.findByUserId(userId);
            for (TravelCafeSaveEntity travelCafeSaveEntity : travelCafeSaveEntities) {
                Integer travelCafeNumber = travelCafeSaveEntity.getTravelCafeNumber();
                TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
                List<TravelCafePhotoEntity> travelCafePhotoEntitys = travelCafePhotoRepository
                        .findByTravelCafeNumber(travelCafeNumber);
                List<TravelCafeHashtagEntity> travelCafeHashtagEntitys = travelCafeHashtagRepository
                        .findByTravelCafeNumber(travelCafeNumber);
                MyPageSaveCafe myPageSaveCafe = new MyPageSaveCafe(travelCafeEntity, travelCafePhotoEntitys,
                        travelCafeHashtagEntitys);
                myPageCafeSaveList.add(myPageSaveCafe);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageSaveCafeListResponseDto.success(myPageCafeSaveList);
    }

    @Override
    public ResponseEntity<? super GetMyPageLikeCafeListResponseDto> myPageLikeCafeList(String userId) {
        List<MyPageLikeCafe> myPageLikeCafes = new ArrayList<>();
        try {
            List<TravelCafeLikeEntity> travelCafeLikeEntities = travelCafeLikeRepository.findByUserId(userId);
            for (TravelCafeLikeEntity travelCafeLikeEntity : travelCafeLikeEntities) {
                Integer cafeNumber = travelCafeLikeEntity.getTravelCafeNumber();
                TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(cafeNumber);
                List<TravelCafePhotoEntity> travelCafePhotoEntities = travelCafePhotoRepository
                        .findByTravelCafeNumber(cafeNumber);
                List<TravelCafeHashtagEntity> travelCafeHashtagEntities = travelCafeHashtagRepository
                        .findByTravelCafeNumber(cafeNumber);
                MyPageLikeCafe myPageLikeCafe = new MyPageLikeCafe(travelCafeEntity, travelCafePhotoEntities,
                        travelCafeHashtagEntities);
                myPageLikeCafes.add(myPageLikeCafe);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageLikeCafeListResponseDto.success(myPageLikeCafes);
    }

    @Override
    public ResponseEntity<? super GetMyPageBoardCafeListResponseDto> myPageBoardCafeList(String userId) {
        List<TravelCafeEntity> travelCafeEntities = new ArrayList<>();
        try {
            boolean user = userRepository.existsByUserId(userId);
            if (!user)
                return ResponseDto.noExistUserId();
            travelCafeEntities = travelCafeRepository.findByUserId(userId);

            if (travelCafeEntities == null)
                return ResponseDto.noExistUserId();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageBoardCafeListResponseDto.success(travelCafeEntities);
    }

    @Override
    public ResponseEntity<? super GetTravelCafeTotalCountResponsDto> getTravelCafeTotalCount() {
        long count = travelCafeRepository.count();

        return GetTravelCafeTotalCountResponsDto.success(count);
    }
}
