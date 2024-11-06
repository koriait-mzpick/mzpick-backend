package com.koreait.mzpick_backend.repository.stay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.resultSet.GetTravelStayHallOfFamePhotoListResultSet;


@Repository
public interface TravelStayRepository extends JpaRepository<TravelStayEntity, Integer> {
    TravelStayEntity findByTravelStayNumber(Integer travelStayNumber);
    List<TravelStayEntity> findByUserId(String userId);

     // ! 5개의 게시글 을 출력하고 Param을 이용한 페이지네이션 구현 //
    @Query(value=
    "SELECT * FROM travel_stay " +
    "WHERE travel_location LIKE %:searchLocation% " +
    "AND travel_stay_number IN (SELECT DISTINCT travel_stay_number FROM travel_stay_hashtag WHERE travel_stay_hashtag_content LIKE %:hashtag%) " +
    "ORDER BY travel_stay_date DESC " + 
    "LIMIT :paging, 8", 
    nativeQuery=true)
    List<TravelStayEntity> findByPaging(@Param("paging") Integer paging, @Param("searchLocation") String searchLocation, @Param("hashtag") String hashtag);

    @Query(
    value=
        "SELECT tp.travel_stay_number AS travelNumber, tp.travel_stay_photo_link  AS photoLink " +
        "FROM travel_stay_photo tp " +
        "INNER JOIN " +
        "(SELECT travel_stay_number, (travel_stay_like_count + travel_stay_save_count) AS total " +
        "FROM travel_stay " +
        "WHERE travel_stay_date BETWEEN :startDate AND :endDate " +
        "ORDER BY total DESC " +
        "LIMIT 1) t " +
        "ON tp.travel_stay_number = t.travel_stay_number",
    nativeQuery=true)
    List<GetTravelStayHallOfFamePhotoListResultSet> getTravelHallOfFamePhotoList(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
