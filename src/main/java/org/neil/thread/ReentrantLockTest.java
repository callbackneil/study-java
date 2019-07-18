//package org.neil.thread;
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @author neil
// * @date 2019-02-13
// */
//public class ReentrantLockTest {
//
//    public static void main(String[] args) {
//        ClassA a = new ClassA();
//
//        Thread first = new Thread(() -> {
//            a.methodA();
//        },"thread_first");
//        first.start();
//
//        Thread second = new Thread(() -> {
//            a.methodB();
//        },"thread_second");
//        second.start();
//
//    }
//
//}
//
//
//
//class ClassA{
//    Lock lockA = new ReentrantLock(true);
//    Lock lockB = new ReentrantLock(true);
//    public void methodA(){
//        boolean isDone = false;
//        int num = 0;
//        while (!isDone){
//            num++;
//            if (lockA.tryLock()) {
//                try {
//                    Thread.sleep(10);
//                    System.out.println(Thread.currentThread().getName()+" get lock_a");
//                    if(lockB.tryLock()){
//                        try{
//                            System.out.println(Thread.currentThread().getName()+" get lock_b");
//                        }finally {
//                            lockB.unlock();
//                            isDone = true;
//                        }
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    lockA.unlock();
//                }
//            }
//        }
//        System.out.println(Thread.currentThread().getName()+" try get lock time "+num);
//    }
//
//
//    public void methodB(){
//        boolean isDone = false;
//        int num = 0;
//        while (!isDone){
//            num++;
//            if (lockB.tryLock()) {
//                try {
////                    Thread.sleep(100);
//                    System.out.println(Thread.currentThread().getName()+" get lock_b");
//                    if(lockA.tryLock()){
//                        try{
//                            System.out.println(Thread.currentThread().getName()+" get lock_a");
//                        }finally {
//                            lockA.unlock();
//                            isDone = true;
//                        }
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    lockB.unlock();
//                }
//            }
//        }
//        System.out.println(Thread.currentThread().getName()+" try get lock time "+num);
//    }
//}
//
//
//
//
