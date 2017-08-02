package com.spider.controller;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Gene on 2017/8/1.
 */
public class SpiderSetting extends BreadthCrawler {
    private static final Logger logger = LoggerFactory.getLogger(SpiderSetting.class);

    public SpiderSetting(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        //若不同，替换配置文件
        //读取配置文件
    }


    public void initializeSpider(){
        //html源码获取(文件下载)
        //文件操作
        //html源码解析(数据清洗)
        //线程池
        //URL生成器(遍历器)
        //消息机制(各组件通信)
        /*start page*/
        this.addSeed("http://news.hfut.edu.cn/list-1-1.html");
        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
        this.addRegex("http://news.hfut.edu.cn/show-.*html");
        /*do not fetch jpg|png|gif*/
        this.addRegex("-.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
        this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {

    }
}
