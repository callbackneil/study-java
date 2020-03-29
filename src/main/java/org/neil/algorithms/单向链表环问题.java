package org.neil.algorithms;

/**
 * @author zhangzhen 2019/12/6 3:07 下午
 */
public class 单向链表环问题 {

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node1.setNext(node2);
        Node<Integer> node3 = new Node<>(3);
        node2.setNext(node3);
        Node<Integer> node4 = new Node<>(4);
        node3.setNext(node4);
        Node<Integer> node5 = new Node<>(5);
        node4.setNext(node5);
        Node<Integer> node6 = new Node<>(6);
        node5.setNext(node6);
        Node<Integer> node7 = new Node<>(7);
        node6.setNext(node7);
        Node<Integer> node8 = new Node<>(8);
        node7.setNext(node8);
        Node<Integer> node9 = new Node<>(9);
        node8.setNext(node9);
        Node<Integer> node10 = new Node<>(10);
        node9.setNext(node10);
        node10.setNext(node6);

        System.out.println(hasLoop(node1));
        System.out.println(loopLength(node1));
        System.out.println(loopStart(node1));

    }


    /**
     * 环起点
     *
     * @param head
     * @return null 无环
     */
    public static Node<Integer> loopStart(Node<Integer> head) {
        Node<Integer> p = head;
        Node<Integer> q = head;
        while ((p = p.next) != null && (q = q.next.next) != null) {
            if (p.equals(q)) {
                p = head;
                break;
            }
        }
        while ((p = p.next) != null && (q = q.next) != null) {
            if (p.equals(q)) {
                return p;
            }
        }
        return null;
    }

    /**
     * 环长度
     *
     * @param head
     * @return 0表示无环
     */
    public static Integer loopLength(Node<Integer> head) {
        Node<Integer> p = head;
        Node<Integer> q = head;
        int step = 0;
        int together = 0;
        while ((p = p.next) != null && (q = q.next.next) != null) {
            if (together == 1) {
                step += 1;
            }
            if (p.equals(q)) {
                together += 1;
                if (together == 2) {
                    return step;
                }
            }
        }
        return 0;
    }

    /**
     * 是否有环
     *
     * @param head
     * @return
     */
    public static boolean hasLoop(Node<Integer> head) {

        Node<Integer> p = head;
        Node<Integer> q = head;
        // while
        while ((p = p.next) != null && (q = q.next.next) != null) {
            if (p.equals(q)) {
                return true;
            }
        }
        return false;
        // 递归
//        p = p.next;
//        q = q.next.next;
//        return hasLoop(p,q);

    }


//    private static boolean hasLoop(Node<Integer> p, Node<Integer> q) {
//        if(p!=null && q !=null){
//            if(q.equals(p)){
//                return true;
//            }
//            p = p.next;
//            q = q.next.next;
//            return hasLoop(p,q);
//        }
//        return false;
//    }


    /**
     * 单向链表节点
     *
     * @param <T>
     */
    private static class Node<T> {

        private T t;
        private Node<T> next;

        public Node(T t) {
            this.t = t;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "t=" + t +
                    '}';
        }
    }

}
