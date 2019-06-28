package org.neil.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangzhen on 2019/6/19.
 */
public class OOMTest1 {

    public static void main(String[] args) {

        /**
         * A B C 三个线程 A线程每隔一秒去申请1M的内存 B C 线程每隔一秒输出一句话
         *  指定对堆内存大小 指定对堆内存大小 -Xmx20m -Xms5m -Xmn2m
         *  查看OOM之后的结果
         *  Wed Jun 19 08:34:22 CST 2019 Bis run
         Wed Jun 19 08:34:23 CST 2019 Cis run
         Exception in thread "A" java.lang.OutOfMemoryError: Java heap space
         at org.neil.util.OOMTest1$1.run(OOMTest1.java:38)
         Wed Jun 19 08:34:23 CST 2019 Bis run
         Wed Jun 19 08:34:24 CST 2019 Cis run
         可知A私有对象占用内存导致OOM不会影响到B C线程的正常运行
         在下一次GC时，会清理A线程的无用对象回收内存。
         * */
        new Thread("A"){
            List<byte[]> list = new ArrayList<>();
            @Override
            public void run() {
                while (true){

                    list.add(new byte[1024*1024*1]);
                    System.out.println(new Date().toString() +" "+ Thread.currentThread().getName()+"is run");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread("B"){
//            List<byte[]> list = new ArrayList<>();
            @Override
            public void run() {
                while (true){
                    // 申请堆内存 为了触发GC
                    byte[] bytes = new byte[1024 * 1024 * 3];
//                    list.add(new byte[1024*1024*1]);
                    System.out.println(new Date().toString() +" " + Thread.currentThread().getName()+"is run");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("C"){
            @Override
            public void run() {
                while (true){
                    System.out.println(new Date().toString() +" "+ Thread.currentThread().getName()+"is run");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
