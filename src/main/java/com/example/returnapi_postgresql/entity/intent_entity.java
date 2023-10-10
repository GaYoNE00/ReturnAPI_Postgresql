package com.example.returnapi_postgresql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class intent_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    private String intent_name;

}
