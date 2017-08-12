package com;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Created by Gene on 2017/8/12.
 */
public class TestSpider extends BreadthCrawler{


    public TestSpider(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);

    }

    public static void main(String[] args) throws Exception{
        /*设置保存爬取记录的文件夹*/
        TestSpider crawler=new TestSpider("Crawl",true);

        /*配置爬取合肥工业大学网站*/
        crawler.addSeed("http:/www.");
        //crawler.addRegex("http://.*hfut\\.edu\\.cn/.*");


        /*设置线程数*/
        crawler.setThreads(50);

        /*设置爬虫是否为断点爬取*/
        crawler.setResumable(false);

        /*设置代理服务器*/
        Proxy proxy=new Proxy(Proxy.Type.HTTP, new InetSocketAddress("14.18.16.67",80));
        //crawler.setProxy(proxy);

        /*设置User-Agent*/
//        crawler.setUserAgent("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:26.0) Gecko/20100101 Firefox/26.0");

        /*设置Cookie*/
//        crawler.setCookie("......");

        /*进行深度为5的爬取*/
        crawler.start(5);
    }
    /*在visit方法里定义自己的操作*/
    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        System.out.println("URL:"+page.getUrl());
        System.out.println("Content-Type:"+page.getResponse().getContentType());
        System.out.println("Code:"+page.getResponse().getContentType());
        System.out.println("-----------------------------");
    }

    @Override
    public HttpResponse getResponse(CrawlDatum crawlDatum)throws Exception{
        HttpRequest request = new HttpRequest(crawlDatum.url());
        //TODO What this
        String outputData = crawlDatum.meta("outputData");
        if (outputData != null) {
            request.setOutputData(outputData.getBytes("utf-8"));
        }
        //通过下面方式可以设置Cookie、User-Agent等http请求头信息
        request.setCookie("xxxxxxxxxxxxxx");
        request.setUserAgent("WebCollector");
        request.addHeader("xxx", "xxxxxxxxx");
    }
}
