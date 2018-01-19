package com.jimjade.models;

public class Meals {
    private int meal_id;
    private String course;
    private String meal_desc_1;
    private String Meal_desc_2;

    public int getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(int meal_id) {
        this.meal_id = meal_id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMeal_desc_1() {
        return meal_desc_1;
    }

    public void setMeal_desc_1(String meal_desc_1) {
        this.meal_desc_1 = meal_desc_1;
    }

    public String getMeal_desc_2() {
        return Meal_desc_2;
    }

    public void setMeal_desc_2(String meal_desc_2) {
        Meal_desc_2 = meal_desc_2;
    }
}
