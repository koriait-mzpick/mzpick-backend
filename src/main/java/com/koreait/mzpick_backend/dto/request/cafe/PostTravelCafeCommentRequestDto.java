package com.koreait.mzpick_backend.dto.request.cafe;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostTravelCafeCommentRequestDto {
    @NotBlank
    private String travelCafeComment;
}
