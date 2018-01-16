package com.jimjade.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DateController {

    @GetMapping("/countdown")
    public String getCountDown(){
        Gson s = new Gson();
        Calendar today = getToday();
        Calendar weddingday = getWeddingTime();
        long diffTime = weddingday.getTimeInMillis() - today.getTimeInMillis();
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        Map<String, Long> result = new HashMap<String, Long>();
        result.put("days", diffDays);
        return s.toJson(result);
    }

    private Calendar getWeddingTime(){
        Calendar weddingday = Calendar.getInstance();
        weddingday.set(Calendar.MONTH, 4);
        weddingday.set(Calendar.DATE, 5);
        weddingday.set(Calendar.YEAR, 2018);
        weddingday.set(Calendar.HOUR, 1);
        weddingday.set(Calendar.MINUTE, 0);
        weddingday.set(Calendar.SECOND, 0);
        return weddingday;
    }

    private Calendar getToday(){
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR, 1);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        return today;
    }
}
