package org.neil.util;

/**
 * Created by zhangzhen on 2019/6/16.
 */
public class 锁顺序DeadThreaTest {
    public static void main(String[] args) {
        /**
         * 锁X 和 锁Y
         */
        final Object X = new Object();
        final Object Y = new Object();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (X) {
                    // 获取X
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " get X");
                    // 还没释放X 尝试获取Y
                    synchronized (Y) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " get Y");
                    }
                }


            }
        }, "A");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Y) {
                    // 获取Y
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " get Y");
                    // 还没释放Y 尝试获取A
                    synchronized (X) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " get X");
                    }
                }


            }
        }, "B");

        a.start();
        b.start();
    }
}