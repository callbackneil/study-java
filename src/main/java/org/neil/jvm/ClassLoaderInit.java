package org.neil.jvm;

/**
 * Created by zhangzhen on 2019/7/18.
 */
public class ClassLoaderInit {

    static {
        System.out.println("初始化");
    }
    public static int a = 1;
    public int b = 1;

    public ClassLoaderInit() {
        System.out.println("构造器");
    }

    public static void b(){
        System.out.println("b");
    }

    public void c(){
        System.out.println("c");
    }
}
