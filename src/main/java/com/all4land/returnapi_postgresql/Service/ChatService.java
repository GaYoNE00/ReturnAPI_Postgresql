package com.all4land.returnapi_postgresql.Service;

import com.all4land.returnapi_postgresql.DTO.resultDTO;
import com.all4land.returnapi_postgresql.entity.basicinfo_entity;

public interface ChatService {
//    List<result_entity> findByCategoryAndAction(String category, String action);

    resultDTO ans(String category, String action);
    String subans(String intent, String category);
    String Msubans(String intent, String action);

    default resultDTO entityToDTO(basicinfo_entity entity){
        resultDTO dto = resultDTO.builder()
                .rid(entity.getRid())
                .action(entity.getAction())
                .category(entity.getCategory())
                .intent(entity.getIntent())
                .detail(entity.getDetail())
                .urlcall(entity.getUrlcall())
                .urllink(entity.getUrllink())
                .build();
        return dto;
    }

}
