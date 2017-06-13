package com.utn.tacs.model;

import com.utn.tacs.utils.ApiUtils;

/**
 * Created by alalbiero on 6/10/17.
 */
public class CustomKey {
    private String artist;
    private Integer year;

    public CustomKey(String artist, String year){
        setArtist(artist);
        try{
            setYear(Integer.valueOf(year));
        }catch(NumberFormatException nEx){
            //TODO throw this exception
        }

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isEmpty(){
        return ApiUtils.isEmpty(getArtist()) || (ApiUtils.isEmpty(getYear()));
    }
}
