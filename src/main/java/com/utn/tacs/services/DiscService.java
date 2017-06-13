package com.utn.tacs.services;


import com.utn.tacs.model.Album;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by alalbiero on 6/13/17.
 */
public class DiscService {

    public static DiscService INSTANCE = new DiscService();
    private Map<String,ArrayList<Album>> dbByArtist = new HashMap<>();


    private DiscService() {
        init();
    }

    private void init() {
        ArrayList<Album> stingAlbums = new ArrayList<>();
        stingAlbums.add(new Album("Nothing like the Sun", "Sting", 1987));
        stingAlbums.add(new Album("Ten Summoner's Tales", "Sting", 1993));
        dbByArtist.put("Sting", stingAlbums);

        ArrayList<Album> megadethAlbums = new ArrayList<>();
        megadethAlbums.add(new Album("Rust in Peace", "Megadeth", 1990));
        megadethAlbums.add(new Album("Youthanasia", "Megadeth", 1994));
        dbByArtist.put("Megadeth", megadethAlbums);
    }

    public ArrayList<Album> getAlbums(String artistName) {
        ArrayList<Album> emptyResponse = new ArrayList<>();
        return dbByArtist.containsKey(artistName) ? dbByArtist.get(artistName) : emptyResponse;
    }
}