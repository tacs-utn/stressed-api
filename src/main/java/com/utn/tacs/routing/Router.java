package com.utn.tacs.routing;

import com.utn.tacs.resources.DiscResource;
import com.utn.tacs.model.error.WebApplicationException;
import com.utn.tacs.utils.Json;
import spark.servlet.SparkApplication;

import com.google.common.net.MediaType;
import org.apache.log4j.Logger;
import spark.ResponseTransformer;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import static spark.Spark.*;

/**
 * Created by alalbiero on 6/10/17.
 */
public class Router implements SparkApplication{

    private static final Logger LOG =  Logger.getLogger(Router.class);

    public static final String BASE_PATH = "";



    @Override
    public void init() {
        LOG.info("Initializing Router");

        after((request, response) -> {
            if (!response.raw().containsHeader("Content-Type")) {
                response.header("Content-Type", MediaType.JSON_UTF_8.toString());
            }
        });

        ResponseTransformer jsonTrans = o -> Json.toJsonString(o);


        get(BASE_PATH + "/albums/:artist", DiscResource::getAlbumsByArtistYearQueryString, jsonTrans);
        get(BASE_PATH + "/cacheSize", DiscResource::getCacheSize, jsonTrans);


        get("/health", (request, response) -> {
            response.status(HttpServletResponse.SC_OK);
            response.header("Content-Type", MediaType.PLAIN_TEXT_UTF_8.toString());
            return "ok";
        });

        exception(WebApplicationException.class, (e, request, response) -> {
            WebApplicationException wae = (WebApplicationException)e;
            response.status(wae.getStatusCode());

            HashMap<String, Object> map = new HashMap<>();
            map.put("code", wae.getStatusCode());
            map.put("msg", wae.getMessage());

            response.body(Json.toJsonString(map));
            response.header("Content-type", MediaType.JSON_UTF_8.toString());
        });

        exception(Exception.class, (e, request, response) -> {
            LOG.error("Unexpected error for " + request.uri() + "?" + request.queryString(), e);

            response.status(500);

            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 500);
            map.put("msg", e.getClass().getSimpleName() + " : " + e.getMessage());

            response.body(Json.toJsonString(map));
            response.header("Content-type", MediaType.JSON_UTF_8.toString());
        });
    }

}
