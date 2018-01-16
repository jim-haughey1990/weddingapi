package com.jimjade.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DateControllerTest {

    @Test
    public void getCountDown() {
        DateController c = new DateController();
        assert(null != c.getCountDown());
    }
}