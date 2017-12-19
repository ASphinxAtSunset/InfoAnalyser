package com.spider.test;

import com.spider.experiment.ClassA;
import com.spider.experiment.InterfaceA;
import org.junit.Test;

/**
 * Created by Gene on 2017/9/1.
 */
public class TestCreate {
    @Test
    public void createObject(){
        ClassA classA = new ClassA();
        InterfaceA interfaceA = new ClassA();
        classA.methodA();
        interfaceA.methodA();

    }
}
