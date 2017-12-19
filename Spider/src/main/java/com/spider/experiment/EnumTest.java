package com.spider.experiment;

/**
 * Created by Gene on 2017/9/1.
 */
public class EnumTest {
    public void printFruit(){
        Fruit f = Fruit.apple;
        System.out.println(f);
    }
    public static String choiseFruit(Fruit fruit){
        String f = "nothing";
        switch (fruit){
            case apple:f = "apple";break;
            case banana:f = Fruit.banana.toString();break;
            case orange:f = String.valueOf(Fruit.valueOf("orange"));break;
/*            case apple:
                System.out.println("a");
                break;
            case banana:
                System.out.println("b");
                break;
            case orange:
                System.out.println("c");
                break;*/
        }
        return f;
    }
    public static void main(String[] args) {
        String[] i = {"apple","banana","orange"};
        for (Fruit fruit:
             Fruit.values()) {
            System.out.println(fruit);
            System.out.println(EnumTest.choiseFruit(fruit));
        }

    }
}
