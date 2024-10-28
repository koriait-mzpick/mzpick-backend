package com.koreait.mzpick_backend.dto.request.food;
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
public class PostTravelFoodRequestDto {
    @NotBlank
    private String travelFoodTitle;
    @NotNull
    private List<String> travelFoodHashtagContentList;
    @NotBlank
    private String travelLocation;
    @NotNull
    private List<String> travelFoodPhotoList;
    @NotBlank
    private String travelFoodContent;
}
