package com.koreait.mzpick_backend.dto.request.keyword;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostKeywordWriteRequestDto {
    @NotBlank
    private String keywordContent;
    private LocalDate keywordDate;
}
