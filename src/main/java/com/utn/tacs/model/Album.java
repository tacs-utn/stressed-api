package com.utn.tacs.model;

public class Album {
    private String title;
    private String artist;
    private Integer year;

    public Album(String title, String artist, Integer year) {
        this.title  = title;
        this.artist = artist;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getYear() {
        return year;
    }


}
