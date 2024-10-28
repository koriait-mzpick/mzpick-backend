package com.koreait.mzpick_backend.dto.request.stay;
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
public class PatchTravelStayRequestDto {
    @NotBlank
    private String travelStayTitle;
    @NotNull
    private List<String> travelStayHashtagContentList;
    @NotBlank
    private String travelLocation;
    @NotNull
    private List<String> travelStayPhotoList;
    @NotNull
    private List<String> travelStayCategoryList;
    @NotBlank
    private String travelStayContent;
}
