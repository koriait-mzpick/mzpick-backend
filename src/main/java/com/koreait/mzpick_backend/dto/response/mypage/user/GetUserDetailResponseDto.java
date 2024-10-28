package com.koreait.mzpick_backend.dto.response.mypage.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.auth.UserEntity;

import lombok.Getter;

@Getter
public class GetUserDetailResponseDto extends ResponseDto{
    
    private String userId;
    private String name;
    private String telNumber;
    private String joinPath;

    private GetUserDetailResponseDto (UserEntity userEntity){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userId = userEntity.getUserId();
        this.name = userEntity.getName();
        this.telNumber = userEntity.getTelNumber();
        this.joinPath = userEntity.getJoinPath();
    }
    public static ResponseEntity<GetUserDetailResponseDto> success(UserEntity userEntity){
        GetUserDetailResponseDto responseBody = new GetUserDetailResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
