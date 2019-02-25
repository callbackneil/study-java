package org.neil.datastructures;

/**
 * 平衡修复原则: 先子孙旋转 方向取子 然后根子旋转 方向取子反方向
 * LL == R
 * RR == L
 * LR == L + R == RR + LL
 * RL == R + L == LL +RR
 * @author neil
 * @date 2019-02-14
 */
public class AVLTree<T extends Comparable<T>> {



    private AVLNode<T> root;



    public void remove(T t){
        root = remove(root,t);
    }

    private AVLNode<T> remove(AVLNode<T> node, T t) {

        return node;
    }


    public void insert(T t){
        root = insert(root,t);
    }

    private AVLNode<T> insert(AVLNode<T> node, T t) {
        if(node == null){
            return new AVLNode<>(t);
        }

        int result = t.compareTo(node.t);

        if(result == 0 ){
            return node;
        }

        if (result < 0){
            // 左子树
            node.left = insert(node.left,t);
            // 如果失衡
            if(height(node.left)- height(node.right)== 2){
                if(t.compareTo(node.left.t) < 0 ){
                   // LL
                    node = leftLeftRotate(node);
                }else {
                    // LR
                    node = leftRightRotate(node);
                }
            }
        }
        if (result > 0){
            // 右子树
            node.right = insert(node.right,t);
            // 如果失衡
            if(height(node.right) - height(node.left) == 2){
                // RR 还是 RL
                if(t.compareTo(node.right.t) > 0){
                    // RR
                    node = rightRightRotate(node);
                }
                if (t.compareTo(node.right.t) < 0){
                    // RL
                    node = rightLeftRotate(node);
                }

            }
        }

        node.height = (height(node.left) > height(node.right) ? height(node.left) : height(node.right)) + 1;
        return node;

    }


    /**
     * 获取最小的不平衡节点
     * @param node
     * @return
     */
    private AVLNode<T> getNonBalanceMin(AVLNode<T> node){
        if(isBalance(node)){
            return null;
        }
        if(isBalance(node.left) && isBalance(node.right)){
            return node;
        }
        AVLNode nonBalanceMinRight = getNonBalanceMin(node.right);
        AVLNode nonBalanceMinLeft = getNonBalanceMin(node.left);

        return nonBalanceMinLeft == null?nonBalanceMinRight:nonBalanceMinLeft;
    }

    /**
     *  节点node是否平衡
     * @param node
     * @return
     */
    private boolean isBalance(AVLNode<T> node){
        if(node == null){
            return true;
        }
        if(node.height == 1){
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int heightDifference = leftHeight - rightHeight;
        if(heightDifference >= -1 && heightDifference <= 1){
            return isBalance(node.left) && isBalance(node.right);
        }
        return false;

    }

    /**
     * LL失衡旋转
     * @param
     * @return
     */
    private AVLNode<T> leftLeftRotate(AVLNode<T> k1){
        AVLNode<T> k2;
        k2 = k1.left;
        k1.left = k2.right;
        k2.right = k1;

        k1.height = (height(k1.left)> height(k1.right)? height(k1.left) : height(k1.right)) + 1;
        k2.height = (height(k2.left)> height(k2.right)? height(k2.left) : height(k2.right)) + 1;
        return k2;
    }

    /**
     * RR失衡旋转
     * @param k1 根节点
     * @return
     */
    private AVLNode<T> rightRightRotate(AVLNode<T> k1){
        AVLNode<T> k2;
        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = (height(k1.left) > height(k1.right)? height(k1.left) : height(k1.right)) + 1;
        k2.height = (height(k2.left) > height(k2.right) ? height(k2.left) : height(k2.right)) + 1;
        return k2;
    }

    /**
     * LR失衡旋转
     * @param k1
     * @return
     */
    private AVLNode<T> leftRightRotate(AVLNode<T> k1){
        k1.left = rightRightRotate(k1.left);
        return leftLeftRotate(k1);
    }

    /**
     * RL失衡旋转
     * @param k1
     * @return
     */
    private AVLNode<T> rightLeftRotate(AVLNode<T> k1){
        k1.right = leftLeftRotate(k1.right);
        return rightRightRotate(k1);
    }





    public AVLNode<T> getRoot() {
        return root;
    }

    public void setRoot(AVLNode<T> root) {
        this.root = root;
    }

    private int height(AVLNode<T> node){
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private static class AVLNode<T extends Comparable<T>>{
        T t;
        int height;
        AVLNode<T> left;
        AVLNode<T> right;
        public AVLNode() {
        }


        public AVLNode(T t) {
            this.t = t;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

        public AVLNode(T t, AVLNode left, AVLNode right) {
            this.t = t;
            this.left = left;
            this.right = right;
            this.height = 1;
        }

        public AVLNode(T t, int height, AVLNode left, AVLNode right) {
            this.t = t;
            this.height = height;
            this.left = left;
            this.right = right;
        }
    }
}
