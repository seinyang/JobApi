package com.example.api.controller;

import com.example.api.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ViewController {


    private final JwtUtil jwtUtil;
    @GetMapping("/login")
    public String login(){
        return "index";
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }


}
