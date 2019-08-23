package org.neil.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * target/classes/org/neil/juc/ArrayBlockingQueueTest.class
 * @author neil
 * @date 2019-08-19
 */
public class ArrayBlockingQueueTest {
    private static  volatile ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
    public static void main(String[] args) {
        arrayBlockingQueue.offer(1);
        arrayBlockingQueue.offer(2);
        arrayBlockingQueue.offer(3);
        arrayBlockingQueue.offer(4);
        arrayBlockingQueue.offer(5);

        System.out.println(arrayBlockingQueue.toString());

        try {
            Integer take = arrayBlockingQueue.take();
            System.out.println(take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(arrayBlockingQueue);
        arrayBlockingQueue.offer(6);
        System.out.println(arrayBlockingQueue);


    }
}
