package com.koreait.mzpick_backend.repository.cafe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.resultSet.GetTravelCafeHallOfFamePhotoListResultSet;

@Repository
public interface TravelCafeRepository extends JpaRepository<TravelCafeEntity, Integer> {
    TravelCafeEntity findByTravelCafeNumber(Integer travelcafeNumber);
    List<TravelCafeEntity> findByUserId(String userId);

       // ! 5개의 게시글 을 출력하고 Param을 이용한 페이지네이션 구현 //
    @Query(value=
    "SELECT * FROM travel_cafe " +
    "ORDER BY travel_cafe_date DESC " + 
    "LIMIT :paging, 8", 
    nativeQuery=true)
    List<TravelCafeEntity> findByPaging(@Param("paging") Integer paging);

    @Query(
    value=
        "SELECT tp.travel_cafe_number AS travelNumber, tp.travel_cafe_photo_link  AS photoLink " +
        "FROM travel_cafe_photo tp " +
        "INNER JOIN " +
        "(SELECT travel_cafe_number, (travel_cafe_like_count + travel_cafe_save_count) AS total " +
        "FROM travel_cafe " +
        "WHERE travel_cafe_date BETWEEN :startDate AND :endDate " +
        "ORDER BY total DESC " +
        "LIMIT 1) t " +
        "ON tp.travel_cafe_number = t.travel_cafe_number",
    nativeQuery=true)
    List<GetTravelCafeHallOfFamePhotoListResultSet> getTravelHallOfFamePhotoList(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
