package com.jimjade.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jimjade.**")
public class Wedding {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Wedding.class, args);
    }
}
