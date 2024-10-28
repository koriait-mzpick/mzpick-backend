package com.koreait.mzpick_backend.entity.keyword;

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
@Entity(name="keywordFiltering")
@Table(name="keyword_filtering")
public class KeywordFilteringEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer keywordFilteringNumber;
    private String filteringKeyword;
}
