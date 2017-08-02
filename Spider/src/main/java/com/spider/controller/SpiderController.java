package com.spider.controller;

import com.spider.service.OriginalDataService;
import com.spider.service.impl.OriginalDataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/7/17.
 */
public class SpiderController {
    /**
     * allocate work
     */
    private static final Logger logger = LoggerFactory.getLogger(SpiderController.class);




    public void initializeSpider(){


    }

    public static void main(String[] args) {

    }

    /**
     * 分配工作
     */
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
