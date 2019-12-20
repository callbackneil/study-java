package org.neil.datastructures;

/**
 * @author neil
 * @date 2019-06-28
 */
public class SingleLinkList<T> {


    private Node<T> node;
    /**
     * 节点
     * @param <T>
     */
    private class Node<T>{
        private T t;
        private Node<T> next;

        public Node(T t, Node<T> next) {
            this.t = t;
            this.next = next;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
