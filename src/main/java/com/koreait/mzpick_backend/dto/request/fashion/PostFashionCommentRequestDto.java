package com.koreait.mzpick_backend.dto.request.fashion;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostFashionCommentRequestDto {
    @NotBlank
    private String fashionComment;
}
