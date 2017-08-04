package com;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.spider.vo.ConditionVo;

/**
 * Created by Gene on 2017/7/28.
 * 控制整体程序的运行
 */
public class Spider extends BreadthCrawler {


    private ConditionVo conditionVoObject;
    private String  conditionVoJson;

    public Spider(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
    }

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
    public static void main(String[] args) {
        //获取消费者

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

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        //定制vistor， page是页面
    }
}
