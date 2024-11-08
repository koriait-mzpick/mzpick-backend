package com.koreait.mzpick_backend.service.implement.vote;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.vote.TravelVote;
import com.koreait.mzpick_backend.dto.request.vote.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.vote.GetMyPageVoteTravelListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetTravelVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetTravelVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetTravelVoteTotalCountResponseDto;
import com.koreait.mzpick_backend.entity.travel.resultSet.GetTravelVoteResultSet;
import com.koreait.mzpick_backend.entity.vote.TravelVoteEntity;
import com.koreait.mzpick_backend.entity.vote.TravelVoteResultEntity;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.repository.vote.TravelVoteRepository;
import com.koreait.mzpick_backend.repository.vote.TravelVoteResultRepository;
import com.koreait.mzpick_backend.service.vote.TravelVoteService;

import lombok.RequiredArgsConstructor;

//service 여행지 투표 관련 서비스 //
@Service
@RequiredArgsConstructor
public class TravelVoteServiceImplement implements TravelVoteService {
    private final UserRepository userRepository;
    private final TravelVoteRepository travelVoteRepository;
    private final TravelVoteResultRepository travelVoteResultRepository;

    // Get 여행지 관련 투표 리스트 서비스 //
    @Override
    public ResponseEntity<? super GetTravelVoteListResponseDto> getTravelVoteList() {
        List<TravelVote> travelVotes = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        try {
            List<TravelVoteEntity> travelVoteEntitys = travelVoteRepository.findByTravelVoteExpireDateGreaterThanEqual(now);
            for (TravelVoteEntity travelVoteEntity : travelVoteEntitys) {
                Integer travelVoteNumber = travelVoteEntity.getTravelVoteNumber();
                List<TravelVoteResultEntity> travelVoteResultEntitys = travelVoteResultRepository
                        .findByTravelVoteNumber(travelVoteNumber);
                TravelVote travelVote = new TravelVote(travelVoteEntity, travelVoteResultEntitys);
                travelVotes.add(travelVote);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelVoteListResponseDto.success(travelVotes);
    }

    // Get 해당 여행지 관련 투표 게시글 상세보기 //
    @Override
    public ResponseEntity<? super GetTravelVoteDetailResponseDto> getTravelVote(Integer travelVoteNumber) {
        TravelVote travelVote = null;
        try {
            TravelVoteEntity travelVoteEntity = travelVoteRepository.findByTravelVoteNumber(travelVoteNumber);
            if (travelVoteEntity == null)
                return ResponseDto.noExistBoard();

            List<TravelVoteResultEntity> travelVoteResultEntities = travelVoteResultRepository
                    .findByTravelVoteNumber(travelVoteNumber);
            travelVote = new TravelVote(travelVoteEntity, travelVoteResultEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelVoteDetailResponseDto.success(travelVote);
    }

    // Post 여행지 관련 투표 작성하기 //
    @Override
    public ResponseEntity<ResponseDto> postTravelVote(PostTravelVoteRequestDto dto, String userId) {
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            TravelVoteEntity travelVoteEntity = new TravelVoteEntity(dto, userId);
            travelVoteRepository.save(travelVoteEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    // Delete 여행지 관련 투표 게시글 삭제하기 //
    @Override
    public ResponseEntity<ResponseDto> deleteTravelVote(Integer travelVoteNumber, String userId) {

        try {
            TravelVoteEntity travelVoteEntity = travelVoteRepository.findByTravelVoteNumber(travelVoteNumber);
            if (travelVoteEntity == null)
                return ResponseDto.noExistBoard();

            String user = travelVoteEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            travelVoteRepository.delete(travelVoteEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();

    }

    @Override
    public ResponseEntity<ResponseDto> clickVote(Integer selectNumber, Integer travelVoteNumber, String userId) {

        try {
            TravelVoteEntity travelVoteEntity = travelVoteRepository.findByTravelVoteNumber(travelVoteNumber);
            if (travelVoteEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();
            String travelVoteResultChoice = selectNumber == 1 ? travelVoteEntity.getTravelVoteChoice1() : travelVoteEntity.getTravelVoteChoice2();
          
            TravelVoteResultEntity travelVoteResultEntity = travelVoteResultRepository.findByUserIdAndTravelVoteNumber(userId, travelVoteNumber);

            if (travelVoteResultEntity == null) {
                travelVoteResultEntity = new TravelVoteResultEntity(travelVoteNumber, userId, travelVoteResultChoice);
            } else {
                travelVoteResultEntity.setTravelVoteResultChoice(travelVoteResultChoice);
            }
            travelVoteResultRepository.save(travelVoteResultEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetTravelVoteTotalCountResponseDto>
    totalVote(Integer travelVoteNumber) {
    List<GetTravelVoteResultSet> resultSets = new ArrayList<>();
    try {
        resultSets = travelVoteResultRepository.totalVoteResultCount(travelVoteNumber);
    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }
    return GetTravelVoteTotalCountResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetMyPageVoteTravelListResponseDto> myPageVoteTravelList(String userId) {
        List<TravelVoteEntity> travelVoteEntities = new ArrayList<>();

        try {
            boolean user = userRepository.existsByUserId(userId);
            if (!user)
                return ResponseDto.noExistUserId();
            travelVoteEntities = travelVoteRepository.findByUserId(userId);

            if (travelVoteEntities == null)
                return ResponseDto.noExistBoard();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageVoteTravelListResponseDto.success(travelVoteEntities);
    }
}
