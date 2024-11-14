package com.koreait.mzpick_backend.dto.request.cafe;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchTravelCafeRequestDto {
    @NotBlank
    private String travelCafeTitle;
    @NotNull
    private List<String> travelCafeHashtagContentList;
    @NotBlank
    private String travelLocation;
    @NotNull
    private List<String> travelCafePhotoList;
    @NotNull
    private List<String> travelCafeCategoryList;
    @NotBlank
    private String travelCafeContent;
}
