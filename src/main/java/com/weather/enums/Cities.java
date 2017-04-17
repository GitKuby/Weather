package com.weather.enums;

public enum Cities {
    WAW("Warszawa"),
    GDA("Gdańsk"),
    KRA("Kraków"),
    WRO("Wrocław"),
    POZ("Poznań"),
    LOD("Łódź"),
    KAT("Katowice");

    private String name;

    private Cities(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
