package org.neil.datastructures;

/**
 * @author neil
 * @date 2019-01-17
 */
public class TestMain {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
//        bsTree.setRootValue(50);

        bsTree.insert(50);
        bsTree.insert(40);
        bsTree.insert(70);

        bsTree.insert(60);
        bsTree.insert(80);
//
        bsTree.insert(55);
        bsTree.insert(65);

        bsTree.insert(85);
        bsTree.insert(75);

        bsTree.insert(79);

        bsTree.insert(82);
        bsTree.insert(86);


        boolean result = bsTree.isFBT();
        System.out.println(result);

        int height = bsTree.getHeight();
//        int leafCount = bsTree.getLeafCount();
//        int nodeCount = bsTree.getNodeCount();
//        int nodeCountK = bsTree.getNodeCount(4);
//        boolean equalsTo = bsTree.equalsTo(bsTree);
//        Integer t = bsTree.getLCA(bsTree.findNode(65), bsTree.findNode(85));
//        Integer t2 = bsTree.getLCA2(bsTree.findNode(65), bsTree.findNode(85));
        System.out.println(height);
//        System.out.println(leafCount);
//        System.out.println(nodeCount);
//        System.out.println(nodeCountK);
//        System.out.println(equalsTo);
//        System.out.println(t);
//        System.out.println(t2);
//        List<Integer> preList = bsTree.preIterate();
//        List<Integer> middleList = bsTree.middleIterate();
//        List<Integer> postList = bsTree.postIterate();
//        List<Integer> tierList = bsTree.tierIterate();
//        System.out.println(1);





//        BinarySearchTree<Integer> targetTree = new BinarySearchTree<>();
//        targetTree.setRootValue(54);
//        targetTree.insert(51);
//        targetTree.insert(59);
//        System.out.println(bsTree);
//        bsTree.replaceLeft(60,targetTree.getRoot());
        System.out.println(bsTree);





//        BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
//        bsTree.setRootValue(50);
//        bsTree.insert(45);
//        bsTree.insert(60);
//        bsTree.insert(55);
//        System.out.println("maxValue = "+bsTree.findMaxValue());
//        System.out.println("minValue = "+bsTree.findMinValue());
//        bsTree.remove(60);
//        System.out.println(bsTree);


//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(100);
//        linkedList.add(99);
//        linkedList.add(98);
//
//        linkedList.add(1,11);


    }
}
