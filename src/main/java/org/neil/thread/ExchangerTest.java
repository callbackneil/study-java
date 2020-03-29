package org.neil.thread;

import java.util.concurrent.Exchanger;


/**
 * 两个线程交换数据
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread("线程-1"){

            @Override
            public void run() {
                String s = "123";
                System.out.println(Thread.currentThread().getName()+ " 发送数据："+s);
                String exchange = null;
                try {
                    exchange = exchanger.exchange(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ " 获取数据："+exchange);
            }
        }.start();
        new Thread("线程-2"){

            @Override
            public void run() {
                String s = "456";
                System.out.println(Thread.currentThread().getName()+ " 发送数据："+s);
                String exchange = null;
                try {
                    exchange = exchanger.exchange(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ " 获取数据："+exchange);
            }
        }.start();

    }
}
