package com.spider.exception;

import org.apache.xalan.templates.OutputProperties;

import java.io.*;
import java.util.Properties;

/**
 * Created by Gene on 2017/11/8.
 */
public class NeedBackException  extends Exception{
    //根据
    private String errorCode;
    public NeedBackException(){
        super.printStackTrace();
    }

    public NeedBackException(String errorMsg){
        super(errorMsg);

    }
}
