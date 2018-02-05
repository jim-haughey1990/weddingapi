package com.jimjade.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealController {

    @GetMapping("/meals")
    public String getMeals(){
        return "";
    }
}
