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
    private String fashionVoteTitle;
    private String fashionVotePhoto1;
    private String fashionVotePhoto2;
    @NotNull
    private String fashionVoteChoice1;
    @NotNull
    private String fashionVoteChoice2;
}