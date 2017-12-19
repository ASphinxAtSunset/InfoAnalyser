package com.utils;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Gene on 2017/8/11.
 * 配置Config
 * 数据源为  配置文件  命令行   SpiderWeb
 */
public class ConfigUtil {

    private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

    private static Config localConfig = null;

    public static void loadConfig() throws Exception{
        File confiurationFile = new File("application.conf");
        String path = confiurationFile.getPath();
        try{
            path = confiurationFile.getCanonicalPath();
            System.out.println(path);
            logger.info("load config file:{}",path);

            ConfigUtil.load();

        }catch (Exception e){
            logger.info("load config file:{}",path);
        }
        logger.info("load conf file: application.conf");
        ConfigUtil.load();
    }

    private static void load(String path){
        localConfig = ConfigFactory.parseFile(new File(path));
        System.out.println(localConfig);
        System.out.println(1);
    }
    public static Config getConfig(String key){
        //TODO 将得到的String转换成Config
        //return ConfigFactory.parseReader(new StringReader(value));
        return localConfig.getConfig(key);
    }



    private static void load(){
        localConfig = ConfigFactory.load();
    }




}
