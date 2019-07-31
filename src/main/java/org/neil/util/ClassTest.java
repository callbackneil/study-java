package org.neil.util;

/**
 * Created by zhangzhen on 2019/7/17.
 */
public class ClassTest {


    /**
     * 把static变量的加载和初始化赋值分成了两步
     * 按顺序把static块的代码合并
     */

    static {
        c = 2;
    }
    public static int c = 1;
    static {
        c = 3;
    }

    /**
     * 上下等价
     */
//    public static int c;
    static {
        c = 1;
        c = 2;
        c = 3;
    }




    public static void main(String[] args) {
        boolean hasNext = false;
        int count = 0;
        hasNext = count > 0;

    }


}


