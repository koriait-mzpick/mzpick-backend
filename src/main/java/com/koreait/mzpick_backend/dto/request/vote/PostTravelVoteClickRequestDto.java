package com.koreait.mzpick_backend.dto.request.vote;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// requestDto 여행 관련 투표 클릭 //
@Getter
@Setter
@NoArgsConstructor
public class PostTravelVoteClickRequestDto {
    @NotNull
    private String travelVoteResultChoice;
}
