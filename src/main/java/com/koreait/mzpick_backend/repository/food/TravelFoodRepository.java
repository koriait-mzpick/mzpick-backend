package com.koreait.mzpick_backend.repository.food;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.resultSet.GetTravelFoodHallOfFamePhotoListResultSet;


@Repository
public interface TravelFoodRepository extends JpaRepository<TravelFoodEntity, Integer> {
    TravelFoodEntity findByTravelFoodNumber (Integer travelFoodNumber);
    List<TravelFoodEntity> findByUserId (String userId);

   // ! 5개의 게시글 을 출력하고 Param을 이용한 페이지네이션 구현 //
    @Query(value=
    "SELECT * FROM travel_food " +
    "ORDER BY travel_food_date DESC " + 
    "LIMIT :paging, 5", 
    nativeQuery=true)
    List<TravelFoodEntity> findByPaging(@Param("paging") Integer paging);

    @Query(
    value=
        "SELECT tp.travel_food_number AS travelNumber, tp.travel_food_photo_link  AS photoLink " +
        "FROM travel_food_photo tp " +
        "INNER JOIN " +
        "(SELECT travel_food_number, (travel_food_like_count + travel_food_save_count) AS total " +
        "FROM travel_food " +
        "WHERE travel_food_date BETWEEN :startDate AND :endDate " +
        "ORDER BY total DESC " +
        "LIMIT 1) t " +
        "ON tp.travel_food_number = t.travel_food_number",
    nativeQuery=true)
    List<GetTravelFoodHallOfFamePhotoListResultSet> getTravelHallOfFamePhotoList(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
