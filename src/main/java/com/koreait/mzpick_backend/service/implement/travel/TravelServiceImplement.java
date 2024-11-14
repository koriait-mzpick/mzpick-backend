package com.koreait.mzpick_backend.service.implement.travel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.mypage.like.MyPageLikeTravel;
import com.koreait.mzpick_backend.common.object.mypage.save.MyPageSaveTravel;
import com.koreait.mzpick_backend.common.object.travel.Travel;
import com.koreait.mzpick_backend.common.object.travel.TravelDetail;
import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetTravelHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelLikeResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelSaveResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelTotalCountResponsDto;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;
import com.koreait.mzpick_backend.entity.travel.TravelSaveEntity;
import com.koreait.mzpick_backend.entity.travel.resultSet.GetTravelHallOfFamePhotoListResultSet;
import com.koreait.mzpick_backend.repository.travel.TravelCommentRepository;
import com.koreait.mzpick_backend.repository.travel.TravelHashtagRepository;
import com.koreait.mzpick_backend.repository.travel.TravelLikeRepository;
import com.koreait.mzpick_backend.repository.travel.TravelPhotoRepository;
import com.koreait.mzpick_backend.repository.travel.TravelRepository;
import com.koreait.mzpick_backend.repository.travel.TravelSaveRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.travel.TravelService;

import lombok.RequiredArgsConstructor;

//service 여행지 관련 서비스 //
@Service
@RequiredArgsConstructor
public class TravelServiceImplement implements TravelService {

    private final TravelRepository travelRepository;
    private final TravelHashtagRepository travelHashtagRepository;
    private final TravelPhotoRepository travelPhotoRepository;
    private final TravelLikeRepository travelLikeRepository;
    private final TravelSaveRepository travelSaveRepository;
    private final TravelCommentRepository travelCommentRepository;
    private final UserRepository userRepository;

    //Get 여행지 게시글 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetTravelListResponseDto> getTravelList(Integer page, String searchLocation, String hashtag) {
        List<Travel> travels = new ArrayList<>();
        try {
            Integer paging = 8 * (page - 1);
            List<TravelEntity> travelEntities = travelRepository.findByPaging(paging, searchLocation,hashtag);
            for (TravelEntity travelEntity : travelEntities) {
                Integer travelNumber = travelEntity.getTravelNumber();
                List<TravelHashtagEntity> travelHashtagEntities = travelHashtagRepository.findByTravelNumber(travelNumber);
                List<TravelPhotoEntity> travelPhotoEntities = travelPhotoRepository.findByTravelNumber(travelNumber);
                List<TravelLikeEntity> travelLikeEntities = travelLikeRepository.findByTravelNumber(travelNumber);
                List<TravelSaveEntity> travelSaveEntities = travelSaveRepository.findByTravelNumber(travelNumber);
                Travel travel = new Travel(travelEntity, travelPhotoEntities, travelHashtagEntities, travelLikeEntities, travelSaveEntities);
                travels.add(travel);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTravelListResponseDto.success(travels);
    }

    //Get 해당 여행 게시글 상세보기 //
    @Override
    public ResponseEntity<? super GetTravelDetailResponseDto> getTravel(Integer travelNumber) {
        TravelDetail travelDetail = null;
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            List<TravelHashtagEntity> travelHashtagEntities = travelHashtagRepository.findByTravelNumber(travelNumber);
            List<TravelPhotoEntity> travelPhotoEntities = travelPhotoRepository.findByTravelNumber(travelNumber);
            List<TravelLikeEntity> travelLikeEntities = travelLikeRepository.findByTravelNumber(travelNumber);
            List<TravelSaveEntity> travelSaveEntities = travelSaveRepository.findByTravelNumber(travelNumber);
            travelDetail = new TravelDetail(travelEntity, travelPhotoEntities, travelHashtagEntities, travelLikeEntities, travelSaveEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelDetailResponseDto.success(travelDetail);
    }

    //Post 여행지 게시글 작성하기 //
    @Override
    public ResponseEntity<ResponseDto> postTravel(PostTravelRequestDto dto, String userId) {
        try {
            TravelEntity travelEntity = new TravelEntity(dto, userId);
            travelRepository.save(travelEntity);

            Integer travelNumber = travelEntity.getTravelNumber();

            List<String> travelHashtagContentList = dto.getTravelHashtagContentList();
            List<TravelHashtagEntity> travelHashtagEntities = new ArrayList<>();
            for (String travelHashtagContent : travelHashtagContentList) {
                TravelHashtagEntity travelHashtagEntity = new TravelHashtagEntity(travelNumber, travelHashtagContent);
                travelHashtagEntities.add(travelHashtagEntity);
            }
            travelHashtagRepository.saveAll(travelHashtagEntities);

            List<String> travelPhotoList = dto.getTravelPhotoList();
            List<TravelPhotoEntity> travelPhotoEntities = new ArrayList<>();
            for (String travelPhotoLink : travelPhotoList) {
                TravelPhotoEntity travelPhotoEntity = new TravelPhotoEntity(travelNumber, travelPhotoLink);
                travelPhotoEntities.add(travelPhotoEntity);
            }
            travelPhotoRepository.saveAll(travelPhotoEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    //Delete 해당 여행지 게시판 삭제하기 //
    @Override
    public ResponseEntity<ResponseDto> deleteTravel(Integer travelNumber, String userId) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();
            String user = travelEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            travelHashtagRepository.deleteByTravelNumber(travelNumber);
            travelPhotoRepository.deleteByTravelNumber(travelNumber);
            travelCommentRepository.deleteByTravelNumber(travelNumber);
            travelLikeRepository.deleteByTravelNumber(travelNumber);
            travelSaveRepository.deleteByTravelNumber(travelNumber);
            travelRepository.delete(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    //patch 해당 여행지 게시글 수정하기 //
    @Override
    public ResponseEntity<ResponseDto> patchTravel(PatchTravelRequestDto dto, Integer travelNumber, String userId) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            String user = travelEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            travelHashtagRepository.deleteByTravelNumber(travelNumber);
            travelPhotoRepository.deleteByTravelNumber(travelNumber);

            travelEntity.patch(dto, userId);

            List<String> travelHashtagContentList = dto.getTravelHashtagContentList();
            List<TravelHashtagEntity> travelHashtagEntities = new ArrayList<>();
            for (String travelHashtagContent : travelHashtagContentList) {
                TravelHashtagEntity travelHashtagEntity = new TravelHashtagEntity(travelNumber, travelHashtagContent);
                travelHashtagEntities.add(travelHashtagEntity);
            }
            travelHashtagRepository.saveAll(travelHashtagEntities);

            List<String> travelPhotoList = dto.getTravelPhotoList();
            List<TravelPhotoEntity> travelPhotoEntities = new ArrayList<>();
            for (String travelPhotoLink : travelPhotoList) {
                TravelPhotoEntity travelPhotoEntity = new TravelPhotoEntity(travelNumber, travelPhotoLink);
                travelPhotoEntities.add(travelPhotoEntity);
            }
            travelPhotoRepository.saveAll(travelPhotoEntities);

            travelRepository.save(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> putLike(Integer travelNumber, String userId) {

        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isLike = travelLikeRepository.existsByUserIdAndTravelNumber(userId, travelNumber);

            TravelLikeEntity travelLikeEntity = new TravelLikeEntity(travelNumber, userId);

            if (isLike) {
                travelLikeRepository.delete(travelLikeEntity);
                travelEntity.downLikeCount();
            } else {
                travelLikeRepository.save(travelLikeEntity);
                travelEntity.upLikeCount();
            }

            travelRepository.save(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isSave = travelSaveRepository.existsByUserIdAndTravelNumber(userId, travelNumber);

            TravelSaveEntity travelSaveEntity = new TravelSaveEntity(travelNumber, userId);

            if (isSave) {
                travelSaveRepository.delete(travelSaveEntity);
                travelEntity.downSaveCount();
            } else {
                travelSaveRepository.save(travelSaveEntity);
                travelEntity.upSaveCount();
            }
            travelRepository.save(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    //put 해당 여행지 게시글 조회수 업 시키기 //
    @Override
    public ResponseEntity<ResponseDto> upTravelViewCount(Integer travelNumber) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            travelEntity.upViewCount();
            travelRepository.save(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetTravelHallOfFameResponseDto> travelHallOfFame() {
        List<GetTravelHallOfFamePhotoListResultSet> resultSets = new ArrayList<>();
        try {

            String pattern = "yyyy-MM-dd";

            //현재 날짜
            Date now = Calendar.getInstance().getTime();
            SimpleDateFormat nowDateFormat = new SimpleDateFormat(pattern);


            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern);
            Calendar calendar = Calendar.getInstance();

            //지난주 날짜 구하기
            calendar.setTime(now);
            calendar.add(Calendar.DATE, -7);

            Date lastWeek = calendar.getTime();

            // 만료 주차 구하기 코드
            calendar.setTime(lastWeek);

            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            String startDate = simpleDateFormat1.format(calendar.getTime());

            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            String endDate = simpleDateFormat2.format(calendar.getTime());

            resultSets = travelRepository.getTravelHallOfFamePhotoList(startDate, endDate);

            if (resultSets.isEmpty()) return ResponseDto.noExistBoard();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelHallOfFameResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetMyPageSaveTravelListResponseDto> userSaveTravel(String userId) {
        List<MyPageSaveTravel> myPageTravelSaveList = new ArrayList<>();
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            List<TravelSaveEntity> travelSaveEntities = travelSaveRepository.findByUserId(userId);
            for (TravelSaveEntity travelSaveEntity : travelSaveEntities) {
                Integer travelNumber = travelSaveEntity.getTravelNumber();
                TravelEntity travelEntitys = travelRepository.findByTravelNumber(travelNumber);
                List<TravelPhotoEntity> travelPhotoEntitys = travelPhotoRepository.findByTravelNumber(travelNumber);
                List<TravelHashtagEntity> traveHashtagEntities = travelHashtagRepository.findByTravelNumber(travelNumber);
                MyPageSaveTravel myPageSaveTravel = new MyPageSaveTravel(travelEntitys, travelPhotoEntitys, traveHashtagEntities);
                myPageTravelSaveList.add(myPageSaveTravel);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageSaveTravelListResponseDto.success(myPageTravelSaveList);
    }

    @Override
    public ResponseEntity<? super GetMyPageBoardTravelListResponseDto> myPageBoardTravelList(String userId) {
        List<TravelEntity> travelEntities  = new ArrayList<>();
        try {
            boolean user = userRepository.existsByUserId(userId);
            if(!user) return ResponseDto.noExistUserId();

            travelEntities = travelRepository.findByUserId(userId);

        if (travelEntities == null) return ResponseDto.noExistUserId();



    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }
    return GetMyPageBoardTravelListResponseDto.success(travelEntities);
    }

    public ResponseEntity<? super GetMyPageLikeTravelListResponseDto> myPageLikeTravelList(String userId) {
        List<MyPageLikeTravel> myPageTravelLikeList = new ArrayList<>();
        try {
            List<TravelLikeEntity> travelLikeEntities = travelLikeRepository.findByUserId(userId);
            for(TravelLikeEntity travelLikeEntity : travelLikeEntities){
                Integer travelNumber = travelLikeEntity.getTravelNumber();
                TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
                List<TravelPhotoEntity> travelPhotoEntities = travelPhotoRepository.findByTravelNumber(travelNumber);
                List<TravelHashtagEntity> traveHashtagEntities = travelHashtagRepository.findByTravelNumber(travelNumber);
                MyPageLikeTravel myPageLikeTravel = new MyPageLikeTravel(travelEntity, travelPhotoEntities, traveHashtagEntities);
                myPageTravelLikeList.add(myPageLikeTravel);
            }

            
    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }
    return GetMyPageLikeTravelListResponseDto.success(myPageTravelLikeList);
    }

    @Override
    public ResponseEntity<? super GetTravelTotalCountResponsDto> travelTotalCount() {
        long count = travelRepository.count();
        return GetTravelTotalCountResponsDto.success(count);
    }

    @Override
    public ResponseEntity<? super GetTravelLikeResponseDto> getTravelLike(Integer travelNumber) {
        List<String> userIdList = new ArrayList<>();
        try {
            TravelEntity isBoard = travelRepository.findByTravelNumber(travelNumber);
            if(isBoard == null) return ResponseDto.noExistBoard();
            List<TravelLikeEntity> travelLikeEntities = travelLikeRepository.findByTravelNumber(travelNumber);
            for(TravelLikeEntity travelLikeEntity : travelLikeEntities){
                userIdList.add(travelLikeEntity.getUserId());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelLikeResponseDto.success(travelNumber, userIdList);
    }

    @Override
    public ResponseEntity<? super GetTravelSaveResponseDto> getTravelSave(Integer travelNumber) {
        List<String> userIdList = new ArrayList<>();
        try {
            TravelEntity isBoard = travelRepository.findByTravelNumber(travelNumber);
            if(isBoard == null) return ResponseDto.noExistBoard();
            List<TravelSaveEntity> travelSaveEntities = travelSaveRepository.findByTravelNumber(travelNumber);
            for(TravelSaveEntity travelSaveEntity : travelSaveEntities){
                userIdList.add(travelSaveEntity.getUserId());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelSaveResponseDto.success(travelNumber, userIdList);
    }
}
