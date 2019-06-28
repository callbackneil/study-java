package org.neil.位运算;

/**
 * @author neil
 * @date 2019-03-08
 */
public class MainTest {


    public static final int STATUS_OPTIMISTIC = 1;
    public static final int STATUS_OPEN       = 2;
    public static final int STATUS_CLOSE      = 4;

    public static void main(String[] args) {
//        int status = 0;
//
//        // 存储
//        status |= STATUS_CLOSE;
//        System.out.println((status &= STATUS_OPEN) != 0 );
        System.out.println(Integer.MAX_VALUE);
        System.out.println(isOdd(Integer.MAX_VALUE));

    }


    /**
     * 判断奇偶
     * @param x
     * @return true 偶数 false 奇数
     */
    public static boolean isOdd(int x) {
        return ((x >> 1 << 1) ^ x) == 0;
    }


}
