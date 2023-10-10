package com.example.returnapi_postgresql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class sub_result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sr_id;

    private String entity;

    private String urlcall;
    private String url;


}
