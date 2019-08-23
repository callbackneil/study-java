package org.neil.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2018/5/16
 */
public class TestController2 {

    static {
        System.out.println("TestController2");
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("TestController2.main");
    }
}
