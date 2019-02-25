package org.neil.datastructures;

/**
 * @author neil
 * @date 2019-02-20
 */
public class RBTreeTest {
    public static void main(String[] args) {
        RBTree<Integer> rbTree = new RBTree<>();
        rbTree.insert(100);
        rbTree.insert(50);
        rbTree.insert(150);
        rbTree.insert(25);
        rbTree.insert(45);
        rbTree.insert(200);
        rbTree.insert(175);

        rbTree.insert(125);
        rbTree.insert(135);

        System.out.println(rbTree);

    }
}
