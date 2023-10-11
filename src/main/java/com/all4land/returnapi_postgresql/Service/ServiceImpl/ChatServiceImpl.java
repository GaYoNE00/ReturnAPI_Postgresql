package com.all4land.returnapi_postgresql.Service.ServiceImpl;

import com.all4land.returnapi_postgresql.DTO.resultDTO;
import com.all4land.returnapi_postgresql.Service.ChatService;
import com.all4land.returnapi_postgresql.entity.basicinfo_entity;
import com.all4land.returnapi_postgresql.repository.api_repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final api_repository repository;

    @Override
    public resultDTO ans(String category, String action) {
        List<basicinfo_entity> results = repository.findByCategoryAndAction(category, action);
        if (results != null && !results.isEmpty()) {
            System.out.println("답변 전용 서브 메인 쿼리---------------------"+results);
            return entityToDTO(results.get(0));
        }else{
            List<basicinfo_entity> res = repository.findByCategoryAndAction2(category, action);
            if(res !=null && !res.isEmpty()){
                System.out.println("답변 전용 서브 백업 쿼리**************************************`"+res);
                return entityToDTO(res.get(0));
            }else{
                return null;
            }
        }

    }
    @Override
    public String subans(String intent, String category) {
        String results = repository.findActionsByCategoryName(intent, category).toString();
        if (results != null && !results.isEmpty()&& !results.equals("[]")) {
            System.out.println("액션 전용 서브 메인 쿼리---------------------"+results);
            return results;
        }else{
            String res = repository.findActionsByCategoryName2(intent, category).toString();
            if(res !=null && !res.isEmpty()){
                System.out.println("액션 전용 서브 백업 쿼리**************************************`"+res);
                return res;
            }else{
                return null;
            }
        }
    }
    @Override
    public String Msubans(String intent, String action) {
        String results = repository.findCategoryByActionsName(intent, action).toString();
        if (results != null && !results.isEmpty()&& !results.equals("[]")) {
            System.out.println("서비스 전용 서브 메인 쿼리---------------------"+results);
            return results;
        }else{
            String res = repository.findCategoryByActionsName2(intent ,action).toString();
            if(res !=null && !res.isEmpty()){
                System.out.println("서비스 전용 서브 백업 쿼리**************************************`"+res);
                return res;
            }else{
                return null;
            }
        }
    }
}



