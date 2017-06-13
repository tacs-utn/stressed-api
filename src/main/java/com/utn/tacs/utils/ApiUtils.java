package com.utn.tacs.utils;

import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by alalbiero on 6/10/17.
 */
public class ApiUtils {


    public static String[] trim(String [] array){
        for (int i = 0; i < array.length; i++){
            array[i] = array[i].trim();
        }
        return array;
    }

    public static Boolean isEmpty(String string) {
        return string == null || "".equals(string.trim());
    }

    public static Boolean isEmpty(String[] stringArray) {
        return stringArray == null || stringArray.length == 0;
    }

    public static Boolean isEmpty(Integer integerValue) {
        return integerValue == null;
    }

    public static Boolean isEmpty(Long longValue) { return longValue == null; }


    public static boolean isEmpty(Collection<?> collection) {
        return collection == null ? Boolean.TRUE : Integer.valueOf(0).equals(collection.size());
    }

    public static boolean isEmpty(Object[] objects) {
        return objects == null ? Boolean.TRUE : Integer.valueOf(0).equals(objects.length);
    }

    public static boolean isEmpty(byte[] objects) {
        return objects == null ? Boolean.TRUE : Integer.valueOf(0).equals(objects.length);
    }

    public static boolean isEmptyOrZero(Long longValue) { return longValue == null || longValue == 0; }

    public static boolean mapContains(Map<String, Object> map, String field){
        return !(map == null || map.get(field) == null);
    }
}
