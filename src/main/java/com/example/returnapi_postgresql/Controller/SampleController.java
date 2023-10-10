package com.example.returnapi_postgresql.Controller;

import com.all4land.asd.DTO.resultDTO;
import com.all4land.asd.Service.ChatService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class SampleController {
    private LocalDateTime currentTime = LocalDateTime.now();
    private String ip;
    @Autowired
    private final ChatService Service;

    @GetMapping("index")
    public void index(){

    }

    @PostMapping("search")
    public ResponseEntity<resultDTO> search(@RequestParam String category, @RequestParam String action,HttpServletRequest request){
//        resultDTO resultDTO = (com.all4land.asd.DTO.resultDTO) Service.findByCategoryAndAction(category, action);
        resultDTO result = Service.ans(category, action);
        ip = request.getRemoteAddr();
        System.out.println("[" + currentTime + "] IP: " + ip + " | category: " + category +" | Action: " + action);
        if(result!=null){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @PostMapping("register_search")
    public ResponseEntity<resultDTO> register_search(@RequestParam String category, @RequestParam String action,HttpServletRequest request){
//        resultDTO resultDTO = (com.all4land.asd.DTO.resultDTO) Service.findByCategoryAndAction(category, action);
        resultDTO result = Service.ans(category, action);
        ip = request.getRemoteAddr();
        System.out.println("[" + currentTime + "] IP: " + ip + " | category: " + category +" | Action: " + action);
        if(result!=null){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @PostMapping("sub_search")
    public ResponseEntity<String> subsearch(@RequestParam String intent, @RequestParam String category, HttpServletRequest request){
        String result = Service.subans(intent,category);
        ip = request.getRemoteAddr();
        System.out.println("[" + currentTime + "] IP: " + ip + " | intent: " + intent + " | category: " + category);
        if(result!=null){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("Msub_search")
    public ResponseEntity<String> Msubsearch(@RequestParam String intent, @RequestParam String action, HttpServletRequest request){
        String result = Service.Msubans(intent,action);
        ip = request.getRemoteAddr();
        System.out.println("[" + currentTime + "] IP: " + ip + " | intent: " + intent + " | category: " + action);
        if(result!=null){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
