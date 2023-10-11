package com.all4land.returnapi_postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class basicinfo_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    @Column(name = "category", length=100,nullable = false)
    private String category;

    @Column(name = "action",length=100,nullable = false)
    private String action;

    @Column(name = "intent",length=100,nullable = false)
    private String intent;

    @Column(name = "isrecommend",nullable = true)
    private boolean isrecommend;

    @Column(name = "detail", length=2000,nullable = false)
    private String detail;

    @Column(name = "urllink", length=2000 , nullable = true)
    private String urllink;

    @Column(name = "urlcall", length=100,nullable = true)
    private String urlcall;


}
