package com.controller;

<<<<<<< HEAD
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.service.OriginalDataService;
import com.service.impl.OriginalDataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

=======
>>>>>>> first module
/**
 * Created by Administrator on 2017/7/17.
 */
public class SpiderController {
    /**
     * allocate work
     */
<<<<<<< HEAD
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



=======
    public void allocateWork(){
        //allocate thread
        //control the visit url
        //begin fetcher(if fetcher fail, control the visit url)

        //begin parse
        //
>>>>>>> first module
    }
}
