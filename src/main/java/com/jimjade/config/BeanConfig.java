package com.jimjade.config;

import com.jimjade.queries.JdbcGuests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BeanConfig {

    @Autowired
    DataSource ds;

    @Bean
    public JdbcGuests getGuestsDao(){
        JdbcGuests gdao = new JdbcGuests();
        gdao.setDataSource(ds);
        return gdao;
    }
}
