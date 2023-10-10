package com.example.returnapi_postgresql.Service.ServiceImpl;

import com.all4land.asd.DTO.resultDTO;
import com.all4land.asd.Service.ChatService;
import com.all4land.asd.entity.basiginfo_entity;
import com.all4land.asd.repository.api_repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final api_repository repository;

//    @Override
//    public List<result_entity> findByCategoryAndAction(String category, String action) {
//        return repository.findByCategoryAndAction(category, action);
//    }

    @Override
    public resultDTO ans(String category, String action) {
        List<basiginfo_entity> results = repository.findByCategoryAndAction(category, action);
        if (results != null && !results.isEmpty()) {
            System.out.println("그냥 쿼리---------------------"+results);
            return entityToDTO(results.get(0));
        }else{
            List<basiginfo_entity> res = repository.findByCategoryAndAction2(category, action);
            if(res !=null && !res.isEmpty()){
                System.out.println("백업 쿼리**************************************`"+res);
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
            System.out.println("그냥 쿼리---------------------"+results);
            return results;
        }else{
            String res = repository.findActionsByCategoryName2(category).toString();
            if(res !=null && !res.isEmpty()){
                System.out.println("백업 쿼리**************************************`"+res);
                return res;
            }else{
                return null;
            }
        }
    }
    @Override
    public String Msubans(String action, String category) {
        String results = repository.findCategoryByActionsName(action, category).toString();
        if (results != null && !results.isEmpty()&& !results.equals("[]")) {
            System.out.println("그냥 쿼리---------------------"+results);
            return results;
        }else{
            String res = repository.findActionsByCategoryName2(category).toString();
            if(res !=null && !res.isEmpty()){
                System.out.println("백업 쿼리**************************************`"+res);
                return res;
            }else{
                return null;
            }
        }
    }
}



