package com.spider.testref;

import java.util.List;

/**
 * Created by Gene on 2017/10/24.
 */
public class classb {
    /**
     * remove0 后 后面元素是否会向前递进
     * @param list
     */
    public static void removeList(List<String> list){
        try {
            String a = list.get(0);
            list.remove(0);
            String b = list.get(1);
            System.out.println(b);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void swapList(List<String> list){
        try {
            String a = list.get(0);
            String b = list.get(1);
            list.remove(0);
            list.add(0,b);
            list.add(1,a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void swapString(String a,String b){
        String c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);
    }



}
