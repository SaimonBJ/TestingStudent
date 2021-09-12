package com.JetPack.Model;

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

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'';
    }
}
