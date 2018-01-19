package com.jimjade.controller;

import com.google.gson.Gson;
import com.jimjade.models.Guest;
import com.jimjade.queries.JdbcGuests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/guests")
public class GuestController {

    @Autowired
    ApplicationContext ctx;

    @GetMapping(name="/search")
    public String searchGuests(@RequestParam(name = "q", required = true) String query){
        Gson g = new Gson();
        JdbcGuests gdao = ctx.getBean(JdbcGuests.class);
        List<Guest> l = gdao.queryGuests(query);
        return g.toJson(l);
    }
}
