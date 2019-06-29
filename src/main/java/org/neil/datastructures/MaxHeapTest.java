package org.neil.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2019-02-22
 */
public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        maxHeap.insert(100);
//        maxHeap.insert(90);
//        maxHeap.insert(80);
//        maxHeap.insert(70);
//        maxHeap.insert(60);
//        maxHeap.insert(40);
//        maxHeap.insert(30);
//        maxHeap.insert(20);
//        maxHeap.insert(10);
//        maxHeap.insert(50);
//        System.out.println(maxHeap);
//        maxHeap.insert(85);
//        System.out.println(maxHeap);
//        maxHeap.remove(90);
//        System.out.println(maxHeap);
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(20);
        list.add(30);
        list.add(50);
        list.add(40);
        list.add(10);
        list.add(60);
        list.add(80);
        list.add(70);
        list.add(90);

        list =  maxHeap.adjust2MaxHeap(list,list.size());

        System.out.println(list);


    }
}
