package com.koreait.mzpick_backend.entity.keyword;

import java.time.LocalDate;

import com.koreait.mzpick_backend.dto.request.keyword.PostKeywordWriteRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="keyword")
@Table(name="keyword")
public class KeywordEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer keywordNumber;
    private String userId;
    private String keywordContent;
    private LocalDate keywordDate;

    public KeywordEntity(PostKeywordWriteRequestDto dto , String userId){
        this.userId = userId;
        this.keywordContent = dto.getKeywordContent();
        this.keywordDate = LocalDate.now();
    }
}
