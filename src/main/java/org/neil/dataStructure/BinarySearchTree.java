package org.neil.dataStructure;

/**
 * 二叉查找树
 * Created by zhangzhen on 2019/6/27.
 */
public class BinarySearchTree<T> {





    private class Node<T> {
        private T t;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        public Node(T t, Node<T> left, Node<T> right, Node<T> parent) {
            this.t = t;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }
    }
}
