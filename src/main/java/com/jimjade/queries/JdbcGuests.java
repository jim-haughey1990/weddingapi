package com.jimjade.queries;

import com.jimjade.models.Guest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class JdbcGuests extends JdbcDaoSupport {

    public List<Guest> queryGuests(String query){
        String sql = "SELECT * FROM wedding.guests where ((upper(first_name) like ?) or (upper(last_name) like ?))";
        query = "%" + query.toUpperCase() + "%";
        return getJdbcTemplate().query(sql, new Object[]{query, query}, new BeanPropertyRowMapper(Guest.class));
    }

    public int saveGuest(Guest g){
        String sql = "update wedding.guests set attending=? where user_id=?";
        return getJdbcTemplate().update(sql, new Object[]{g.getAttending(), g.getUser_id()});
    }
}
