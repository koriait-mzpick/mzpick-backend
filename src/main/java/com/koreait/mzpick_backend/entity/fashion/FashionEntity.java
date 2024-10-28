package com.koreait.mzpick_backend.entity.fashion;

import java.time.LocalDate;

import com.koreait.mzpick_backend.dto.request.fashion.PatchFashionRequestDto;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionRequestDto;

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
@Entity(name="fashion")
@Table(name="fashion")
public class FashionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer fashionNumber;
    private String userId;
    private String fashionTitle;
    private String fashionContent;
    private Integer fashionLikeCount;
    private Integer fashionViewCount;
    private Integer fashionSaveCount;
    private Integer fashionTotalPrice;
    private LocalDate fashionDate;

    public FashionEntity(PostFashionRequestDto dto, String userId){
        this.userId = userId;
        this.fashionTitle = dto.getFashionTitle();
        this.fashionContent = dto.getFashionContent();
        this.fashionLikeCount = 0;
        this.fashionViewCount = 0;
        this.fashionSaveCount = 0;
        this.fashionTotalPrice = dto.getFashionTotalPrice();
        this.fashionDate = LocalDate.now();
    }

    public void patch(PatchFashionRequestDto dto, String userId){
        this.userId = userId;
        this.fashionTitle = dto.getFashionTitle();
        this.fashionContent = dto.getFashionContent();
        this.fashionTotalPrice = dto.getFashionTotalPrice();
        this.fashionDate = LocalDate.now();
    }


    public void upLikeCount(){
        this.fashionLikeCount ++;
    }

    public void downLikeCount(){
        this.fashionLikeCount --;
    }

    public void upSaveCount(){
        this.fashionSaveCount ++;
    }
    public void downSaveCount(){
        this.fashionSaveCount --;
    }

    public void upViewCount(){
        this.fashionViewCount ++;
    }
}
