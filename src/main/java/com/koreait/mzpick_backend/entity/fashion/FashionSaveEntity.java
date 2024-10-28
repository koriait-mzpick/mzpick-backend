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
@Entity(name="fashionSave")
@Table(name="fashion_save")
@IdClass(FashionSavepk.class)
public class FashionSaveEntity {
    @Id
    private String userId;
    @Id
    private Integer fashionNumber;

    public FashionSaveEntity (Integer fashionNumber, String userId){
        this.fashionNumber = fashionNumber;
        this.userId = userId;
    }
}
