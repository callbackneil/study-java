package org.neil.datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉查找树
 *
 * @author neil
 * @date 2019-01-17
 */
public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * 前序遍历
     */
    public static final int PRE = -1;
    /**
     * 中序遍历
     */
    public static final int MID = 0;
    /**
     * 后序遍历
     */
    public static final int POST = 1;

    private BinaryNode<T> root;


    /**
     * 获取高度
     *
     * @return
     */
    public boolean isFBT() {
        return isFBT(root);
    }

    private boolean isFBT(BinaryNode<T> node) {
        if (node == null) {
            return true;
        }
        boolean result = getHeight(node.left) == getHeight(node.right);
        return result && isFBT(node.left) && isFBT(node.right);
    }


    /**
     * 是不是完全二叉树
     * 1、如果存在第一个不完全（无右 或者 无左右）节点，只要后续节点有子节点 就不是完全二叉树
     * 2、不存在，找到，
     *
     * @return
     */
    public boolean isCBT() {
        if (root == null) {
            return false;
        }
        ArrayDeque<BinaryNode<T>> queue = new ArrayDeque<>();
        queue.offerFirst(root);
        // 默认不是第一个不完全的节点
        boolean firstLast = false;
        while (!queue.isEmpty()) {
            BinaryNode<T> node = queue.pollLast();
            if (firstLast) {
                if (node.right != null || node.left != null) {
                    return false;
                }
            } else {
                if (node.left != null && node.right != null) {
                    queue.offerFirst(node.left);
                    queue.offerFirst(node.right);
                } else if (node.right != null) {
                    return false;
                } else if (node.left != null) {
                    queue.offerFirst(node.left);
                    firstLast = true;
                } else {
                    firstLast = true;
                }
            }
        }

        return true;
    }


    /**
     * 查找最小祖先节点 通过节点左右子树判断
     */
    public T getLCA2(BinaryNode<T> node1, BinaryNode<T> node2) {
        return getLCA2(root, node1, node2).t;
    }

    private BinaryNode<T> getLCA2(BinaryNode<T> node, BinaryNode<T> node1, BinaryNode<T> node2) {
        if (node == null || node1 == null || node2 == null) {
            return null;
        }

        if (node == node1 || node == node2) {
            return node;
        }

        // 判断node1 node2在node的位置
        BinaryNode<T> left = getLCA2(node.left, node1, node2);
        BinaryNode<T> right = getLCA2(node.right, node1, node2);
        // 如果都不为空 表示node1 node2分属于左右子树
        if (left != null && right != null) {
            return node;
        }
        // 否则返回包含node1 node2的非空节点
        return left == null ? right : left;
    }

    /**
     * 查找最小祖先节点 通过节点元素判断
     */
    public T getLCA(BinaryNode<T> node1, BinaryNode<T> node2) {
        return getLCA(root, node1, node2).t;
    }


    private BinaryNode<T> getLCA(BinaryNode<T> node, BinaryNode<T> node1, BinaryNode<T> node2) {
        if (null == root) {
            return null;
        }
        T t = node.t;
        T t1 = node1.t;
        T t2 = node2.t;
        int result1 = t.compareTo(t1);
        int result2 = t.compareTo(t2);
        if (result1 != result2 || result2 == 0) {
            return node;
        }

        if (result1 > 0) {
            return getLCA(node.left, node1, node2);
        }
        if (result1 < 0) {
            return getLCA(node.right, node1, node2);
        }
        return null;

    }


    /**
     * 是否与tree结构相同
     *
     * @param tree
     * @return
     */
    public boolean equalsTo(BinarySearchTree<T> tree) {
        return equals(this.root, tree.root);
    }

    private boolean equals(BinaryNode<T> sourceTree, BinaryNode<T> targetTree) {
        if (sourceTree == null && targetTree == null) {
            return true;
        } else if (sourceTree == null || targetTree == null) {
            return false;
        } else {
            return equals(sourceTree.left, targetTree.left) && equals(sourceTree.right, targetTree.right);

        }
    }


    /**
     * 获取level层节点数
     *
     * @param level
     * @return
     */
    public int getNodeCount(int level) {
        return getNodeCount(root, level);
    }

    private int getNodeCount(BinaryNode<T> node, int level) {
        if (node == null || level == 0) {
            return 0;
        }
        if (level == 1) {
            return 1;
        }
        int left = getNodeCount(node.left, level - 1);
        int right = getNodeCount(node.right, level - 1);
        return left + right;
    }


    /**
     * 获取节点数量
     *
     * @return
     */
    public int getNodeCount() {
        return getNodeCount(root);
    }

    private int getNodeCount(BinaryNode<T> node) {
        if (node == null) {
            return 0;
        }
        int left = getNodeCount(node.left);
        int right = getNodeCount(node.right);
        return left + right + 1;
    }


    /**
     * 获取树叶数量
     *
     * @return
     */
    public int getLeafCount() {
        return getLeafCount(root);
    }

    private int getLeafCount(BinaryNode<T> node) {

        if (node == null) {
            return 0;
        }
        if (node.right == null && node.left == null) {
            return 1;
        }
        int count = 0;
        if (node.right != null) {
            count += getLeafCount(node.right);
        }
        if (node.left != null) {
            count += getLeafCount(node.left);
        }

        return count;
    }


    /**
     * 获取高度
     *
     * @return
     */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return (rightHeight > leftHeight ? rightHeight : leftHeight) + 1;
    }


    /**
     * 层序遍历
     *
     * @return
     */
    public List<T> tierIterate() {
        return tierIterate2(root);
    }

    private List<T> tierIterate2(BinaryNode<T> node) {
        List<T> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        ArrayDeque<BinaryNode<T>> queue = new ArrayDeque<>();
        queue.offerFirst(node);
        while (!queue.isEmpty()) {
            BinaryNode<T> node1 = queue.pollLast();
            list.add(node1.t);
            if (node1.left != null) {
                queue.offerFirst(node1.left);
            }
            if (node1.right != null) {
                queue.offerFirst(node1.right);
            }
        }

        return list;
    }

    private List<T> tierIterate(BinaryNode<T>... node) {
        List<T> list = new ArrayList<>();
        if (node == null || node.length == 0) {
            return list;
        }
        List<BinaryNode<T>> nodes = new ArrayList<>();
        for (BinaryNode<T> tBinaryNode : node) {
            if (tBinaryNode != null) {
                list.add(tBinaryNode.t);
                nodes.add(tBinaryNode.left);
                nodes.add(tBinaryNode.right);
            }
        }
        BinaryNode<T>[] binaryNodes = new BinaryNode[nodes.size()];
        list.addAll(tierIterate(nodes.toArray(binaryNodes)));
        return list;
    }


    /**
     * 中序遍历
     *
     * @return
     */
    public List<T> postIterate() {
        return iterate(root, POST);
    }

    /**
     * 中序遍历
     *
     * @return
     */
    public List<T> middleIterate() {
        return iterate(root, MID);
    }


    /**
     * 前序遍历
     *
     * @return
     */
    public List<T> preIterate() {
        return iterate(root, PRE);
    }


    /**
     * 递归遍历节点node
     *
     * @param node
     * @param type 遍历顺序
     * @return
     */
    private List<T> iterate(BinaryNode<T> node, int type) {
        List<T> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        if (type == PRE) {
            list.add(node.t);
        }
        list.addAll(iterate(node.left, type));
        if (type == MID) {
            list.add(node.t);
        }
        list.addAll(iterate(node.right, type));
        if (type == POST) {
            list.add(node.t);
        }
        return list;
    }


    /**
     * 替换元素t所在节点的左子树为targetNode
     *
     * @param t
     * @param targetNode
     */
    public void replaceLeft(T t, BinaryNode<T> targetNode) {
        BinaryNode<T> node = findNode(t);
        // 对象的属性变化 会传递出去
        node.left = targetNode;
    }

    /**
     * 查找元素t所在的节点
     *
     * @param t
     * @return
     */
    public BinaryNode<T> findNode(T t) {
        return findNode(t, root);
    }

    private BinaryNode<T> findNode(T t, BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        int result = t.compareTo(node.t);

        if (result == 0) {
            return node;
        }

        if (result > 0) {
            return findNode(t, node.right);
        }

        if (result < 0) {
            return findNode(t, node.left);
        }
        return null;
    }


    /**
     * 从树中删除元素t
     *
     * @param t
     * @return
     */
    public void remove(T t) {
        remove(t, root);
    }

    /**
     * 从节点中删除元素t  遍历-判断-操作
     *
     * @param t
     * @param node
     * @return
     */
    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        // 节点为空 返回空
        if (node == null) {
            return null;
        }
        //
        int result = t.compareTo(node.t);
        // 找到该元素
        if (result == 0) {
            // 如果是树叶
            if (node.right == null && node.left == null) {
                node = null;
                return node;
            }

            if (node.right != null && node.left == null) {
                node = node.right;
                return node;
            }

            if (node.right == null && node.left != null) {
                node = node.left;
                return node;
            }

            if (node.right != null && node.left != null) {
                node.t = findMin(node.right).t;
                node.right = remove(node.t, node.right);
                return node;
            }

        }
        if (result > 0) {
            node.right = remove(t, node.right);
            return node;
        }
        if (result < 0) {
            node.left = remove(t, node.left);
            return node;
        }

        return null;
    }


    /**
     * 向树中插入元素t
     *
     * @param t
     * @return
     */
    public BinarySearchTree<T> insert(T t) {
        root = insert(t, root);
        return this;
    }

    /**
     * 向节点node中插入元素t
     *
     * @param t
     * @param node
     * @return
     */
    private BinaryNode<T> insert(T t, BinaryNode<T> node) {
        // 如果节点为空 使用元素t创建节点并返回
        if (node == null) {
            return new BinaryNode<>(t, null, null);
        }

        // 节点不为空 比较该元素和节点元素
        int result = t.compareTo(node.t);
        // 该元素等于节点元素 返回该节点
        if (result == 0) {
            return node;
        }
        // 该元素大于节点元素 插入到右子节点
        if (result > 0) {
            node.right = insert(t, node.right);
            return node;
        }
        // 该元素小于节点元素 插入到左子节点
        if (result < 0) {
            node.left = insert(t, node.left);
            return node;
        }

        return node;
    }


    /**
     * 获取树中最大元素
     *
     * @return
     */
    public T findMaxValue() {
        return findMax(root).t;
    }

    /**
     * 获取树中最大节点
     *
     * @return
     */
    public BinaryNode<T> findMaxNode() {
        return findMax(root);
    }

    /**
     * 获取节点node最大节点
     *
     * @param node
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }


    /**
     * 获取树中最小元素
     *
     * @return
     */
    public T findMinValue() {
        return findMin(root).t;
    }

    /**
     * 获取树中最小元素
     *
     * @return
     */
    public BinaryNode<T> findMinNode() {
        return findMin(root);
    }

    /**
     * 获取节点node最小元素所在节点
     *
     * @param node
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    /**
     * 树是否包含元素t
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        return contains(t, root);
    }

    /**
     * 节点node是否包含元素t
     *
     * @param t
     * @param node
     * @return
     */
    private boolean contains(T t, BinaryNode<T> node) {
        // 若节点为空，则不包含
        if (node == null) {
            return false;
        }

        // 和当前节点元素比较
        final int result = t.compareTo(node.t);
        // 当前节点元素和给定元素相等 则包含
        if (result == 0) {
            return true;
        }
        // 当前节点元素大于给定元素相等 继续和右子节点比较
        if (result > 0) {
            return contains(t, node.right);
        }

        // 当前节点元素小于给定元素相等 继续和左子节点比较
        if (result < 0) {
            return contains(t, node.left);
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
        this.root = new BinaryNode<T>(rootValue, null, null);
    }


    private static class BinaryNode<T> {
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
