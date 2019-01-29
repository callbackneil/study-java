package org.neil.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2018/11/11
 */
public class Test34 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("1");
        stringList2.add("2");
        stringList.removeAll(stringList2);
        System.out.println(stringList);
//        stringList2.add("3");
//        stringList2.add("3");
//        List<Integer> stringList3 = new ArrayList<>();
//        stringList3.add(1);
//        stringList3.add(2);
//        stringList3.add(3);

//        int i = 1001111;
//        Integer j = new Integer(1001111);
//        int k = 1001111;
//        Integer w = new Integer(1001111);
//
//        boolean a = i == j;
//        boolean b = k == j;
//        boolean c = i == k;
//        boolean d = w == j;
//        System.out.println(1);

    }
}
