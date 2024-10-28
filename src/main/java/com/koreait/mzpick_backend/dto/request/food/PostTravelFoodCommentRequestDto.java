package com.koreait.mzpick_backend.dto.request.food;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostTravelFoodCommentRequestDto {
    @NotBlank
    private String travelFoodComment;
}
