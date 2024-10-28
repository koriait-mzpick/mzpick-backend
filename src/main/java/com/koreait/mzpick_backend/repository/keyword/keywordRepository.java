package com.koreait.mzpick_backend.repository.keyword;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.keyword.KeywordEntity;
import com.koreait.mzpick_backend.entity.keyword.resultSet.GetKeywordResultset;
import com.koreait.mzpick_backend.entity.keyword.resultSet.GetKeywordUserResultSet;

@Repository
public interface keywordRepository extends JpaRepository<KeywordEntity, Integer> {
    boolean existsByUserId (String userId);

    @Query(
    value=
        "SELECT keyword_content as keywordContent, count(*) as count " +
        "FROM keyword " +
        "WHERE keyword_date BETWEEN :startDate AND :endDate " +
        "GROUP BY keyword_content " +
        "ORDER BY count DESC " +
        "LIMIT 10",
    nativeQuery=true
    )
    // resultset받아와서 코드 완성
    List<GetKeywordResultset> getLanking(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(
        value=
            "SELECT user_id as user, count(*) as userCount " +
            "FROM keyword " +
            "WHERE user_id = :userId AND keyword_date BETWEEN :startDate AND :endDate ",
        nativeQuery=true
        )
        // resultset받아와서 코드 완성
        GetKeywordUserResultSet getUser(@Param("userId") String userId, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
