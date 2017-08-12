package com.spider.controller;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.json.Cookie;
import org.json.JSONObject;
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
    public static void readConf(){

    }

    @Override
    public HttpResponse getResponse(CrawlDatum crawlDatum)throws Exception{

        JSONObject json = new JSONObject("");
        HttpRequest request = new HttpRequest(crawlDatum.url());
        json  = Cookie.toJSONObject("");
        //自定义请求头
        //request.setCookie(json.toString());
        request.setUserAgent("");
        request.addHeader("","");
        return request.response();
    }

    public void initializeSpider(){


        //配置时间间隔
        //表单填写

        //html源码获取(文件下载)
        //文件操作
        //html源码解析(数据清洗)
        //线程池
        //URL生成器(遍历器)
        //消息机制(各组件通信)
        /*start page*/
        //this.addSeed("http://news.hfut.edu.cn/list-1-1.html");
        //正则可以重复添加
        //正则分为正正则和反正则
        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
        //this.addRegex("http://news.hfut.edu.cn/show-.*html");
        /*do not fetch jpg|png|gif*/
        //this.addRegex("-.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
        //this.addRegex("-.*#.*");
        //自动解析，抽取网页中符合的url作为后续任务
        this.autoParse=true;

    }

    @Override
    /**
     * 对页面的操作
     * 完成功能：
     * @1 获取页面文字等数据，title content转成json
     *
     * @2 获取页面url加入
     */
    public void visit(Page page, CrawlDatums crawlDatums) {
        page.url();
    }
}
