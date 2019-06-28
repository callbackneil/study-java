package org.neil.util;

/**
 * Created by zhangzhen on 2019/6/16.
 */
public class 协作对象之间死锁DeadThreaTest {

    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();
        a.setB(b);
        b.setA(a);
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                a.methodA();
            }
        }, "A");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                b.methodB();
            }
        }, "B");

        threadA.start();
        threadB.start();
    }
}


class A{
    B b;

    public void setB(B b) {
        this.b = b;
    }

    public synchronized void methodA(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"get methodA");
        b.methodB();
    }
}

class B{
    A a;

    public void setA(A a) {
        this.a = a;
    }

    public synchronized void methodB(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"get methodB");
        a.methodA();
    }
}