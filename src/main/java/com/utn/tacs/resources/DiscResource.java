package com.utn.tacs.resources;

import com.utn.tacs.model.CustomKey;
import com.utn.tacs.model.Album;
import com.utn.tacs.model.error.WebApplicationException;
import com.utn.tacs.services.DiscService;
import org.apache.log4j.Logger;
import spark.Request;
import spark.Response;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alalbiero on 6/10/17.
 */
public class DiscResource {

    private static final Logger LOG = Logger.getLogger(DiscResource.class);
    private static Map<CustomKey, ArrayList<Album>> cache = new HashMap<>();


    //@Trace(dispatcher = true, metricName = "Api/Resource/GetSongByArtist")
    public static Object getAlbumsByArtistYearQueryString(Request request, Response response) throws Exception {
        response.header("Content-Type", "application/json");

        String artist = request.params(":artist");
        String year = request.queryParams("year");
        CustomKey key = new CustomKey(artist, year);

        if (key.isEmpty()) {
            throw new WebApplicationException(HttpServletResponse.SC_BAD_REQUEST, "Please add artist and year parameters");
        }
        response.status(HttpServletResponse.SC_OK);

        if(cache.containsKey(key)){
            return cache.get(key);
        }else{
            ArrayList<Album> albumsByYear= new ArrayList<>();
            ArrayList<Album> artistAlbums = DiscService.INSTANCE.getAlbums(key.getArtist());

            for(Album artistAlbum : artistAlbums){
                if(artistAlbum.getYear().equals(key.getYear())){
                    albumsByYear.add(artistAlbum);
                }
            }
            cache.put(key, albumsByYear);
            return albumsByYear;
        }

    }



}
