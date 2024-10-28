package com.koreait.mzpick_backend.entity.fashion;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FashionSavepk implements Serializable{
    @Column()
    private String userId;
    @Column()
    private Integer fashionNumber;
    
}
