package com.example.returnapi_postgresql.Service;

import com.all4land.asd.DTO.resultDTO;
import com.all4land.asd.entity.basiginfo_entity;

public interface ChatService {
//    List<result_entity> findByCategoryAndAction(String category, String action);

    resultDTO ans(String category, String action);
    String subans(String intent, String category);
    String Msubans(String intent, String action);

    default resultDTO entityToDTO(basiginfo_entity entity){
        resultDTO dto = resultDTO.builder()
                .rid(entity.getRid())
                .aid(entity.getAction().getAid())
                .cid(entity.getCategory().getCid())
                .urllink(entity.getUrllink())
                .detail(entity.getDetail())
                .urlcall(entity.getUrlcall())
                .build();
        return dto;
    }

}
