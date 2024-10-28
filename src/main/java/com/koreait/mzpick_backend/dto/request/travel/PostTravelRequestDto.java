package com.koreait.mzpick_backend.dto.request.travel;
// 여행지 리스트 보기 요청 dto
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// requestDto 여행지 게시글 작성하기 //
@Getter
@Setter
@NoArgsConstructor
public class PostTravelRequestDto {
    @NotBlank
    private String travelTitle;
    @NotNull
    private List<String> travelHashtagContentList;
    @NotBlank
    private String travelLocation;
    @NotNull
    private List<String> travelPhotoList;
    @NotBlank
    private String travelContent;
}
