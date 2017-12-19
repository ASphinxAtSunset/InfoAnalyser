package com.spider.test;

import com.spider.utils.FileUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by Gene on 2017/8/29.
 */
public class TestFileUtil {
    private static final Logger logger = LoggerFactory.getLogger(TestFileUtil.class);


    @Test
    public void testFileUtil() throws IOException {
        FileUtil fu = new FileUtil();
        fu.createFile("aaa","aaa");

    }

    @Test
    public void testFileRead() throws IOException{
        FileUtil.write("aaaaaaaaaaaa" +
                "bbbbbbbbbbbbbbb" +
                "ccccccccccccccc");

    }
    @Test
    public void testFileChannel() throws IOException {
        FileUtil.channelCopy("");
    }


    @Test
    public void testReadFile(){
//        FileUtil.readFile("data.txt");
        FileUtil.readFile("saveFile2.txt");
    }


    @Test
    public void writeFile(){
        FileUtil.outputStreamWriteFile("joker.txt","啊啊啊啊啊");
    }

}
