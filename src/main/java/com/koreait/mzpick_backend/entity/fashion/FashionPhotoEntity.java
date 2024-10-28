package com.koreait.mzpick_backend.entity.fashion;

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
@Entity(name="fashionPhoto")
@Table(name="fashion_photo")
public class FashionPhotoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer fashionPhotoNumber;
    private Integer fashionNumber;
    private String fashionPhotoLink;

    public FashionPhotoEntity(Integer fashionNumber, String fashionPhotoLink){
        this.fashionNumber = fashionNumber;
        this.fashionPhotoLink = fashionPhotoLink;
    }
}
