/*
package com.spider.controller;

import com.Spider;
import com.spider.service.OriginalDataService;
import com.spider.service.impl.OriginalDataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

*/
/**
 * Created by Administrator on 2017/7/17.
 *//*

public class SpiderController {
    */
/**
     * allocate work
     *//*

    private static final Logger logger = LoggerFactory.getLogger(SpiderController.class);

    private Spider spider;


    public void initializeSpider(){
        this.spider = new Spider("",true);

    }


    public static void main(String[] args) {
        SpiderController spiderController = new SpiderController();
        spiderController.start();
    }

    public void start(){
        try {
            spider.start(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 分配工作
     *//*

    public void allocateWork(){
        //新建一个webcollector

        //allocate thread
        //control the visit url
        //begin fetcher(if fetcher fail, control the visit url)
        //saveOriginalData
        OriginalDataService  ods = new OriginalDataServiceImpl();


        //begin parse
        //save parsed data



    }
}
*/
