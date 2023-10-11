package com.all4land.returnapi_postgresql.DTO;

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
    private String category ;
    private String action;
    private String intent;
    private String detail;
    private String urllink;
    private String urlcall;

}
