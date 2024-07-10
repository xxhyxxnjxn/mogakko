package com.example.mogakko.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;

@Controller
public class TestController {
    /**
     0710 회고
     * response.sendRedirect로 보냈으면 됐는데 난 굳이 restTemplate을 고민했던 것 같다
     * 왜그랬을까
     * 그냥 새로운 코드를 짜고싶어서 그럤던 거였을까
     * 때로는 간단한 코드가 제일 효율적으로 이용될거라는 것을 명심하자
     */

    @GetMapping("/login")
    public void login(HttpServletResponse response) {
        //resttemplate으로 보내면 200리턴에 그냥 html코드가 return됨
        //send redirect로 보내면 302리턴으로 변경
        try {
//            response.sendRedirect("http://localhost:8080/authorize");
            response.sendRedirect("https://kauth.kakao.com/oauth/authorize?client_id=42d70ba51d94e82f8d0be186985042e7&response_type=code&redirect_uri=http://localhost:8080/authorize/info");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/authorize")
    @ResponseBody
    public void authorize(HttpServletResponse response) {
        try {
            response.sendRedirect("http://localhost:8080/index");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/authorize/info")
    @ResponseBody
    public void authorizeInfo(@RequestParam HashMap<String, String> resData, HttpServletResponse response) {
        try {
            System.out.println(resData);
            response.sendRedirect("http://localhost:8080/index");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/index")
    public String index(){

        return "index";
    }
}
