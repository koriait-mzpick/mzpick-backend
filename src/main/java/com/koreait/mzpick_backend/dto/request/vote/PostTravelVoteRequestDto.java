package com.koreait.mzpick_backend.dto.request.vote;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// requestDto 여행 관련 투표 작성하기 //
@Getter
@Setter
@NoArgsConstructor
public class PostTravelVoteRequestDto {
    @NotBlank
    private String travelVoteTitle;
    private String travelVotePhoto1;
    private String travelVotePhoto2;
    @NotBlank
    private String travelVoteChoice1;
    @NotBlank
    private String travelVoteChoice2;
}
