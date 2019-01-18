package org.neil.datastructures;

/**
 * 二叉查找树
 * @author neil
 * @date 2019-01-17
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryNode<T> root;



    /**
     * 从树中删除元素t
     * @param t
     * @return
     */
    public void remove(T t){
        remove(t,root);
    }

    /**
     * 从节点中删除元素t
     * @param t
     * @param node
     * @return
     */
    private BinaryNode<T> remove(T t,BinaryNode<T> node){
        // 节点为空 返回空
        if(node == null){
            return null;
        }
        //
        int result = t.compareTo(node.t);
        // 找到该元素
        if(result == 0){
            // 如果是树叶
            if(node.right==null&&node.left==null){
                node = null;
                return node;
            }

            if(node.right!=null && node.left==null){
                node = node.right;
                return node;
            }

            if(node.right==null && node.left!=null){
                node = node.left;
                return node;
            }

            if(node.right!=null && node.left!=null){
                node.t = findMin(node.right).t;
                node.right = remove(node.t,node.right);
                return node;
            }

        }
        if(result > 0){
            node.right= remove(t, node.right);
            return node;
        }
        if(result < 0){
            node.left = remove(t,node.left);
            return node;
        }

        return null;
    }


    /**
     * 向树中插入元素t
     * @param t
     * @return
     */
    public void insert(T t){
        insert(t,root);
    }

    /**
     * 向节点node中插入元素t
     * @param t
     * @param node
     * @return
     */
    private BinaryNode<T> insert(T t,BinaryNode<T> node){
        // 如果节点为空 使用元素t创建节点并返回
        if(node == null){
            return new BinaryNode<>(t,null,null);
        }

        // 节点不为空 比较该元素和节点元素
        int result = t.compareTo(node.t);
        // 该元素等于节点元素 返回该节点
        if(result == 0 ){
            return node;
        }
        // 该元素大于节点元素 插入到右子节点
        if(result >0 ){
            node.right = insert(t, node.right);
            return node;
        }
        // 该元素小于节点元素 插入到左子节点
        if(result < 0 ){
            node.left = insert(t, node.left);
            return node;
        }

        return null;
    }


    /**
     * 获取树中最大元素
     * @return
     */
    public T findMaxValue(){
        return findMax(root).t;
    }

    /**
     * 获取树中最大节点
     * @return
     */
    public BinaryNode<T> findMaxNode(){
        return findMax(root);
    }

    /**
     * 获取节点node最大节点
     * @param node
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> node){
        if(node == null){
            return null;
        }
        if(node.right == null){
            return node;
        }
        return findMax(node.right);
    }



    /**
     * 获取树中最小元素
     * @return
     */
    public T findMinValue(){
        return findMin(root).t;
    }

    /**
     * 获取树中最小元素
     * @return
     */
    public BinaryNode<T> findMinNode(){
        return findMin(root);
    }
    /**
     * 获取节点node最小元素所在节点
     * @param node
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> node){
        if(node == null){
            return null;
        }
        if(node.left == null){
            return node;
        }
        return findMin(node.left);
    }

    /**
     * 树是否包含元素t
     * @param t
     * @return
     */
    public boolean contains(T t){
        return contains(t,root);
    }
    /**
     * 节点node是否包含元素t
     * @param t
     * @param node
     * @return
     */
    private boolean contains(T t,BinaryNode<T> node){
        // 若节点为空，则不包含
        if (node == null) {
            return false;
        }

        // 和当前节点元素比较
        final int result = t.compareTo(node.t);
        // 当前节点元素和给定元素相等 则包含
        if(result == 0){
            return true;
        }
        // 当前节点元素大于给定元素相等 继续和右子节点比较
        if(result > 0){
            return contains(t,node.right);
        }

        // 当前节点元素小于给定元素相等 继续和左子节点比较
        if(result < 0){
            return contains(t,node.left);
        }

        return false;
    }


    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }


    public void setRootValue(T rootValue) {
        this.root = new BinaryNode<T>(rootValue,null,null);
    }




    private static class BinaryNode<T>{
        private T t;
        private BinaryNode<T> left;
        private BinaryNode<T> right;

        public BinaryNode(T t, BinaryNode<T> left, BinaryNode<T> right) {
            this.t = t;
            this.left = left;
            this.right = right;
        }

        public BinaryNode(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public BinaryNode<T> getLeft() {
            return left;
        }

        public void setLeft(BinaryNode<T> left) {
            this.left = left;
        }

        public BinaryNode<T> getRight() {
            return right;
        }

        public void setRight(BinaryNode<T> right) {
            this.right = right;
        }
    }
}
