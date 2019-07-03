package org.neil.util;

/**
 * @author neil
 * @date 2019-06-20
 */
public class 死循环检测 {

    public static void main(String[] args) {
        byte[] bytes = new byte[1024*1024*1];
        circulation(bytes,1);
    }

    public static void circulation(byte[] bytes,int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        byte[] bytes1 = new byte[1024 * 1024 * 5];
        System.out.println(i+1);
        circulation(bytes,i+1);
    }

}
