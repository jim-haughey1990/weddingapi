package com.jimjade.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jimjade.models.Guest;
import com.jimjade.queries.JdbcGuests;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController("/guests")
public class GuestController {

    final static Logger logger = Logger.getLogger(GuestController.class);

    @Autowired
    ApplicationContext ctx;

    @GetMapping(name="/search")
    public String searchGuests(@RequestParam(name = "q", required = true) String query){
        Gson g = new Gson();
        JdbcGuests gdao = ctx.getBean(JdbcGuests.class);
        List<Guest> l = gdao.queryGuests(query);
        return g.toJson(l);
    }

    @PostMapping(name = "/save")
    public String saveGuests(@RequestBody String user){
        Gson g = new Gson();
        Type listType = new TypeToken<ArrayList<Guest>>(){}.getType();
        List<Guest> users = g.fromJson(user, listType);
        JdbcGuests gdao = ctx.getBean(JdbcGuests.class);
        for(Guest u: users) {
            logger.info(u.toString());
            if (gdao.saveGuest(u) == 1) {
                logger.info("user updated: " + u.toString());

            } else {
                logger.error("an error occured saving user " + u.toString());
                return "0";
            }
        }
        return "1";
    }

    private class GuestWrapper{
        List<Guest> users;
    }
}
