package com.spider.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Gene on 2017/11/8.
 */
public class TestIter {
    public Map<String,String> map;

    public TestIter(Map<?,?> map){
        this.map = (Map<String, String>) map;
    }
    public TestIter(){
        map = new HashMap<>();
        map.put("aak","aav");
        map.put("bbk","bbv");
        map.put("cck","ccv");
    }
    public void methodA(){

    }

    public static void main(String[] args) {
        TestIter ti = new TestIter();
        Iterator<?> iter = ti.map.keySet().iterator();
        Iterator<?> iter1 = ti.map.values().iterator();
        Iterator<?> iter2 = ti.map.entrySet().iterator();
        TestIter.class.getResourceAsStream("");
        while (iter.hasNext()){
            System.out.println(iter.next());;
        }
        while (iter1.hasNext()){
            System.out.println(iter1.next());;
        }
        while (iter2.hasNext()){

            System.out.println(iter2.next());;
        }

    }


}
