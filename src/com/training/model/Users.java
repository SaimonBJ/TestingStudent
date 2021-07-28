package com.training.model;

public class Users {

    private int id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Users(int id, String name){
        this.id = id;
        this.name = name;
    }
}
