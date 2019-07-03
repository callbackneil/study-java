package org.neil.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author neil
 * @date 2019-02-12
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newCachedThreadPool();

            executorService = Executors.newFixedThreadPool(100);

            for (int i = 0; i < 10; i++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(100);
                        System.out.println(100);
                        System.out.println(100);
                        System.out.println(100);
                        System.out.println(100);
                        System.out.println(100);
                        System.out.println(100);
                        System.out.println(100);



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
            executorService.shutdown();
//            if (executorService.isTerminated()) {
//            }
        }

    }


}
