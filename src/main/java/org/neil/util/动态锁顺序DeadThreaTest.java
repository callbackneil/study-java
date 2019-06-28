package org.neil.util;

/**
 * Created by zhangzhen on 2019/6/16.
 */
public class 动态锁顺序DeadThreaTest {

    public static void main(String[] args) {
        final 动态锁顺序DeadThreaTest threaTest = new 动态锁顺序DeadThreaTest();
        /**
         * 锁X 和 锁Y
         */
        final Object X = new Object(){
            @Override
            public String toString() {
                return "X";
            }
        };
        final Object Y = new Object(){
            @Override
            public String toString() {
                return "Y";
            }
        };
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                threaTest.method(X,Y);
            }
        }, "A");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                threaTest.method(Y,X);
            }
        }, "B");

        a.start();
        b.start();
    }


    public void method( Object x,Object y){

        synchronized (x){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" get " +x.toString());
            synchronized (y){
                System.out.println(Thread.currentThread().getName()+" get " +y.toString());
            }
        }
    }
}