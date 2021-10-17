package com.JetPack.Model;

import java.io.Serializable;

public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    public Users() {

    }

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
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
