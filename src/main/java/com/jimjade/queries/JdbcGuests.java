package com.jimjade.queries;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class JdbcGuests extends JdbcDaoSupport {

    public List<String> queryGuests(String query){
        String sql = "SELECT concat(title, ' ', first_name, ' ', last_name) as name FROM wedding.guests " +
                " where ((upper(first_name) like ?) or (upper(last_name) like ?))";
        query = "%" + query.toUpperCase() + "%";
        return getJdbcTemplate().queryForList(sql, new Object[]{query, query}, String.class);
    }
}
