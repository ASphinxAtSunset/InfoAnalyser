package com.utils;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Gene on 2017/8/11.
 */
public class ConfigUtil {

    private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

    private static Config localConfig = null;

    public static void loadConfig() throws Exception{
        File confiurationFile = new File("application.conf");
        String path = confiurationFile.getPath();
        try{
            path = confiurationFile.getCanonicalPath();
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
    }


    private static void load(){
        localConfig = ConfigFactory.load();
    }




}
