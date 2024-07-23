package com.example.b01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {

    @GetMapping
    public String main8080(){
        return "redirect:/main";
    }//localhost:8080

    @GetMapping("/main")
    public void main(){
        log.info("메인페이지입니다.");
    }//localhost:8080/main



    @PostMapping("/index")
    public void index(){
        log.info("메인페이지입니다.");
    }

    @GetMapping("/index")
    public void index1(){
        log.info("메인페이지입니다.");
    }
}
