package org.neil.thread;

import java.util.concurrent.CountDownLatch;

/**
 *
 * 闭锁 主线程等待，其他线程全部执行完毕之后继续
 * @author neil
 * @date 2019-02-13
 *
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread first = new Thread(()->{
            System.out.println("first");
            try {
                Thread.sleep(500);
                System.out.println(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("first end");
        });
        Thread second = new Thread(()->{
            System.out.println("second");
            try {
                Thread.sleep(1000);
                System.out.println(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("second end");
        });
        Thread third = new Thread(()->{
            System.out.println("third");
            try {
                Thread.sleep(5000);
                System.out.println(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("third end");
        });

        first.start();
        second.start();
        third.start();


        Thread four = new Thread(()->{
            try {
                System.out.println("four wait");
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("four end");
        });
        four.start();

        try {
            System.out.println("main wait");
            countDownLatch.await();
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
