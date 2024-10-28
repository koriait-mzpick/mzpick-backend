package com.koreait.mzpick_backend.entity.vote;

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
public class FashionVoteResultpk implements Serializable{
    @Column()
    private String userId;
    @Column()
    private Integer fashionVoteNumber;
    
}
