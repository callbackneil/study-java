package org.neil.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author neil
 * @date 2019-06-12
 */
public class CallerRunsPolicyDemo {

    private static final int THREADS_SIZE = 2;
    private static final int CAPACITY = 1;

    public static void main(String[] args) throws Exception {

        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"CallerRunsPolicy"
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 设置线程池的拒绝策略为"AbortPolicy"
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 设置线程池的拒绝策略为"DiscardPolicy"
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        // 设置线程池的拒绝策略为"DiscardOldestPolicy"

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            Runnable myrun = new MyRunnable("task-"+i);
            pool.execute(myrun);
        }

        // 关闭线程池
        pool.shutdown();
    }



    static class MyRunnable implements Runnable{
         String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" is running" + name);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
//                        e.printStackTrace();
            }
        }
    }



}
