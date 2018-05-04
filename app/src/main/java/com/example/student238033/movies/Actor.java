package com.example.student238033.movies;

import java.io.Serializable;

public class Actor implements Serializable {
    private String name, age;
    private Integer photo_id;

    public Actor() {}

    public Actor(String name, String age, Integer photo_id ) {
        this.name = name;
        this.age = age;
        this.photo_id=photo_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }


    public Integer getPhoto_id() { return photo_id; }
}
