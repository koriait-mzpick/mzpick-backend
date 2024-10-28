package com.koreait.mzpick_backend.entity.fashion;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="fashionLike")
@Table(name="fashion_like")
@IdClass(FashionLikepk.class)
public class FashionLikeEntity {
    @Id
    private String userId;
    @Id
    private Integer fashionNumber;

    public FashionLikeEntity(Integer fashionNumber, String userId){
        this.userId = userId;
        this.fashionNumber = fashionNumber;
    }
}
