package com.spider.utils;

//import org.apache.xpath.SourceTree;
//import org.openqa.selenium.By;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static javafx.scene.input.KeyCode.F;

/**
 * Created by Gene on 2017/8/29.
 */
public class FileUtil {


    public void createFile(String fileName,String data) throws IOException {
/*        File saveFile = new File("."),
                saveFile1 = new File(".saveFile1.txt"),
                saveFile2 = new File("../saveFile2.txt"),
                saveFile3 = new File("../ttt/saveFile3.txt"),
                saveFile4 = new File("../ttt/saveFile4.txt");

        FileInputStream fis = new FileInputStream("");
        FileOutputStream fos = new FileOutputStream("");
        if(!saveFile.exists()){
            saveFile.createNewFile();
            System.out.println("succ to create File");
        }
        if(!saveFile1.exists()){
            saveFile1.createNewFile();
            System.out.println("succ to create File1");
        }
        if(!saveFile2.exists()){
            saveFile2.createNewFile();

            System.out.println("succ to create File2");
        }
        if(!saveFile3.exists()){
            saveFile3.createNewFile();
            System.out.println("succ to create File3");
        }
        if(!saveFile4.exists()){
            saveFile4.mkdir();
            saveFile4.createNewFile();
            System.out.println("succ to create File4");
        }*/

    }

    public static void read(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(
                new File("saveReader.txt").getAbsoluteFile()
        ));

    }



    public static void write(String data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(
                new File("saveReader1.txt").getAbsoluteFile()
        ));
        out.print(data);
        out.close();
    }

    public static void randomAccess() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile("a","");
    }

    public static void channelCopy(String data) throws IOException {
        FileChannel
                in = new FileInputStream("./saveReader1.txt").getChannel(),
                out = new FileOutputStream("saveReader.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(in.read(buffer)!=-1){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }

    }


    public static void fileChannel() throws IOException {

        // Write a file
        FileChannel fc1 = new FileOutputStream("./data.txt").getChannel();
        FileChannel fc2 = new FileOutputStream("data.txt").getChannel();
        FileChannel fc = new FileOutputStream("../data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text4 ".getBytes()));
        fc.close();
        FileChannel fcn = FileChannel.open(Paths.get("../data.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE);
        ByteBuffer buff1 = ByteBuffer.allocate(1024);
        int nread = fcn.read(buff1);
        System.out.println(nread);
        //       buff1.flip();
//        fc.read(buff1);


        // Add to the end of the file;
        //fc = new RandomAccessFile("data.txt","rw").getChannel();
        fc = new RandomAccessFile("data.txt","rw").getChannel();
        fc.position(fc.size());
        fc.read(buff1);
        buff1.flip();
        while(buff1.hasRemaining()){
            System.out.println("buff1====="+(char)buff1.get());
        }
        fc.write(ByteBuffer.wrap("Some more".getBytes()));

        fc.close();

        // Read the file:
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        fc.read(buff);
        //flio作用
        buff.flip();
        while(buff.hasRemaining()){
            System.out.println((char) buff.get());

        }
    }


    public static void readFile(String fileName){
        try  {
            FileChannel fileChannel = new FileInputStream(fileName).getChannel();

            System.out.println("文件长度为————"+fileChannel.size());
            long fileSize = fileChannel.size();
            Charset charset= Charset.forName("UTF-8");
            ByteBuffer byteBuffer;
//            判断文件大小，大于int值会导致ByteBuffer缓冲区大小异常
            /*if (fileChannel.size()<Integer.MAX_VALUE){
                byteBuffer = ByteBuffer.allocate((int) fileSize);
                fileChannel.read(byteBuffer);
            }else{
                byteBuffer = ByteBuffer.allocate(2147483647);
                fileChannel.read(byteBuffer,2147483647);
            }*/


            byteBuffer = ByteBuffer.allocate((int) fileChannel.size()-1000);
            fileChannel.read(byteBuffer);
            /*作用？
            byteBuffer.put();*/
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                /*可以去掉
                CharBuffer charBuffer = charset.decode(byteBuffer);*/
                /*另一种输出char的方法
                System.out.print((char)byteBuffer.get());*/
                System.out.println(charset.decode(byteBuffer));
            }
//          此处有一问题，间断的字节会使一个中文字符变得不可识别
            byteBuffer.clear();
            fileChannel.read(byteBuffer);
            byteBuffer.flip();
            System.out.println("----------------------------");
            while(byteBuffer.hasRemaining()){
                System.out.println(charset.decode(byteBuffer));
            }
           /* System.out.println((byte)'\n');
            int p=0;
            while(byteBuffer.hasRemaining()){
                //if ()
                System.out.print((char)byteBuffer.get());
                p=byteBuffer.position();
                byteBuffer.position(p-1);
                System.out.print((byte)byteBuffer.get());
                System.out.println("++++++++++++++++++"+byteBuffer.position());
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 使用通道写文件
     * @param fileName
     */
    public static void randomAccessWriteFile(String fileName, String content){
        try  {
            Charset charset= Charset.forName("UTF-8");
            FileChannel fileChannel = new RandomAccessFile(fileName,"rw").getChannel();
            ByteBuffer byteBuffer =  ByteBuffer.wrap(content.getBytes());
            //byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                //System.out.println((char) byteBuffer.get());
                System.out.println(charset.decode(byteBuffer));
            }
            //byteBuffer.flip();
            //System.out.println(byteBuffer);

            fileChannel.read(byteBuffer);
            System.out.println(fileChannel.position());
            System.out.println(fileChannel.size());
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            fileChannel.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void outputStreamWriteFile(String fileName, String content){
        Charset charset= Charset.forName("UTF-8");
        try {
            FileChannel writeChannel = new FileOutputStream(fileName,true).getChannel();
            ByteBuffer byteBuffer =  ByteBuffer.wrap(content.getBytes());
            writeChannel.write(byteBuffer);
            writeChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
