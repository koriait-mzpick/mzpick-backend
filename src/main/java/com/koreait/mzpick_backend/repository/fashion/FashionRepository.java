package com.koreait.mzpick_backend.repository.fashion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.resultSet.GetFashionHallOfFamePhotoListResultSet;
@Repository
public interface FashionRepository extends JpaRepository<FashionEntity, Integer> {
    FashionEntity findByFashionNumber(Integer fashionNumber);
    List<FashionEntity> findByUserId(String userId);

    // ! 5개의 게시글 을 출력하고 Param을 이용한 페이지네이션 구현 //
    @Query(value=
    "SELECT * FROM fashion " +
    "ORDER BY fashion_date DESC " + 
    "LIMIT :paging, 8", 
    nativeQuery=true)
    List<FashionEntity> findByPaging(@Param("paging") Integer paging);

    @Query(
    value=
        "SELECT tp.fashion_number AS travelNumber, tp.fashion_photo_link  AS photoLink " +
        "FROM fashion_photo tp " +
        "INNER JOIN " +
        "(SELECT fashion_number, (fashion_like_count + fashion_save_count) AS total " +
        "FROM fashion " +
        "WHERE fashion_date BETWEEN :startDate AND :endDate " +
        "ORDER BY total DESC " +
        "LIMIT 1) t " +
        "ON tp.fashion_number = t.fashion_number",
    nativeQuery=true)
    List<GetFashionHallOfFamePhotoListResultSet> getFashionHallOfFamePhotoList(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
