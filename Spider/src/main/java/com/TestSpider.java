package com;

import cn.edu.hfut.dmic.webcollector.fetcher.NextFilter;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
//import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import com.model.KeyCount;
import com.spider.utils.FileUtil;
import com.spider.utils.JsonUtil;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.*;

/**
 * Created by Gene on 2017/8/12.
 */
public class TestSpider extends BreadthCrawler{
    private static JSONObject jo = new JSONObject();
    public static int tempPageCount=0;
    public static File saveNews;
    public static final String suojin="----";
    public static Map<String,KeyCount> keyMap = new HashMap<String,KeyCount>();
    private String duplicateContent="";
    private Map<String,Set<String>> contentClass = new HashMap<String,Set<String>>();
    public static final Logger logger = LoggerFactory.getLogger(TestSpider.class);

    public TestSpider(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
       /* addSeed(new CrawlDatum("http://www.yidianzixun.com/")
                .meta("method", "POST"));*/
                //.meta("outputData", "id=a"));
        /*addSeed(new CrawlDatum("http://www.B.com/index.php")
                .meta("method", "POST"));*/
       /* addSeed(new CrawlDatum("http://www.yidianzixun.com/")
                .meta("method", "GET"));*/
       //addSeed("http://news.sina.com.cn");
        // addSeed("http://news.sina.com.cn/z/col_ent/");
        addSeed("http://ent.sina.com.cn/","kind");
       //addRegex("http://news.sina.com.cn/.*");
       //addSeed("http://news.sina.com.cn/c/nd/2017-09-18/doc-ifykywuc6667944.shtml");
    }

    public static void main(String[] args) throws Exception{
        /*设置保存爬取记录的文件夹*/
        TestSpider crawler = new TestSpider("json_crawler", true);
        /*配置爬取合肥工业大学网站*/
        //crawler.addSeed("http://www.yidianzixun.com/");
        //crawler.addRegex("http://.*hfut\\.edu\\.cn/.*");

        /*设置线程数*/
        crawler.setThreads(50);

        /*设置爬虫是否为断点爬取*/
        crawler.setResumable(false);

/*        crawler.setNextFilter(new NextFilter() {
            @Override
            public CrawlDatum filter(CrawlDatum nextItem, CrawlDatum referer) {
                if(nextItem.matchUrl("http://news.sina.com.cn/.*shtml")){
                    nextItem.type("content");
                    return nextItem;
                }else{
                    return null;
                }
            }
        });*/
        /*设置代理服务器*/
        //Proxy proxy=new Proxy(Proxy.Type.HTTP, new InetSocketAddress("14.18.16.67",80));
        //crawler.setProxy(proxy);

        /*设置User-Agent*/
//        crawler.setUserAgent("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:26.0) Gecko/20100101 Firefox/26.0");

        /*设置Cookie*/
//        crawler.setCookie("......");
        crawler.setTopN(100);
        /*进行深度为5的爬取*/
        crawler.start(3);
        System.out.println(jo);
    }
    /*在visit方法里定义自己的操作*/
    @Override
    public void visit(Page page, CrawlDatums next) {
        logger.info("in spider visit page {}",page.url());
        //next.add(page.links("a"));
        //System.out.println("URL:"+page.url());
        System.out.println("Content-Type:"+page.response().contentType());
        System.out.println("Code:"+page.response().contentType());
        System.out.println("-----------------------------");
        String pageStr = page.html();
        //System.out.println(pageStr);
        Document doc = Jsoup.parse(pageStr);
        //doc.select()
        Elements content = doc.getAllElements();
        //System.out.println(content);
        Set<String> set = new HashSet<String>();
        System.out.println(page.select(".ul_list1").text());
        FileUtil.outputStreamWriteFile("新闻.txt", page.select("h1[id=artibodyTitle]").text()+"\r\n");
        FileUtil.outputStreamWriteFile("新闻.txt", page.select("div[id=articleContent]").text()+"\r\n");
        if(page.matchType("kind")){

            System.out.println("selector+class+a================="+page.select(".item a").text());
            System.out.println("selector+a======================="+page.select("a").text());
            System.out.println("links+a=========================="+page.links("a"));
            System.out.println("links============================"+page.links());
            System.out.println("links+class+a===================="+page.links(".item a "));
            Links links = page.links(".item a ");
            next.add(links,"info");
        }else if (page.matchType("articleList")){

        }else if (page.matchType("info")){
            System.out.println("--------------------文章标题--------------------");
            System.out.println(page.select("h1[id=artibodyTitle]").text());
            System.out.println("++++++++++++++++++++文章内容++++++++++++++++++++");
            System.out.println(page.select("div[id=articalContent]").text());
            System.out.println(page.select(".articalContent").text());
            System.out.println(page.select(".content").text());
            StringBuilder jsonContentStr = new StringBuilder();
            if (page.select(".content").text()!=""){
                jsonContentStr.append(page.select(".content").text());
            }else if (page.select(".articalContent").text()!=""){
                jsonContentStr.append(page.select(".articalContent").text());
            }else if (page.select("div[id=articalContent]").text()!=""){
                jsonContentStr.append(page.select("div[id=articalContent]").text());
            }
            if(jsonContentStr.toString()!=""&&null==jsonContentStr)
            JsonUtil.becomeJson(jo,"标题",jsonContentStr.toString(),"");
        }


        //遍历所有元素
        for (Element e:content
             ) {
            //System.out.println("输出连接value------------"+e);
            //String className = e.className();
            //System.out.println("输出className------------"+className);
            String nodeName = e.nodeName();
            //System.out.println("输出nodeName------------"+nodeName);
            //String tagName = e.tagName();
            //System.out.println("输出tagName------------"+tagName);
            /**
             * 该元素包含的的class
             */
            set.addAll(e.classNames());
            //System.out.println(e.getElementsByAttribute("articleContent"));



            //duplicateContent="";
        }
        //每次循环是   className
        //----------------------------------------------------------------------DOWN
       for (String className1:
                set ) {
            //获取className后的内容
            //String title=page.select("h1>span").first().text();
            //eg:String score=page.select("strong.ll.rating_num").first().text();
                if(null!=page.select("div[class="+className1+"]")){
                    //String divClassFirst = page.select("div[class="+className1+"]").first().text();
                    //System.out.println("divClassFirst---------"+divClassFirst);
                }
            /**
             * 得到的element 中有内容，比较内容。相同
             */
            String divClass = page.select("div[class="+className1+"]").text();
            if(!"".equals(divClass)&&null!=divClass){
                //System.out.println("print className first==========="+className1);
               // System.out.println("nest print content==========="+divClass);

            }
            if (null!=divClass&&!"".equals(divClass)){
                /**
                 * 得到div中的
                 */
                if(divClass.length()!=0){
                    //如果已经存在该内容，将目前class放入修饰该内容的class 列表中
                    if(contentClass.containsKey(divClass)){
                        contentClass.get(divClass).add(className1);
                    }else{
                        Set<String> classSet = new HashSet<String>();
                        classSet.add(className1);
                        contentClass.put(divClass,classSet);
                    }
                    //设临时变量存储class中的值。若第一次访问该class
                    if(!duplicateContent.equals(divClass)){
                        duplicateContent=divClass;
                        if(!"".equals(divClass)||null!=divClass){}
                            //System.out.println("divClass内容---------"+divClass);
                    }else if (duplicateContent.equals(divClass)){
                        //System.out.println("------------------------------------------------------------");
                        continue;
                    }else{
                            //System.out.println("divClass内容---------"+divClass);
                        }
                }

                if (keyMap.containsKey(className1)){
                    keyMap.get(className1).count++;
                }else {
                    //若不包含，
                    KeyCount key = new KeyCount();
                    key.className=className1;
                    keyMap.put(className1,key);
                }

            }
        }

        //----------------------------------------------------------------------UP
        //如果已经存在该内容，将目前class放入修饰该内容的class 列表中
        //----------------------------------------------------------------------DOWN
        //TODO
/*        for (Map.Entry<String,Set<String>> map :
                contentClass.entrySet()) {
            System.out.println("内容================================"+map.getKey());
            for (String classes:
                 map.getValue()) {
                System.out.println("类================================"+classes);
            }
        }*/
        //TODO
        //----------------------------------------------------------------------UP
        File tempPage = new File("tempPage"+tempPageCount);
        tempPageCount++;
/*        for (Map.Entry<String, KeyCount> map:
                keyMap.entrySet()) {
            System.out.println("本页面包含class=================="+map.getValue().className);
            System.out.println("该class数目count=================="+map.getValue().count);

        }*/

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
        //request.setCookie("xxxxxxxxxxxxxx");
        request.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");
        //request.addHeader("xxx", "xxxxxxxxx");
        return request.response();
    }
    private void parseNestClass(){

    }
}
