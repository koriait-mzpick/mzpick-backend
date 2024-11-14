package com.koreait.mzpick_backend.service.implement.vote;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.vote.FashionVote;
import com.koreait.mzpick_backend.dto.request.vote.PostFashionlVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.mypage.vote.GetMyPageVoteFashionListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetFashionVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetFashionVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.vote.GetFashionVoteTotalCountResponseDto;
import com.koreait.mzpick_backend.entity.fashion.resultSet.GetFashionVoteResultSet;
import com.koreait.mzpick_backend.entity.vote.FashionVoteEntity;
import com.koreait.mzpick_backend.entity.vote.FashionVoteResultEntity;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.repository.vote.FashionVoteRepository;
import com.koreait.mzpick_backend.repository.vote.FashionVoteResultRepository;
import com.koreait.mzpick_backend.service.vote.FashionVoteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FashionVoteServiceImplement implements FashionVoteService {
    private final UserRepository userRepository;
    private final FashionVoteRepository fashionVoteRepository;
    private final FashionVoteResultRepository fashionVoteResultRepository;

    @Override
    public ResponseEntity<? super GetFashionVoteListResponseDto> getFashionVoteList() {
        LocalDateTime now = LocalDateTime.now();
        List<FashionVote> fashionVotes = new ArrayList<>();
        try {
            List<FashionVoteEntity> fashionVoteEntitys = fashionVoteRepository.findByFashionVoteExpireDateGreaterThanEqual(now);
            for (FashionVoteEntity fashionVoteEntity : fashionVoteEntitys) {
                Integer fashionVoteNumber = fashionVoteEntity.getFashionVoteNumber();
                List<FashionVoteResultEntity> fashionVoteResultEntitys = fashionVoteResultRepository
                        .findByFashionVoteNumber(fashionVoteNumber);
                FashionVote fashionVote = new FashionVote(fashionVoteEntity, fashionVoteResultEntitys);
                fashionVotes.add(fashionVote);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionVoteListResponseDto.success(fashionVotes);
    }

    @Override
    public ResponseEntity<? super GetFashionVoteDetailResponseDto> getFashionVote(Integer fashionVoteNumber) {
        FashionVote fashionVotes = null;
        try {
            FashionVoteEntity fashionVoteEntity = fashionVoteRepository.findByFashionVoteNumber(fashionVoteNumber);
            if (fashionVoteEntity == null) return ResponseDto.noExistBoard();

            List<FashionVoteResultEntity> fashionVoteResultEntitys = fashionVoteResultRepository.findByFashionVoteNumber(fashionVoteNumber);
            fashionVotes = new FashionVote(fashionVoteEntity, fashionVoteResultEntitys);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionVoteDetailResponseDto.success(fashionVotes);
    }

    @Override
    public ResponseEntity<ResponseDto> postFashionVote(PostFashionlVoteRequestDto dto, String userId) {
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            FashionVoteEntity fashionVoteEntity = new FashionVoteEntity(dto, userId);
            fashionVoteRepository.save(fashionVoteEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteFashionVote(Integer fashionVoteNumber, String userId) {
        try {
            FashionVoteEntity fashionVoteEntity = fashionVoteRepository.findByFashionVoteNumber(fashionVoteNumber);

            if (fashionVoteEntity == null)
                return ResponseDto.noExistBoard();

            String user = fashionVoteEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            fashionVoteRepository.delete(fashionVoteEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> clickVote(Integer selectNumber, Integer fashionVoteNumber, String userId) {
        try {
            FashionVoteEntity fashionVoteEntity = fashionVoteRepository.findByFashionVoteNumber(fashionVoteNumber);
            if (fashionVoteEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            String fashionVoteResultChoice = selectNumber == 1 ? fashionVoteEntity.getFashionVoteChoice1() : fashionVoteEntity.getFashionVoteChoice2();
            FashionVoteResultEntity fashionVoteResultEntity = fashionVoteResultRepository.findByUserIdAndFashionVoteNumber(userId, fashionVoteNumber);


            if (fashionVoteResultEntity == null) {
                fashionVoteResultEntity = new FashionVoteResultEntity(userId, fashionVoteNumber, fashionVoteResultChoice);
                fashionVoteResultRepository.save(fashionVoteResultEntity);
            } else if (fashionVoteResultEntity.getFashionVoteResultChoice().equals(fashionVoteResultChoice)) {
                fashionVoteResultRepository.delete(fashionVoteResultEntity);
            }
            else {
                fashionVoteResultEntity.setFashionVoteResultChoice(fashionVoteResultChoice);
                fashionVoteResultRepository.save(fashionVoteResultEntity);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetFashionVoteTotalCountResponseDto> totalVote(Integer fashionVoteNumber) {
        List<GetFashionVoteResultSet> resultSets = new ArrayList<>();
        try {
            resultSets = fashionVoteResultRepository.totalVoteResultCount(fashionVoteNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            ;
            return ResponseDto.databaseError();
        }
        return GetFashionVoteTotalCountResponseDto.success(resultSets);
    }

    // 마이페이지 투표 리스트 가져오기 로직
    @Override
    public ResponseEntity<? super GetMyPageVoteFashionListResponseDto> myPageVoteFashionList(String userId) {

        List<FashionVoteEntity> fashionVoteEntities = new ArrayList<>();

        try {
            boolean user = userRepository.existsByUserId(userId);
            if (!user)
                return ResponseDto.noExistUserId();
            fashionVoteEntities = fashionVoteRepository.findByUserId(userId);

            if (fashionVoteEntities == null)
                return ResponseDto.noExistBoard();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetMyPageVoteFashionListResponseDto.success(fashionVoteEntities);
    }

}
