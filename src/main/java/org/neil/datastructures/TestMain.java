package org.neil.datastructures;

/**
 * @author neil
 * @date 2019-01-17
 */
public class TestMain {

    public static void main(String[] args) {
//        BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
//        bsTree.setRootValue(50);
//        bsTree.insert(40);
//        bsTree.insert(70);
//
//        bsTree.insert(60);
//        bsTree.insert(80);
//
//        bsTree.insert(55);
//        bsTree.insert(65);
//
//        bsTree.insert(85);
//        bsTree.insert(75);
//
//        bsTree.insert(79);
//
//        System.out.println(bsTree);
//        bsTree.remove(70);
//        System.out.println(bsTree);



        BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
        bsTree.setRootValue(50);
        bsTree.insert(45);
        bsTree.insert(60);
        bsTree.insert(55);
        System.out.println(bsTree);
        bsTree.remove(60);
        System.out.println(bsTree);

    }
}
