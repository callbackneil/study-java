package org.neil.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author neil
 * @date 2019-08-12
 */
public class ConditionTest {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try{
                for (int i = 0; i < 100; i++) {
                    int i1 = i % 2;
                    if(i1 == 1){
                        System.out.println(Thread.currentThread().getName()+" "+i);
                    }else {
//                        condition.signal();
//                        condition.await();
                    }
                }

            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try{
                for (int i = 0; i < 100; i++) {
                    if(i%2 == 0){
                        System.out.println(Thread.currentThread().getName()+" "+i);
                    }{
//                        condition.signal();
//                        condition.await();
                    }
                }

            } finally {
                lock.unlock();
            }

        }).start();

    }


}
