package com.koreait.mzpick_backend.dto.request.vote;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostFashionVoteClickRequestDto {
    @NotNull
    private String fashionVoteResultChoice;
}
