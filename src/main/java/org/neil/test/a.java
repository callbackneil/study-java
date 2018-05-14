package org.neil.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author neil
 * @date 2018/5/8
 */
public class a {

//    0000002,678,400,000
    //
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Long storeDateEnd = System.currentTimeMillis();

        Long storeDateStart =  (storeDateEnd - (31 * 24 * 3600 * 1000));

        Date date2 = new Date();
        date2.setTime(storeDateEnd);
        System.out.println("storeDateEnd"+simpleDateFormat.format(date2)+"  "+storeDateEnd);
        date2.setTime(storeDateStart);
        System.out.println("storeDateStart"+simpleDateFormat.format(date2)+"  "+storeDateStart);

    }
}
