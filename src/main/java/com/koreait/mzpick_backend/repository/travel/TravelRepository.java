package com.koreait.mzpick_backend.repository.travel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.resultSet.GetTravelHallOfFamePhotoListResultSet;


// Repository 여행지 레포지토리 //
@Repository
public interface TravelRepository extends JpaRepository<TravelEntity, Integer>{
    TravelEntity findByTravelNumber(Integer travelNumber);
    List<TravelEntity> findByUserId(String userId);

    // ! 5개의 게시글 을 출력하고 Param을 이용한 페이지네이션 구현 //
    @Query(value=
    "SELECT * FROM travel " +
    "WHERE travel_location LIKE %:searchLocation% " +
    "AND travel_number IN (SELECT DISTINCT travel_number FROM travel_hashtag WHERE travel_hashtag_content LIKE %:hashtag%) " +
    "ORDER BY travel_date DESC " + 
    "LIMIT :paging, 8", 
    nativeQuery=true)
    List<TravelEntity> findByPaging(@Param("paging") Integer paging, @Param("searchLocation") String searchLocation, @Param("hashtag") String hashtag);

    @Query(
    value=
        "SELECT tp.travel_number AS travelNumber, tp.travel_photo_link  AS photoLink " +
        "FROM travel_photo tp " +
        "INNER JOIN " +
        "(SELECT travel_number, (travel_like_count + travel_save_count) AS total " +
        "FROM travel " +
        "WHERE travel_date BETWEEN :startDate AND :endDate " +
        "ORDER BY total DESC " +
        "LIMIT 1) t " +
        "ON tp.travel_number = t.travel_number",
    nativeQuery=true)
    List<GetTravelHallOfFamePhotoListResultSet> getTravelHallOfFamePhotoList(@Param("startDate") String startDate, @Param("endDate") String endDate);

}
