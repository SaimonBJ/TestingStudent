package com.jetpack.model;

import java.io.Serializable;

/**
 * Class admin
 *
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */

public class Users implements Serializable {

    /**Unique indicator for serializable class*/
    private static final long serialVersionUID = 1L;
    /**ID users*/
    private int id;
    /**Name users*/
    private String name;

    /**Empty constructor*/
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
