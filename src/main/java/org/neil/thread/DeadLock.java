package org.neil.thread;

/**
 * @author neil
 * @date 2019-02-13
 */
public class DeadLock {
    private final Object a = new Object();
    private final Object b = new Object();

    public static void main(String[] args) {

        final ClassA a = new ClassA();
        final ClassB b = new ClassB();
        final String one = "1";
        final String two = "2";
        DeadLock deadLock = new DeadLock();

        Thread first = new Thread(() -> {
//            deadLock.a2b();
//            deadLock.first2second(one,two);
            a.methodA(b);
        },"thread_first");

        Thread second = new Thread(() -> {
//            deadLock.b2a();
//            deadLock.first2second(two,one);
            b.methodC(a);
        },"thread_second");

        first.start();
        second.start();

    }
    /** =============================1、顺序死锁====================================== */
    public  void a2b() {
        synchronized (a){
            System.out.println(Thread.currentThread().getName() +" get lock_a");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" want lock_b");
            synchronized (b){
                System.out.println(Thread.currentThread().getName() +" get lock_b");
            }
        }
    }

    public  void b2a() {
        synchronized (b){
            System.out.println(Thread.currentThread().getName() +" get lock_b");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" want lock_a");
            synchronized (a){
                System.out.println(Thread.currentThread().getName() +" get lock_a");
            }
        }
    }
    /** =============================1、顺序死锁====================================== */




    /** =============================2、动态顺序死锁====================================== */
    private final Object tieLock = new Object();

    public  void first2second(String first,String second) {
        int firstHashCode = System.identityHashCode(first);
        int secondHashCode = System.identityHashCode(second);

        if(firstHashCode < secondHashCode){
            synchronized (first){
                System.out.println(Thread.currentThread().getName() +" get lock_"+first);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" want lock_"+second);
                synchronized (second){
                    System.out.println(Thread.currentThread().getName() +" get lock_"+second);
                }
            }
        }else if( secondHashCode < firstHashCode){
            synchronized (second){
                System.out.println(Thread.currentThread().getName() +" get lock_"+second);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" want lock_"+first);
                synchronized (first){
                    System.out.println(Thread.currentThread().getName() +" get lock_"+first);
                }
            }
        }else if( secondHashCode == firstHashCode){
            synchronized (tieLock){
                synchronized (first){
                    System.out.println(Thread.currentThread().getName() +" get lock_"+first);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +" want lock_"+second);
                    synchronized (second){
                        System.out.println(Thread.currentThread().getName() +" get lock_"+second);
                    }
                }
            }
        }
    }
    /** =============================2、动态顺序死锁====================================== */


    /** =============================3、协作对象顺序死锁====================================== */

    static class ClassA{

        public synchronized void methodA(ClassB b){
            System.out.println(Thread.currentThread().getName()+" get lock_a");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.methodD();
        }

        public  void methodA_1(ClassB b){
            synchronized(this){
                System.out.println(Thread.currentThread().getName()+" get lock_a");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.methodD();
        }


        public synchronized void methodB(){
            System.out.println(Thread.currentThread().getName()+" get lock_a");
        }



    }

    static class ClassB{
        public synchronized void methodC(ClassA a){
                System.out.println(Thread.currentThread().getName()+" get lock_b");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            a.methodB();
        }

        public  void methodC_1(ClassA a){
            synchronized(this){
                System.out.println(Thread.currentThread().getName()+" get lock_b");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            a.methodB();
        }

        public synchronized void methodD(){
            System.out.println(Thread.currentThread().getName()+" get lock_b");
        }
    }

    /** =============================3、协作对象顺序死锁====================================== */
}
