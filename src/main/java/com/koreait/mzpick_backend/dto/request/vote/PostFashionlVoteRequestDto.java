package com.koreait.mzpick_backend.dto.request.vote;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostFashionlVoteRequestDto {
    @NotBlank
    private String FashionVoteTitle;
    private String FashionVotePhoto1;
    private String FashionVotePhoto2;
    @NotNull
    private String FashionVoteChoice1;
    @NotNull
    private String FashionVoteChoice2;
}