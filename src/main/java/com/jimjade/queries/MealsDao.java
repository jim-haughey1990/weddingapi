package com.jimjade.queries;

import com.jimjade.models.Meals;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class MealsDao extends JdbcDaoSupport {

    public List<Meals> getMeals(){
        String sql = "select * from wedding.Meals order by FIELD(course, 'Starter', 'Main', 'Desert')";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Meals.class));
    }
}
