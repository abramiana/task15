package com.example.task14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    // Показати сторінку тестування
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}