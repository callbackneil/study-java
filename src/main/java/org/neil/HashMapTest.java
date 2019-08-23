package org.neil;

import java.util.HashMap;

/**
 * @author neil
 * @date 2019-08-21
 */
public class HashMapTest {

    public static void main(String[] args) {
        final HashMap<Integer,String> map = new HashMap();
        for (int i = 0; i < 100; i++) {
            final int j = i;
            new Thread(() -> {
                for (int i1 = j*100000+1; i1 < (j+1)*100000+1; i1++) {
                    map.put(i1,i1+"");
                }
            }).start();
        }

        for (Integer i : map.keySet()) {
            System.out.println(i);
        }

    }
}
