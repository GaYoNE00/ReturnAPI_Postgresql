package com.all4land.returnapi_postgresql.repository;

import com.all4land.returnapi_postgresql.entity.basicinfo_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface api_repository extends JpaRepository<basicinfo_entity, Long> {

//    @Query("SELECT r FROM result_entity r WHERE r.category.cname LIKE %:category% AND r.action.aname LIKE %:action%")
//    List<result_entity> findByCategoryAndAction(@Param("category") String category, @Param("action") String action);

    @Query("SELECT r FROM basicinfo_entity r WHERE r.category LIKE %:category% AND r.action LIKE %:action%")
    List<basicinfo_entity> findByCategoryAndAction(@Param("category") String category, @Param("action") String action);

    @Query(value = "SELECT r.* " +
            "FROM basicinfo_entity r " +
            "WHERE to_tsvector('english', r.category) @@ plainto_tsquery('english', :category) " +
            "AND r.action = :action",
            nativeQuery = true)
    List<basicinfo_entity> findByCategoryAndAction2(@Param("category") String category, @Param("action") String action);

//    @Query(value = "SELECT * " +
//            "FROM basicinfo_entity r " +
//            "INNER JOIN category_entity c ON r.cid = c.cid " +
//            "INNER JOIN action_entity a ON r.aid = a.aid " +
//            "WHERE MATCH(r.category.cname) AGAINST (:category IN NATURAL LANGUAGE MODE) > 0 " +
//            "AND a.aname = :action", nativeQuery = true)
//    List<basicinfo_entity> findByCategoryAndAction3(@Param("category") String category, @Param("action") String action);

    @Query("SELECT r.action FROM basicinfo_entity r WHERE r.category LIKE CONCAT('%', :cname, '%') AND r.intent = :intent_name")
    List<String> findActionsByCategoryName(@Param("intent_name") String intent_name,@Param("cname") String cname);

    @Query("SELECT r.category FROM basicinfo_entity r WHERE r.action LIKE CONCAT('%', :aname, '%') AND r.intent = :intent_name")
    List<String> findCategoryByActionsName(@Param("intent_name") String intent_name,@Param("aname") String action);

    @Query(value = "SELECT action " +
            "FROM basicinfo_entity " +
            "WHERE to_tsvector('english', category) @@ plainto_tsquery('english', :category) " +
            "AND to_tsvector('english', intent) @@ plainto_tsquery('english', :intent)",
            nativeQuery = true)
    List<String> findActionsByCategoryName2(@Param("intent") String intent, @Param("category") String category);

    @Query(value = "SELECT category " +
            "FROM basicinfo_entity " +
            "WHERE to_tsvector('english', action) @@ plainto_tsquery('english', :action) " +
            "AND to_tsvector('english', intent) @@ plainto_tsquery('english', :intent)",
            nativeQuery = true)
    List<String> findCategoryByActionsName2(@Param("intent") String intent, @Param("action") String action);
}