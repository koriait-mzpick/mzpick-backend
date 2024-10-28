package com.koreait.mzpick_backend.service.implement.stay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayCommentListResponseDto;
import com.koreait.mzpick_backend.entity.stay.TravelStayCommentEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.repository.stay.TravelStayCommentRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.stay.TravelStayCommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelStayCommentServiceImplement implements TravelStayCommentService {
    private final TravelStayRepository travelStayRepository;
    private final UserRepository userRepository;
    private final TravelStayCommentRepository travelStayCommentRepository;

    @Override
    public ResponseEntity<? super GetTravelStayCommentListResponseDto> getTravelStayCommentList(Integer travelStayNumber) {
        List<TravelStayCommentEntity>  travelStayCommentEntities = new ArrayList<>();
        try {
            travelStayCommentEntities = travelStayCommentRepository.findByTravelStayNumber(travelStayNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelStayCommentListResponseDto.success(travelStayCommentEntities);
    }


    @Override
    public ResponseEntity<ResponseDto> postTravelStayComment(PostTravelStayCommentRequestDto dto, Integer travelStayNumber,
            String userId) {
        try {
            TravelStayEntity travelStayEntity = travelStayRepository.findByTravelStayNumber(travelStayNumber);
            if (travelStayEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            TravelStayCommentEntity travelStayCommentEntity = new TravelStayCommentEntity(dto, travelStayNumber, userId);
            travelStayCommentRepository.save(travelStayCommentEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravelStayComment(Integer travelStayCommentNumber, String userId) {
        try {
            TravelStayCommentEntity travelStayCommentEntity = travelStayCommentRepository.findByTravelStayCommentNumber(travelStayCommentNumber);
            if(travelStayCommentEntity == null) return ResponseDto.noExistComment();

            String user = travelStayCommentEntity.getUserId();
            boolean isUser = user.equals(userId);
            if(!isUser) return ResponseDto.noPermission();
            travelStayCommentRepository.deleteByTravelStayCommentNumber(travelStayCommentNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
}
