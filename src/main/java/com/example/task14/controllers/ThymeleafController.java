package com.example.task14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String thymeleaf() {
        return "test";
    }
}