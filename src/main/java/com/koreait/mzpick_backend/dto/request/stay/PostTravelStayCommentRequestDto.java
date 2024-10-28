package com.koreait.mzpick_backend.dto.request.stay;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostTravelStayCommentRequestDto {
    @NotBlank
    private String travelStayComment;
}
