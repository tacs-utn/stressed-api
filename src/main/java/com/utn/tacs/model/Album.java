package com.utn.tacs.model;

import java.io.*;

public class Album implements Serializable {


    private String title;
    private String artist;
    private Integer year;
    private byte[] cover;

    public Album(String title, String artist, Integer year, byte[] cover) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.cover = cover;
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

    public byte[] getCover() {
        return cover;
    }

    public Album deepClone() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (Album) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
