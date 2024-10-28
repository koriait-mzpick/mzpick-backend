package com.koreait.mzpick_backend.service.implement.fashion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.fashion.PostFashionCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionCommentListResponseDto;
import com.koreait.mzpick_backend.entity.fashion.FashionCommentEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.repository.fashion.FashionCommentRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.fashion.FashionCommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FashionCommentServiceImplement implements FashionCommentService{
    private final FashionRepository fashionRepository;
    private final UserRepository userRepository;
    private final FashionCommentRepository fashionCommentRepository;
    @Override
    public ResponseEntity<? super GetFashionCommentListResponseDto> getFashionCommentList(Integer fashionNumber) {
        List<FashionCommentEntity> fashionCommentEntities = new ArrayList<>();
        try {
            fashionCommentEntities = fashionCommentRepository.findByFashionNumber(fashionNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionCommentListResponseDto.success(fashionCommentEntities);
    }

    @Override
    public ResponseEntity<ResponseDto> postFashionComment(PostFashionCommentRequestDto dto, Integer fashionNumber, String userId) {
        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if(fashionEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if(!existedUser) return ResponseDto.noExistUserId();

            FashionCommentEntity fashionCommentEntity = new FashionCommentEntity(dto, fashionNumber, userId);
            fashionCommentRepository.save(fashionCommentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteFashionComment(Integer fashionCommentNumber, String userId) {
        try {
            FashionCommentEntity fashionCommentEntity = fashionCommentRepository.findByFashionCommentNumber(fashionCommentNumber);
            if(fashionCommentEntity == null) return ResponseDto.noExistComment();

            String user = fashionCommentEntity.getUserId();
            boolean isUser = user.equals(userId);
            if(!isUser) return ResponseDto.noPermission();

            fashionCommentRepository.deleteByFashionCommentNumber(fashionCommentNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

}
