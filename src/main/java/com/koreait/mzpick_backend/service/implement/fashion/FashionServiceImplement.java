package com.koreait.mzpick_backend.service.implement.fashion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.fashion.Fashion;
import com.koreait.mzpick_backend.common.object.fashion.FashionDetail;
import com.koreait.mzpick_backend.common.object.mypage.save.MyPageSaveFashion;
import com.koreait.mzpick_backend.common.object.mypage.board.MyPageBoardTravel;
import com.koreait.mzpick_backend.common.object.mypage.like.MyPageLikeFashion;
import com.koreait.mzpick_backend.dto.request.fashion.PatchFashionRequestDto;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.hallOfFame.GetFashionHallOfFameResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardFoodListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardStayListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.board.GetMyPageBoardTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.like.GetMyPageLikeFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.save.GetMyPageSaveFashionListResponseDto;
import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionLikeEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionSaveEntity;
import com.koreait.mzpick_backend.entity.fashion.resultSet.GetFashionHallOfFamePhotoListResultSet;
import com.koreait.mzpick_backend.repository.fashion.FashionCommentRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionHashtagRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionLikeRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionPhotoRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionSaveRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.fashion.FashionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FashionServiceImplement implements FashionService {

    private final FashionRepository fashionRepository;
    private final FashionHashtagRepository fashionHashtagRepository;
    private final FashionPhotoRepository fashionPhotoRepository;
    private final FashionLikeRepository fashionLikeRepository;
    private final FashionSaveRepository fashionSaveRepository;
    private final FashionCommentRepository fashionCommentRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetFashionListResponseDto> getFashionList(Integer page) {
        List<Fashion> Fashions = new ArrayList<>();

        try {
            Integer paging = 5 * (page - 1);
            List<FashionEntity> fashionEntities = fashionRepository.findByPaging(paging);
            for (FashionEntity fashionEntity : fashionEntities) {
                Integer fashionNumber = fashionEntity.getFashionNumber();
                List<FashionHashtagEntity> fashionHashtagEntities = fashionHashtagRepository
                        .findByFashionNumber(fashionNumber);
                List<FashionPhotoEntity> fashionPhotoEntities = fashionPhotoRepository
                        .findByFashionNumber(fashionNumber);
                List<FashionLikeEntity> fashionLikeEntities = fashionLikeRepository.findByFashionNumber(fashionNumber);
                List<FashionSaveEntity> fashionSaveEntities = fashionSaveRepository.findByFashionNumber(fashionNumber);
                Fashion fashion = new Fashion(fashionEntity, fashionPhotoEntities, fashionHashtagEntities,
                        fashionLikeEntities, fashionSaveEntities);
                Fashions.add(fashion);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionListResponseDto.success(Fashions);
    }

    @Override
    public ResponseEntity<? super GetFashionDetailResponseDto> getFashion(Integer fashionNumber) {
        FashionDetail fashionDetail = null;
        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if (fashionEntity == null)
                return ResponseDto.noExistBoard();

            List<FashionHashtagEntity> fashionHashtagEntities = fashionHashtagRepository
                    .findByFashionNumber(fashionNumber);
            List<FashionPhotoEntity> fashionPhotoEntities = fashionPhotoRepository.findByFashionNumber(fashionNumber);
            List<FashionLikeEntity> fashionLikeEntities = fashionLikeRepository.findByFashionNumber(fashionNumber);
            List<FashionSaveEntity> fashionSaveEntities = fashionSaveRepository.findByFashionNumber(fashionNumber);
            fashionDetail = new FashionDetail(fashionEntity, fashionPhotoEntities, fashionHashtagEntities,
                    fashionLikeEntities, fashionSaveEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionDetailResponseDto.success(fashionDetail);
    }

    @Override
    public ResponseEntity<ResponseDto> postFashion(PostFashionRequestDto dto, String userId) {
        try {
            FashionEntity fashionEntity = new FashionEntity(dto, userId);
            fashionRepository.save(fashionEntity);

            Integer fashionNumber = fashionEntity.getFashionNumber();

            List<String> fashionHashtagContentList = dto.getFashionHashtagContent();
            List<FashionHashtagEntity> fashionHashtagEntities = new ArrayList<>();
            for (String fashionHashtagContent : fashionHashtagContentList) {
                FashionHashtagEntity fashionHashtagEntity = new FashionHashtagEntity(fashionNumber,
                        fashionHashtagContent);
                fashionHashtagEntities.add(fashionHashtagEntity);
            }
            fashionHashtagRepository.saveAll(fashionHashtagEntities);

            List<String> fashionPhotoList = dto.getFashionPhoto();
            List<FashionPhotoEntity> fashionPhotoEntities = new ArrayList<>();
            for (String fashionPhotoLink : fashionPhotoList) {
                FashionPhotoEntity fashionPhotoEntity = new FashionPhotoEntity(fashionNumber, fashionPhotoLink);
                fashionPhotoEntities.add(fashionPhotoEntity);
            }
            fashionPhotoRepository.saveAll(fashionPhotoEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteFashion(Integer fashionNumber, String userId) {
        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if (fashionEntity == null)
                return ResponseDto.noExistBoard();
            String user = fashionEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            fashionHashtagRepository.deleteByFashionNumber(fashionNumber);
            fashionPhotoRepository.deleteByFashionNumber(fashionNumber);
            fashionCommentRepository.deleteByFashionNumber(fashionNumber);
            fashionRepository.delete(fashionEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchFashion(PatchFashionRequestDto dto, Integer fashionNumber, String userId) {
        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if (fashionEntity == null)
                return ResponseDto.noExistBoard();
            String user = fashionEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            fashionHashtagRepository.deleteByFashionNumber(fashionNumber);
            fashionPhotoRepository.deleteByFashionNumber(fashionNumber);

            fashionEntity.patch(dto, userId);

            List<String> fashionHashtagContentList = dto.getFashionHashtagContent();
            List<FashionHashtagEntity> fashionHashtagEntities = new ArrayList<>();
            for (String fashionHashtagContent : fashionHashtagContentList) {
                FashionHashtagEntity fashionHashtagEntity = new FashionHashtagEntity(fashionNumber,
                        fashionHashtagContent);
                fashionHashtagEntities.add(fashionHashtagEntity);
            }
            fashionHashtagRepository.saveAll(fashionHashtagEntities);

            List<String> fashionPhotoList = dto.getFashionPhoto();
            List<FashionPhotoEntity> fashionPhotoEntities = new ArrayList<>();
            for (String fashionPhotoLink : fashionPhotoList) {
                FashionPhotoEntity fashionPhotoEntity = new FashionPhotoEntity(fashionNumber, fashionPhotoLink);
                fashionPhotoEntities.add(fashionPhotoEntity);
            }
            fashionPhotoRepository.saveAll(fashionPhotoEntities);

            fashionRepository.save(fashionEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> putLike(Integer fashionNumber, String userId) {
        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if (fashionEntity == null)
                return ResponseDto.noExistBoard();
            boolean existsByUserId = userRepository.existsByUserId(userId);
            if (!existsByUserId)
                return ResponseDto.noExistUserId();

            boolean isLike = fashionLikeRepository.existsByUserIdAndFashionNumber(userId, fashionNumber);
            FashionLikeEntity fashionLikeEntity = new FashionLikeEntity(fashionNumber, userId);

            if (isLike) {
                fashionLikeRepository.delete(fashionLikeEntity);
                fashionEntity.downLikeCount();
            } else {
                fashionLikeRepository.save(fashionLikeEntity);
                fashionEntity.upLikeCount();
            }
            fashionRepository.save(fashionEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> putSave(Integer fashionNumber, String userId) {

        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if (fashionEntity == null)
                return ResponseDto.noExistBoard();
            boolean existsByUserId = userRepository.existsByUserId(userId);
            if (!existsByUserId)
                return ResponseDto.noExistUserId();

            boolean isSave = fashionSaveRepository.existsByUserIdAndFashionNumber(userId, fashionNumber);

            FashionSaveEntity fashionSaveEntity = new FashionSaveEntity(fashionNumber, userId);

            if (isSave) {
                fashionSaveRepository.delete(fashionSaveEntity);
                fashionEntity.downSaveCount();
            } else {
                fashionSaveRepository.save(fashionSaveEntity);
                fashionEntity.upSaveCount();
            }
            fashionRepository.save(fashionEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> upFashionViewCount(Integer FashionNumber) {
        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(FashionNumber);
            if (fashionEntity == null)
                return ResponseDto.noExistBoard();
            fashionEntity.upViewCount();
            fashionRepository.save(fashionEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetFashionHallOfFameResponseDto> FashionHallOfFame() {
        List<GetFashionHallOfFamePhotoListResultSet> resultSets = new ArrayList<>();
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

            resultSets = fashionRepository.getFashionHallOfFamePhotoList(startDate, endDate);
            if (resultSets.isEmpty())
                return ResponseDto.noExistBoard();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionHallOfFameResponseDto.success(resultSets);
    }


    // 마이페이지 게시글 리스트 가져오기
    @Override
    public ResponseEntity<? super GetMyPageSaveFashionListResponseDto> userSaveFashion(String userId) {

        List<MyPageSaveFashion> myPageSaveFashions = new ArrayList<>();
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            List<FashionSaveEntity> fashionSaveEntities = fashionSaveRepository.findByUserId(userId);
            for (FashionSaveEntity fashionSaveEntity : fashionSaveEntities) {
                Integer fashionNumber = fashionSaveEntity.getFashionNumber();
                FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
                List<FashionPhotoEntity> fashionPhotoEntitys = fashionPhotoRepository
                        .findByFashionNumber(fashionNumber);
                List<FashionHashtagEntity> fashionHashtagEntitys = fashionHashtagRepository
                        .findByFashionNumber(fashionNumber);
                        MyPageSaveFashion myPageSaveFashion = new MyPageSaveFashion(fashionEntity, fashionPhotoEntitys,
                        fashionHashtagEntitys);
                myPageSaveFashions.add(myPageSaveFashion);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageSaveFashionListResponseDto.success(myPageSaveFashions);
    }

    @Override
    public ResponseEntity<? super GetMyPageBoardFashionListResponseDto> myPageBoardFashionList(String userId) {
        List<FashionEntity> fashionEntities  = new ArrayList<>();
        try {
            boolean user = userRepository.existsByUserId(userId);
            if(!user) return ResponseDto.noExistUserId();
            fashionEntities = fashionRepository.findByUserId(userId);

        if (fashionEntities == null) return ResponseDto.noExistUserId();
    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }
    return GetMyPageBoardFashionListResponseDto.success(fashionEntities);
    }

    @Override
    public ResponseEntity<? super GetMyPageLikeFashionListResponseDto> myPageLikeFashionList(String userId) {
        List<MyPageLikeFashion> myPageLikeFashions = new ArrayList<>();
        try {
            List<FashionLikeEntity> fashionLikeEntities = fashionLikeRepository.findByUserId(userId);
            for(FashionLikeEntity fashionLikeEntity : fashionLikeEntities){
                Integer fashionNumber = fashionLikeEntity.getFashionNumber();
                FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
                List<FashionPhotoEntity> fashionPhotoEntities = fashionPhotoRepository.findByFashionNumber(fashionNumber);
                List<FashionHashtagEntity> fashionHashtagEntities = fashionHashtagRepository.findByFashionNumber(fashionNumber);
                MyPageLikeFashion myPageLikeFashion = new MyPageLikeFashion(fashionEntity, fashionPhotoEntities, fashionHashtagEntities);
                myPageLikeFashions.add(myPageLikeFashion);
            }

            
    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }
    return GetMyPageLikeFashionListResponseDto.success(myPageLikeFashions);

    }
}
