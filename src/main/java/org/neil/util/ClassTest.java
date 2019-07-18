package org.neil.util;

/**
 * Created by zhangzhen on 2019/7/17.
 */
public class ClassTest {
    static {
        c = 2;
        System.out.println("test");
    }
    public static int c = 1;
    public final static int d = 1;
    int a = 1;
    int b = 0;

    {
        b = 2;
    }
    static {
        System.out.println("c="+c);
        System.out.println("d="+d);
    }
    public ClassTest() {
      b= 3;
    }

    public ClassTest(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void test(){
    }

    public static void main(String[] args) {
    }
}


