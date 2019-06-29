package org.neil.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2019-01-28
 */
public class SortArithmetic {

    public static void main(String[] args) {

        Integer[] array = {9, 0, 3, 4, 6, 7, 2, 1, 5, 8};

        冒泡排序(array);
        简单选择排序(array);
        直接插入排序(array);
        希尔排序(array);
        System.out.println(array);

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
        堆排序(list);
        System.out.println(list);

    }


    /**
     * 父=i 左=2i+1 右=2i+2
     *
     *
     * @param list
     */
    public static void 堆排序(List<Integer> list) {

        for (int i = list.size(); i > 0; i--) {
            MaxHeap<Integer> maxHeap = new MaxHeap<>();
            list =  maxHeap.adjust2MaxHeap(list,i);
            Integer first = list.get(0);
            Integer last = list.get(i-1);
            list.set(0,last);
            list.set(i-1,first);
        }

    }


    /**
     *
     * @param list
     */
    public static void 希尔排序(Integer[] list) {
        for (int gap = list.length/3; gap >= 1 ; gap/=2) {

            for (int i = gap; i < list.length; i++) {
                for (int j = i-gap; j >=0; j-=gap) {
                    int temp;
                    if (list[j] > list[j + gap]) {
                        temp = list[j];
                        list[j] = list[j + gap];
                        list[j + gap] = temp;

                    }
                }

            }
        }
    }


    /**
     *
     *
     * @param list
     */
    public static void 直接插入排序(Integer[] list) {
        for (int i = 1; i < list.length; i++) {

            for (int j = i; j > 0; j--) {
                int temp;
                if (list[j] < list[j - 1]) {
                    temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;

                }
            }

        }
    }


    /**
     * 每次从头找出最小的，然后和头部的交换
     * 时间复杂度 O(n*n)
     * 空间复杂度
     *
     * @param list
     */
    public static void 简单选择排序(Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[min] > list[j]) {
                    min = j;
                }
            }
            Integer temp = list[min];
            list[min] = list[i];
            list[i] = temp;
        }
    }


    /**
     * 从尾部开始两两比较，小的换到前面  从而每次把最小的移动到头部
     * 时间复杂度 O(n*n)
     * 空间复杂度
     *
     * @param list
     */
    public static void 冒泡排序(Integer[] list) {
        boolean isSwap = true;
        for (int i = 0; i < list.length && isSwap; i++) {
            isSwap = false;
            int temp;
            for (int j = list.length - 1; j > i; j--) {
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    isSwap = true;
                }
            }

        }
    }
}
