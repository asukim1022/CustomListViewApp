package com.asukim.customlistview;

public class User {

    private int icon;
    private String name;

    public User(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }
}