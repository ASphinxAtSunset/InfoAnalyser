package com.spider.thread;

/**
 * Created by Gene on 2017/11/1.
 */
public class TestThread {
    public static void main(String[] args) {
        exForRunable er = new exForRunable(0);
        //er.run();

        exForThread et1 = new exForThread(0);
        et1.start();
        //et1.run();
        new Thread(er).start();
        new Thread(er).start();
        for(int i=0;i<10;i++) {
            System.out.println(i);
        }
    }
}



class exForRunable implements Runnable{
    public int count;
    public exForRunable(int count){
        this.count=count;
    }
    @Override
    public void run() {
        System.out.print("in exForRunable run  ier");
        System.out.println(++count);
    }

}


class exForThread extends Thread{
    public int count;
    public exForThread(int count){
        this.count=count;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++) {
            System.out.print("in thread run  itr");
            System.out.println(++count);
        }
    }
/*    @Override
    public void start(){
        System.out.print("in thread start  its");
        System.out.println(++count);
    }*/


}
