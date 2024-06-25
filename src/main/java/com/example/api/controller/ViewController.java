package com.example.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping("/login")
    public String login(){
        return "index";
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }


}
