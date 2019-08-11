package org.neil.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zhangzhen on 2019/8/10.
 */
public class CAS_ABA {
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            final AtomicReference<Node<Integer>> reference = new AtomicReference();
            final Node<Integer> node1= new Node<>(1);
            reference.set(node1);
            // 初始链表为 1-->2

            // 线程X对reference操作 1-->2 变成 1-->3-->4
            new Thread("A"){
                @Override
                public void run() {
                    node1.setT(2);
                    Node<Integer> node2 = reference.getAndSet(node1);
                    System.out.println(Thread.currentThread().getName()+":"+node2);
                }
            }.start();

            // 线程X对reference操作 1-->2 变成 2-->null
            new Thread("B"){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    node1.setT(3);
                    Node<Integer> node2 = reference.getAndSet(node1);
                    System.out.println(Thread.currentThread().getName()+":"+node2);
                }
            }.start();

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(reference.get());
        }
    }



    private static class Node<T> {
        @Override
        public String toString() {
            return "Node{" +
                    "t=" + t +
                    '}';
        }

        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public Node(T t) {

            this.t = t;
        }
    }
}


