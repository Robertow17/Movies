package com.example.student238033.movies;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private String title, genre;
    private Integer photo_id, cover_id;
    private ArrayList<Integer> gallery;
    private ArrayList<Actor> actors;

    public Movie() {}

    public Movie(String title, String genre, Integer photo_id, Integer cover_id,ArrayList<Integer> gallery, ArrayList<Actor> actors) {
        this.title = title;
        this.genre = genre;
        this.photo_id=photo_id;
        this.cover_id=cover_id;
        this.gallery=gallery;
        this.actors=actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPhoto_id() { return photo_id; }

    public Integer getCover_id() { return cover_id; }

    public ArrayList<Integer> getGallery()
    {
        return gallery;
    }

    public ArrayList<Actor> getActors()
    {
        return actors;
    }
}
