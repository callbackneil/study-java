package org.neil.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author neil
 * @date 2019-02-12
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = null;
        try {
//            executorService = Executors.newCachedThreadPool();

            executorService = new ThreadPoolExecutor(2,10,1L, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(5));
            executorService.prestartAllCoreThreads();
//            executorService.prestartCoreThread();

            for (int i = 0; i < 20; i++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" is execute task");
                    }
                });

            }
//            executorService = Executors.newSingleThreadExecutor();

//            executorService = Executors.newScheduledThreadPool(5);


//            executorService = Executors.newSingleThreadScheduledExecutor();
//            executorService.scheduleWithFixedDelay(new Thread(() -> {
//                        System.out.println("zzz");
//                    }),
//                    0, 1, TimeUnit.SECONDS);



            // (1+2)*(3+5) = ?

//            Future<Integer> future1 = executorService.submit(() -> {
//                Thread.sleep(1000);
//                return 1 + 2;
//            });
//
//            Future<Integer> future2 = executorService.submit(() -> {
//                Thread.sleep(2000);
//                throw new Exception("throw new Exception");
////                return 3 + 5;
//            });
//
//            Integer first = future1.get();
//            Integer second = future2.get();
//
//
//            System.out.println(first*second);
//


//            executorService.execute(() -> {
//                System.out.println("===");
//            });


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Thread.sleep(3000);
            executorService.shutdown();

//            if (executorService.isTerminated()) {
//            }
        }

    }


}
