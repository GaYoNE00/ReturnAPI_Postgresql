package com.example.returnapi_postgresql.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class resultDTO {
    private Long rid;
    private Long cid;
    private Long aid;
    private String action;
    private String detail;
    private String urllink;
    private String urlcall;

}
