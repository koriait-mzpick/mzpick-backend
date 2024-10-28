package com.koreait.mzpick_backend.dto.response.keyword;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.keyword.resultSet.GetKeywordResultset;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class GetKeywordListResponseDto extends ResponseDto {
    
    // private List<String> keywords;
    private List<GetKeywordResultset> getKeywordResultsets;

    private GetKeywordListResponseDto(List<GetKeywordResultset> getKeywordResultsets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.getKeywordResultsets = getKeywordResultsets;
    }

    public static ResponseEntity<GetKeywordListResponseDto> success(List<GetKeywordResultset> getKeywordResultsets) {
        GetKeywordListResponseDto responseBody = new GetKeywordListResponseDto(getKeywordResultsets);
       return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
