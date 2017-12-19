package com.spider.test;

import com.typesafe.config.Config;
import com.utils.ConfigUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Gene on 2017/8/18.
 */
public class TestReadConfig {
    private static final Logger logger = LoggerFactory.getLogger(TestReadConfig.class);
    public TestReadConfig(){}
    @Test
    public void readConfig(){

        try {
            ConfigUtil.loadConfig();
            Config value = ConfigUtil.getConfig("spider-necessary");
            String  valuesavepackage =  value.getString("savepackage");
            String valuethread = value.getString("thread");
            logger.info("保存路径 : "+valuesavepackage);
            logger.info("线程数 : "+valuethread);
            logger.info("配置文件读取形式 : "+value.toString());
            System.out.println(valuesavepackage);
            System.out.println(valuethread);
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
