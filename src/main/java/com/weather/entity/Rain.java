package com.weather.entity;

public class Rain {

    private String h3h;

    public String get3h() {
        return h3h;
    }

    public void set3h(String h3h) {
        this.h3h = h3h;
    }

    @Override
    public String toString() {
        return "ClassPojo [h3h = " + h3h + "]";
    }
}
