package com.spider.experiment;

/**
 * Created by Gene on 2017/9/1.
 */
public class ClassA extends ClassB implements InterfaceA{

    @Override
    public void methodA() {
        System.out.println("A");
    }
/*    public void methodB(){
        System.out.println("B");
    }*/

    public static void main(String[] args) {
        ClassA cA = new ClassA();
        cA.methodC();
        cA.methodA();
    }
}
