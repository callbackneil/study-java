package org.neil.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏 所有线程都执行到该处才能继续执行
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(5);

        for (int i = 1; i <= 5; i++) {
            final int count = i;
            new Thread("线程-"+count){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " start");
                    try {
                        Thread.sleep(1000*count);
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " end");
                }
            }.start();
        }

    }
}
