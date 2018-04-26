package com.blog.core.utils;

import com.google.gson.Gson;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public class GsonUtils {

    private static final Gson gson = new Gson();

    public static String toJsonString(Object object){
        return object==null?null:gson.toJson(object);
    }
}
