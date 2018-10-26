package com.utn.tacs.services;


import com.google.common.io.ByteStreams;
import com.utn.tacs.model.Album;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by alalbiero on 6/13/17.
 */
public class DiscService {

    public static DiscService INSTANCE = new DiscService();
    private Map<String, ArrayList<Album>> dbByArtist = new HashMap<>();


    private DiscService() {
        init();
    }

    private void init() {
        ArrayList<Album> stingAlbums = new ArrayList<>();
        stingAlbums.add(new Album("Nothing like the Sun", "Sting", 1987, readImage("/1.jpg")));
        stingAlbums.add(new Album("Ten Summoner's Tales", "Sting", 1993, readImage("/2.jpg")));
        dbByArtist.put("Sting", stingAlbums);

        ArrayList<Album> megadethAlbums = new ArrayList<>();
        megadethAlbums.add(new Album("Rust in Peace", "Megadeth", 1990, readImage("/1.jpg")));
        megadethAlbums.add(new Album("Youthanasia", "Megadeth", 1994, readImage("/1.jpg")));
        dbByArtist.put("Megadeth", megadethAlbums);
    }

    public ArrayList<Album> getAlbums(String artistName) {
        ArrayList<Album> emptyResponse = new ArrayList<>();
        return dbByArtist.containsKey(artistName) ? dbByArtist.get(artistName) : emptyResponse;
    }

    public byte[] readImage(String path) {
        try (InputStream stream = Album.class.getResourceAsStream(path)) {
            return ByteStreams.toByteArray(stream);
        } catch (Exception e) {
            return new byte[0];
        }
    }

}