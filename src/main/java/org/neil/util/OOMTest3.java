package org.neil.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangzhen on 2019/6/19.
 */
public class OOMTest3 {

    public static void main(String[] args) {

        /**
         * A B C 三个线程 A线程每隔一秒去申请1M的内存 B C 线程每隔一秒输出一句话
         *  指定对堆内存大小 -Xmx20m -Xms5m -Xmn2m
         *  查看OOM之后的结果：
         *  Wed Jun 19 08:43:36 CST 2019 Ais run
         Exception in thread "B" java.java.lang.OutOfMemoryError: Java heap space
         Wed Jun 19 08:43:36 CST 2019 Cis run
         at org.neil.util.OOMTest2$2.run(OOMTest2.java:41)
         Exception in thread "A" java.java.lang.OutOfMemoryError: Java heap space
         at org.neil.util.OOMTest2$1.run(OOMTest2.java:26)
         Wed Jun 19 08:43:37 CST 2019 Cis run
         Wed Jun 19 08:43:38 CST 2019 Cis run
         情况一：A B线程共享变量list导致B先OOM 然后A还在引用list 不会被回收 AOOM之后  C要申请内存，此时list未被使用，于是占用内存被回收，C正常运行。




         * */

        final List<byte[]> list = new ArrayList<>();
        Thread threadA = new Thread("A") {
            @Override
            public void run() {
                while (true) {

                    list.add(new byte[1024 * 1024 * 1]);
                    System.out.println(new Date().toString() + " " + Thread.currentThread().getName() + "is run");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        threadA.start();

        Thread threadB = new Thread("B") {
            @Override
            public void run() {
                while (true) {
//                    list.add(new byte[1024 * 1024 * 1]);
                    System.out.println(list.size());
                    System.out.println(new Date().toString() + " " + Thread.currentThread().getName() + "is run");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        threadB.start();

        Thread threadC = new Thread("C") {
            @Override
            public void run() {
                while (true) {
                    // 申请堆内存 为了触发GC
                    byte[] bytes = new byte[1024 * 1024 * 5];
                    System.out.println(bytes);
                    System.out.println(new Date().toString() + " " + Thread.currentThread().getName() + "is run");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        threadC.start();
    }
}
