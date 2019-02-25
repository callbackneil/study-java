package org.neil.datastructures;

/**
 * @author neil
 * @date 2019-02-15
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(8);
        avlTree.insert(1);

        avlTree.insert(10);
        avlTree.insert(11);


//        avlTree.insert(1);

        System.out.println(avlTree);
    }
}
