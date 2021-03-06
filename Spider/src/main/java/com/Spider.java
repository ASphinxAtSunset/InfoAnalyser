package com;

import cn.edu.hfut.dmic.webcollector.crawldb.DBManager;
import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BerkeleyDBManager;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.fetcher.Executor;
import cn.edu.hfut.dmic.webcollector.util.CharsetDetector;
import com.spider.vo.ConditionVo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Gene on 2017/7/28.
 * 控制整体程序的运行
  * 该教程为WebCollector内核使用教程
 * 内核适合需要深度定制http请求的开发者使用
 * 普通业务可使用已封装好的BreadthCrawler等插件
 *
 * 一个爬取器Crawler需要定制一个DBManager和一个Executor
 * DBManager用于维护爬取历史，以做到去重、断点爬取等功能
 * Executor用于定制每次的爬取和抽取操作
 *
 * 本教程利用HttpClient定制http请求，并使用伯克利DB维护爬取历史
 */
public class Spider {
    private static final Logger logger = LoggerFactory.getLogger(Spider.class);

    private ConditionVo conditionVoObject;
    private String  conditionVoJson;


    /*    //传递对象
        public Spider(ConditionVo conditionVo){
            this.conditionVoObject = conditionVo;
        }
        //模块间以json传递参数（需解析）
        public Spider(String conditionVoJson){
            this.conditionVoJson = conditionVoJson;
        }
        //使用默认配置（需要读取配置文件）
        public Spider(){

        }*/
    public static void main(String[] args) throws Exception {
        //定制executor
        Executor executor = new Executor() {
            @Override
            /*execute应该包含对一个页面从http请求到抽取的过程
              如果在execute中发生异常并抛出，例如http请求超时，
              爬虫会在后面的任务中继续爬取execute失败的任务。
              如果一个任务重试次数太多，超过Config.MAX_EXECUTE_COUNT，
              爬虫会忽略这个任务。Config.MAX_EXECUTE_COUNT的值可以被修改*/
            public void execute(CrawlDatum crawlDatum, CrawlDatums crawlDatums) throws Exception {
                //TODO what
                CloseableHttpClient client = HttpClients.createDefault();
                String url = crawlDatum.url();
               try {
                   //TODO what
                   HttpGet get = new HttpGet(url);
                   HttpResponse response = client.execute(get);
                   //TODO WHAT
                   HttpEntity entity = response.getEntity();
                /*利用HttpClient获取网页的字节数组,通过CharsetDetector判断网页的编码 */
                   byte[] content = EntityUtils.toByteArray(entity);
                   String charset = CharsetDetector.guessEncoding(content);
                   String html = new String(content, charset);
                /*利用Jsoup解析网页，并执行抽取等操作*/
                   Document doc = Jsoup.parse(html, url);
                   logger.info("the page's title:{}", doc.title());
                   Elements links = doc.select("a[href]");
                   for (int i = 0; i < links.size(); i++) {
                       Element link = links.get(i);
                    /*抽取超链接的绝对路径*/
                       String href = link.attr("abs:href");
                    /*将新链接加入后续任务，这里只加入以http://news.hfut.edu.cn/开头的链接
                          用户不用考虑去重的问题，爬虫内核会自动去重*/
                       if (href.startsWith("http://www.yidianzixun.com/channel/")) {
                           crawlDatums.add(href);
                       }
                   }
               }finally {
                   client.close();
               }
            }
        };
        /*基于伯克利DB的DBManager   BerlekerDB*/
        //TODO where is this 'crawl'
        DBManager dbManager = new BerkeleyDBManager("crawl");
        /*构建一个crawler*/
        Crawler crawler = new Crawler(dbManager,executor);
        /*线程数*/
        crawler.setThreads(20);
        crawler.addSeed("");


        crawler.setResumable(true);
        crawler.start(3);
    }

    /**
     * 设置代理
     */
    private static void setProxy(){}

    /**
     * 自定义http请求
     */
    private static void setHttpRequest(){}

    /**
     * 爬取页面类型(html?JS?photo?)
     */
    private static void setPageKind(){}

    /**
     * 设置文件存放地址(图片，原始数据等)
     */
    private static void savePath(String path){}




    public cn.edu.hfut.dmic.webcollector.net.HttpResponse getResponse(CrawlDatum crawlDatum) throws Exception {
        HttpRequest request = new HttpRequest(crawlDatum.url());

        return request.response();
    }
}
