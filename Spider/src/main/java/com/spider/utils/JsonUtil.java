package com.spider.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Gene on 2017/8/30.
 */
public class JsonUtil {
    private static Date date = new Date();
    private static int count = 1;
    public static String becomeJson(JSONObject jsonObject,String title,String content,String tag){

        String json;
        JsonElement je = new JsonArray();
        JSONObject node = new JSONObject();

        node.put("nodeTitle",title);
        node.put("content",content);
        //node.put("tag",tag);
        jsonObject.put("news_"+count,node);
        count++;
        //System.out.println(node);
        System.out.println(jsonObject);
        return jsonObject.toString();
    }
}
