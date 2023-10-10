package com.example.returnapi_postgresql.repository;

import com.all4land.asd.entity.basiginfo_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface api_repository extends JpaRepository<basiginfo_entity, Long> {

//    @Query("SELECT r FROM result_entity r WHERE r.category.cname LIKE %:category% AND r.action.aname LIKE %:action%")
//    List<result_entity> findByCategoryAndAction(@Param("category") String category, @Param("action") String action);

    @Query("SELECT r FROM basiginfo_entity r WHERE r.category.cname LIKE %:category% AND r.action.aname LIKE %:action%")
    List<basiginfo_entity> findByCategoryAndAction(@Param("category") String category, @Param("action") String action);

    @Query(value = "SELECT r.* " +
            "FROM basiginfo_entity r " +
            "INNER JOIN category_entity c ON r.cid = c.cid " +
            "INNER JOIN action_entity a ON r.aid = a.aid " +
            "WHERE MATCH(c.cname) AGAINST (:category IN NATURAL LANGUAGE MODE) " +
            "AND a.aname = :action", nativeQuery = true)
    List<basiginfo_entity> findByCategoryAndAction2(@Param("category") String category, @Param("action") String action);

    @Query(value = "SELECT * " +
            "FROM basiginfo_entity r " +
            "INNER JOIN category_entity c ON r.cid = c.cid " +
            "INNER JOIN action_entity a ON r.aid = a.aid " +
            "WHERE MATCH(r.category.cname) AGAINST (:category IN NATURAL LANGUAGE MODE) > 0 " +
            "AND a.aname = :action", nativeQuery = true)
    List<basiginfo_entity> findByCategoryAndAction3(@Param("category") String category, @Param("action") String action);

    //    @Query("SELECT r.action.aname FROM result_entity r WHERE r.category.cname = :cname")
//    List<String> findActionsByCategoryName(@Param("cname") String cname);}
    @Query("SELECT r.action.aname FROM basiginfo_entity r WHERE r.category.cname LIKE CONCAT('%', :cname, '%') AND r.intent.intent_name = :intent_name")
    List<String> findActionsByCategoryName(@Param("intent_name") String intent_name,@Param("cname") String cname);

    @Query("SELECT r.category.cname FROM basiginfo_entity r WHERE r.action.aname LIKE CONCAT('%', :aname, '%') AND r.intent.intent_name = :intent_name")
    List<String> findCategoryByActionsName(@Param("intent_name") String intent_name,@Param("aname") String aname);

    @Query(value = "SELECT a.aname " +
            "FROM basiginfo_entity r " +
            "INNER JOIN category_entity c ON r.cid = c.cid " +
            "INNER JOIN action_entity a ON r.aid = a.aid " +
            "WHERE MATCH(c.cname) AGAINST (:cname IN NATURAL LANGUAGE MODE) > 0",
            nativeQuery = true)
    List<String> findActionsByCategoryName2(@Param("cname") String cname);
}