package com.jimjade.controller;

import com.google.gson.Gson;
import org.joda.time.Interval;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class DateController {

    @GetMapping("/countdown")
    public String getCountDown(){
        Gson s = new Gson();
        Calendar today = Calendar.getInstance();
        Calendar weddingday = getWeddingTime();

        Interval interval = new Interval(today.getTime().getTime(), weddingday.getTime().getTime());
        s.toJson(interval.toInterval());
        return s.toString();
    }

    @GetMapping("/countdown/days")
    public String getCountDownDays(){
        Gson s = new Gson();
        Calendar today = Calendar.getInstance();
        Calendar weddingday = getWeddingTime();

        long difference = today.getTime().getTime() -  weddingday.getTime().getTime();
        long days = difference / (1000/60/60/24);
        return s.toString();
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
}
