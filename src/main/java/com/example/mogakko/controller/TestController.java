package com.example.mogakko.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Controller
public class TestController {


    @GetMapping("/login")
    public void login(HttpServletResponse response) {
        //resttemplate으로 보내면 200리턴에 그냥 html코드가 return됨
        //send redirect로 보내면 302리턴으로 변경
        try {
            response.sendRedirect("http://localhost:8080/authorize");
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

    @GetMapping("/index")
    public String index(){

        return "index";
    }
}
