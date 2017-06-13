package com.utn.tacs.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by alalbiero on 6/10/17.
 */
public class Json {


    private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    public static String toJsonString(Object o) {
        return GSON.toJson(o);

    }

    public static Map<String, Object> fromJsonToMap(String json){
        try {
            Type type = new TypeToken<Map<String, Object>>() {
            }.getType();
            return GSON.fromJson(json, type);
        }catch (Exception e){
            return null;
        }
    }

    public static List<Object> fromJsonToList(String json){
        try {
            Type type = new TypeToken<List<Object>>() {
            }.getType();
            return GSON.fromJson(json, type);
        }catch(Exception e){
            return null;
        }
    }


    public static <T> T fromJson(String j, Type t) {
        return GSON.fromJson(j, t);
    }
}
