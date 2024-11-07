package com.koreait.mzpick_backend.service.implement.food;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.food.TravelFood;
import com.koreait.mzpick_backend.common.object.food.TravelFoodDetail;
import com.koreait.mzpick_backend.common.object.mypage.like.MyPageLikeFood;
import com.koreait.mzpick_backend.common.object.mypage.save.MyPageSaveFood;
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
import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodLikeEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodSaveEntity;
import com.koreait.mzpick_backend.entity.food.resultSet.GetTravelFoodHallOfFamePhotoListResultSet;
import com.koreait.mzpick_backend.repository.food.TravelFoodCommentRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodHashtagRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodLikeRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodPhotoRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodSaveRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.food.TravelFoodService;

import lombok.RequiredArgsConstructor;

//service 여행지 관련 서비스 //
@Service
@RequiredArgsConstructor
public class TravelFoodServiceImplement implements TravelFoodService {

    private final TravelFoodRepository travelFoodRepository;
    private final TravelFoodHashtagRepository travelFoodHashtagRepository;
    private final TravelFoodPhotoRepository travelFoodPhotoRepository;
    private final TravelFoodCommentRepository travelFoodCommentRepository;
    private final TravelFoodLikeRepository travelFoodLikeRepository;
    private final TravelFoodSaveRepository travelFoodSaveRepository;
    private final UserRepository userRepository;

    // Get 여행지 게시글 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetTravelFoodListResponseDto> getTravelFoodList(Integer page, String searchLocation, String hashtag) {
        List<TravelFood> travelFoods = new ArrayList<>();
        try {
            Integer paging = 8 * (page - 1);
            List<TravelFoodEntity> travelFoodEntities = travelFoodRepository.findByPaging(paging, searchLocation, hashtag);
            for (TravelFoodEntity travelFoodEntity : travelFoodEntities) {
                Integer travelFoodNumber = travelFoodEntity.getTravelFoodNumber();
                List<TravelFoodHashtagEntity> travelFoodHashtagEntities = travelFoodHashtagRepository
                        .findByTravelFoodNumber(travelFoodNumber);
                List<TravelFoodPhotoEntity> travelFoodPhotoEntities = travelFoodPhotoRepository
                        .findByTravelFoodNumber(travelFoodNumber);
                List<TravelFoodLikeEntity> travelFoodLikeEntities = travelFoodLikeRepository
                        .findByTravelFoodNumber(travelFoodNumber);
                List<TravelFoodSaveEntity> travelFoodSaveEntities = travelFoodSaveRepository
                        .findByTravelFoodNumber(travelFoodNumber);
                TravelFood travelFood = new TravelFood(travelFoodEntity, travelFoodPhotoEntities,
                        travelFoodHashtagEntities, travelFoodLikeEntities, travelFoodSaveEntities);
                travelFoods.add(travelFood);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTravelFoodListResponseDto.success(travelFoods);
    }

    // Get 해당 여행 게시글 상세보기 //
    @Override
    public ResponseEntity<? super GetTravelFoodDetailResponseDto> getTravelFood(Integer travelFoodNumber) {
        TravelFoodDetail travelFoodDetail = null;
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null)
                return ResponseDto.noExistBoard();

            List<TravelFoodHashtagEntity> travelFoodHashtagEntities = travelFoodHashtagRepository
                    .findByTravelFoodNumber(travelFoodNumber);
            List<TravelFoodPhotoEntity> travelFoodPhotoEntities = travelFoodPhotoRepository
                    .findByTravelFoodNumber(travelFoodNumber);
            List<TravelFoodLikeEntity> travelFoodLikeEntities = travelFoodLikeRepository
                    .findByTravelFoodNumber(travelFoodNumber);
            List<TravelFoodSaveEntity> travelFoodSaveEntities = travelFoodSaveRepository
                    .findByTravelFoodNumber(travelFoodNumber);
            travelFoodDetail = new TravelFoodDetail(travelFoodEntity, travelFoodPhotoEntities,
                    travelFoodHashtagEntities, travelFoodLikeEntities, travelFoodSaveEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelFoodDetailResponseDto.success(travelFoodDetail);
    }

    // Post 여행지 게시글 작성하기 //
    @Override
    public ResponseEntity<ResponseDto> postTravelFood(PostTravelFoodRequestDto dto, String userId) {
        try {
            TravelFoodEntity travelFoodEntity = new TravelFoodEntity(dto, userId);
            travelFoodRepository.save(travelFoodEntity);

            Integer travelFoodNumber = travelFoodEntity.getTravelFoodNumber();

            List<String> travelFoodHashtagContentList = dto.getTravelFoodHashtagContentList();
            List<TravelFoodHashtagEntity> travelFoodHashtagEntities = new ArrayList<>();
            for (String travelFoodHashtagContent : travelFoodHashtagContentList) {
                TravelFoodHashtagEntity travelFoodHashtagEntity = new TravelFoodHashtagEntity(travelFoodNumber,
                        travelFoodHashtagContent);
                travelFoodHashtagEntities.add(travelFoodHashtagEntity);
            }
            travelFoodHashtagRepository.saveAll(travelFoodHashtagEntities);

            List<String> travelFoodPhotoList = dto.getTravelFoodPhotoList();
            List<TravelFoodPhotoEntity> travelFoodPhotoEntities = new ArrayList<>();
            for (String travelFoodPhotoLink : travelFoodPhotoList) {
                TravelFoodPhotoEntity travelFoodPhotoEntity = new TravelFoodPhotoEntity(travelFoodNumber,
                        travelFoodPhotoLink);
                travelFoodPhotoEntities.add(travelFoodPhotoEntity);
            }
            travelFoodPhotoRepository.saveAll(travelFoodPhotoEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    // Delete 해당 여행지 게시판 삭제하기 //
    @Override
    public ResponseEntity<ResponseDto> deleteTravelFood(Integer travelFoodNumber, String userId) {
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null)
                return ResponseDto.noExistBoard();
            String user = travelFoodEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            // travelHashtagRepository.deleteByTravelNumber(travelNumber);
            // travelPhotoRepository.deleteByTravelNumber(travelNumber);
            // travelCommentRepository.deleteByTravelNumber(travelNumber);
            travelFoodRepository.delete(travelFoodEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    // patch 해당 여행지 게시글 수정하기 //
    @Override
    public ResponseEntity<ResponseDto> patchTravelFood(PatchTravelFoodRequestDto dto, Integer travelFoodNumber,
            String userId) {
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null)
                return ResponseDto.noExistBoard();

            String user = travelFoodEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            travelFoodHashtagRepository.deleteByTravelFoodNumber(travelFoodNumber);
            travelFoodPhotoRepository.deleteByTravelFoodNumber(travelFoodNumber);

            travelFoodEntity.patch(dto, userId);

            List<String> travelFoodHashtagContentList = dto.getTravelFoodHashtagContentList();
            List<TravelFoodHashtagEntity> travelFoodHashtagEntities = new ArrayList<>();
            for (String travelFoodHashtagContent : travelFoodHashtagContentList) {
                TravelFoodHashtagEntity travelFoodHashtagEntity = new TravelFoodHashtagEntity(travelFoodNumber,
                        travelFoodHashtagContent);
                travelFoodHashtagEntities.add(travelFoodHashtagEntity);
            }
            travelFoodHashtagRepository.saveAll(travelFoodHashtagEntities);

            List<String> travelFoodPhotoList = dto.getTravelFoodPhotoList();
            List<TravelFoodPhotoEntity> travelFoodPhotoEntities = new ArrayList<>();
            for (String travelFoodPhotoLink : travelFoodPhotoList) {
                TravelFoodPhotoEntity travelFoodPhotoEntity = new TravelFoodPhotoEntity(travelFoodNumber,
                        travelFoodPhotoLink);
                travelFoodPhotoEntities.add(travelFoodPhotoEntity);
            }
            travelFoodPhotoRepository.saveAll(travelFoodPhotoEntities);

            travelFoodRepository.save(travelFoodEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> putLike(Integer travelFoodNumber, String userId) {

        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            boolean isLike = travelFoodLikeRepository.existsByUserIdAndTravelFoodNumber(userId, travelFoodNumber);

            TravelFoodLikeEntity travelFoodLikeEntity = new TravelFoodLikeEntity(travelFoodNumber, userId);

            if (isLike) {
                travelFoodLikeRepository.delete(travelFoodLikeEntity);
                travelFoodEntity.downLikeCount();
            } else {
                travelFoodLikeRepository.save(travelFoodLikeEntity);
                travelFoodEntity.upLikeCount();
            }

            travelFoodRepository.save(travelFoodEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> putSave(Integer travelFoodNumber, String userId) {
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            boolean isSave = travelFoodSaveRepository.existsByUserIdAndTravelFoodNumber(userId, travelFoodNumber);

            TravelFoodSaveEntity travelFoodSaveEntity = new TravelFoodSaveEntity(travelFoodNumber, userId);

            if (isSave) {
                travelFoodSaveRepository.delete(travelFoodSaveEntity);
                travelFoodEntity.downSaveCount();
            } else {
                travelFoodSaveRepository.save(travelFoodSaveEntity);
                travelFoodEntity.upSaveCount();
                ;
            }

            travelFoodRepository.save(travelFoodEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    // put 해당 여행지 게시글 조회수 업 시키기 //
    @Override
    public ResponseEntity<ResponseDto> upTravelFoodViewCount(Integer travelFoodNumber) {
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null)
                return ResponseDto.noExistBoard();

            travelFoodEntity.upViewCount();
            travelFoodRepository.save(travelFoodEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetTravelFoodHallOfFameResponseDto> travelFoodHallOfFame() {
        List<GetTravelFoodHallOfFamePhotoListResultSet> resultSets = new ArrayList<>();
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

            resultSets = travelFoodRepository.getTravelHallOfFamePhotoList(startDate, endDate);
            if (resultSets.isEmpty())
                return ResponseDto.noExistBoard();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelFoodHallOfFameResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetMyPageSaveFoodListResponseDto> userSaveFood(String userId) {
        List<MyPageSaveFood> myPageFoodSaveList = new ArrayList<>();
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            List<TravelFoodSaveEntity> travelFoodSaveEntities = travelFoodSaveRepository.findByUserId(userId);
            for (TravelFoodSaveEntity travelFoodSaveEntity : travelFoodSaveEntities) {
                Integer travelFoodNumber = travelFoodSaveEntity.getTravelFoodNumber();
                TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
                List<TravelFoodPhotoEntity> travelFoodPhotoEntitys = travelFoodPhotoRepository
                        .findByTravelFoodNumber(travelFoodNumber);
                List<TravelFoodHashtagEntity> travelFoodHashtagEntitys = travelFoodHashtagRepository
                        .findByTravelFoodNumber(travelFoodNumber);
                MyPageSaveFood myPageSaveFood = new MyPageSaveFood(travelFoodEntity, travelFoodPhotoEntitys,
                        travelFoodHashtagEntitys);
                myPageFoodSaveList.add(myPageSaveFood);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageSaveFoodListResponseDto.success(myPageFoodSaveList);
    }

    @Override
    public ResponseEntity<? super GetMyPageBoardFoodListResponseDto> myPageBoardFoodList(String userId) {
        List<TravelFoodEntity> travelFoodEntities = new ArrayList<>();
        try {
            boolean user = userRepository.existsByUserId(userId);

            if (!user) return ResponseDto.noExistUserId();
            travelFoodEntities = travelFoodRepository.findByUserId(userId);

            if (travelFoodEntities == null) return ResponseDto.noExistUserId();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageBoardFoodListResponseDto.success(travelFoodEntities);
    }

    @Override
    public ResponseEntity<? super GetMyPageLikeFoodListResponseDto> myPageLikeFoodList(String userId) {
        List<MyPageLikeFood> myPageLikeFoods = new ArrayList<>();
        try {
            List<TravelFoodLikeEntity> travelFoodLikeEntities = travelFoodLikeRepository.findByUserId(userId);
            for (TravelFoodLikeEntity travelFoodLikeEntity : travelFoodLikeEntities) {
                Integer foodNumber = travelFoodLikeEntity.getTravelFoodNumber();
                TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(foodNumber);
                List<TravelFoodPhotoEntity> travelFoodPhotoEntities = travelFoodPhotoRepository
                        .findByTravelFoodNumber(foodNumber);
                List<TravelFoodHashtagEntity> travelFoodHashtagEntities = travelFoodHashtagRepository
                        .findByTravelFoodNumber(foodNumber);
                MyPageLikeFood myPageLikeFood = new MyPageLikeFood(travelFoodEntity, travelFoodPhotoEntities,
                        travelFoodHashtagEntities);
                myPageLikeFoods.add(myPageLikeFood);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageLikeFoodListResponseDto.success(myPageLikeFoods);
    }

    @Override
    public ResponseEntity<? super GetTravelFoodTotalCountResponsDto> travelFoodTotalCount() {
        long count = travelFoodRepository.count();

        return GetTravelFoodTotalCountResponsDto.success(count);
    }

    
}
