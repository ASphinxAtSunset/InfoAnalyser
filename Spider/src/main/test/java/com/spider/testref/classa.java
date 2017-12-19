package com.spider.testref;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gene on 2017/10/24.
 */
public class classa {
    public static void main(String[] args) {
        String a = "aaaa",b = "bbbb";
        List<String> list = new ArrayList<String>();
        list.add(a);
        list.add(b);
        //classb.removeList(list);
        //System.out.println("removelist======"+list.get(0)+"+++++"+list.get(1));

        List<String> list1 = new ArrayList<String>();
        list1.add(a);
        list1.add(b);
        System.out.println("before swaplist======"+list1.get(0)+"+++++"+list1.get(1));
        classb.swapList(list1);
        System.out.println("swaplist======"+list1.get(0)+"+++++"+list1.get(1));


    }
}
