package org.neil.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 12; i++) {
            new Thread("Thread-"+i){
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "is start");
                    try {
                        semaphore.acquire();
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                    System.out.println(name + "is end");
                }
            }.start();
        }

    }
}
