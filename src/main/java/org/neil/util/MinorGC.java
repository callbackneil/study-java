package org.neil.util;

/**
 * Created by zhangzhen on 2019/5/27.
 */
public class MinorGC {
    public static void main(String[] args) {
        int _1MB = 1024 * 1024;
//        byte[] object1,object2,object3,object4;
        byte[] object;
//        object1 = new byte[2*_1MB];
//        object2 = new byte[2*_1MB];
//        object3 = new byte[2*_1MB];
        while (true) {
            object = new byte[4 * _1MB];
        }
    }


}
