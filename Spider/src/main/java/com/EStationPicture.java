package com;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;
import sun.security.provider.MD5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Gene on 2017/12/14.
 */
public class EStationPicture extends BreadthCrawler{

    File baseDir = new File("images");
    MessageDigest md5 =null;

    /**
     * 构造一个基于伯克利DB的爬虫
     * 伯克利DB文件夹为crawlPath，crawlPath中维护了历史URL等信息
     * 不同任务不要使用相同的crawlPath
     * 两个使用相同crawlPath的爬虫并行爬取会产生错误
     *
     * @param crawlPath 伯克利DB使用的文件夹
     * @param autoParse 是否根据设置的正则自动探测新URL
     */
    public EStationPicture(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //只有在autoParse和autoDetectImg都为true的情况下
        //爬虫才会自动解析图片链接
        addSeed("http://slide.news.sina.com.cn/c/slide_1_2841_225570.html#p=1");
        addRegex("http://slide.news.sina.com.cn/c/slide_1_2841_225570.html#p=.*");

    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String contentType = page.contentType();

        if(contentType!=null && contentType.startsWith("image")){
            String extensionName = contentType.split("/")[1];
            try{
                byte[] image = page.content();
                String fileName = String.format("%s.%s", md5.digest(image),extensionName);
                File imageFile = new File(baseDir,fileName);
                FileUtils.write(imageFile,image);
                System.out.println("保存图片"+page.url()+"到"+imageFile.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        EStationPicture esp = new EStationPicture("a",true);
        esp.setResumable(true);
        esp.start(2);
    }
}
