package com.koreait.mzpick_backend.dto.request.fashion;
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
public class PatchFashionRequestDto {
    @NotBlank
    private String fashionTitle;
    @NotNull
    private List<String> fashionHashtagContent;
    @NotNull
    private List<String> fashionPhoto;
    @NotNull
    private Integer fashionTotalPrice;
    @NotBlank
    private String fashionContent;
}
