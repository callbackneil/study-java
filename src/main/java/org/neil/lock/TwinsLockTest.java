package org.neil.lock;

import java.util.concurrent.locks.Lock;

/**
 * Created by zhangzhen on 2019/8/5.
 */
public class TwinsLockTest {
    public static void main(String[] args) throws Exception {
        final Lock twinsLock = new TwinsLock();
        class MyRunnable implements Runnable{
            public MyRunnable() {
            }

            @Override
            public void run() {
                while (true){
                    twinsLock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+" is running");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        twinsLock.unlock();
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.setDaemon(true);
            thread.start();
        }
        for (;;) {
            Thread.sleep(1000);
            System.out.println();
        }



    }




}
