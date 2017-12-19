package com.spider.test;

import com.google.gson.JsonArray;
import com.spider.utils.JsonUtil;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by Gene on 2017/8/30.
 */
public class TestJsonUtil {
    @Test
    public void testJson() {
        String jsonContruts;
        JSONObject jo = new JSONObject();
        //测试是否为引用
        jsonContruts = JsonUtil.becomeJson(jo, "title1", "content1", "tag1");
        System.out.println(jsonContruts);
        System.out.println(jo);
        jsonContruts = JsonUtil.becomeJson(jo, "title2", "content2", "tag2");
        System.out.println(jsonContruts);
        System.out.println(jo);

    }
}
