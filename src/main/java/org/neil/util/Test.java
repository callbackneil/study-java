package org.neil.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.neil.domain.ActivityGiftProductVO;

/**
 * @author neil
 * @date 2018/7/27
 */
public class Test {
    public static void main(String[] args) {
        Integer sendGiftCount=1;  // 赠送款数
        Integer sendPersonCount=null; // 赠送人数
        Integer sendPersonCountFinal=0;
        List<ActivityGiftProductVO> list = new ArrayList<ActivityGiftProductVO>(){};
        ActivityGiftProductVO product1 = new ActivityGiftProductVO();
        product1.setGiftSendCount(1);
        product1.setGiftCount(250);
        list.add(product1);
//        ActivityGiftProductVO product2 = new ActivityGiftProductVO();
//        product2.setGiftSendCount(1);
//        product2.setGiftCount(250);
//        list.add(product2);
//        ActivityGiftProductVO product3 = new ActivityGiftProductVO();
//        product3.setGiftSendCount(1);
//        product3.setGiftCount(230);
//        list.add(product3);
//        ActivityGiftProductVO product4 = new ActivityGiftProductVO();
//        product4.setGiftSendCount(1);
//        product4.setGiftCount(270);
//        list.add(product4);
//        ActivityGiftProductVO product5 = new ActivityGiftProductVO();
//        product5.setGiftSendCount(1);
//        product5.setGiftCount(270);
//        list.add(product5);
//        ActivityGiftProductVO product6 = new ActivityGiftProductVO();
//        product6.setGiftSendCount(1);
//        product6.setGiftCount(230);
//        list.add(product6);

        sendPersonCountFinal = check(sendGiftCount, sendPersonCountFinal, list);
        if(sendPersonCount == null){
            sendPersonCount = sendPersonCountFinal;
        }
        if(!sendPersonCountFinal.equals(sendPersonCount) || list.size()>0){
            System.out.println(sendPersonCount+" "+sendPersonCountFinal);
            System.out.println(list.size());
            System.out.println(false);
        }else {
            System.out.println(true);
        }

//            int level = 1;
//            for(int i=0;i<10;i++){
//                System.out.println(level++);
//            }

    }

    private static int check(int sendGiftCount, int sendPersonCountFinal, List<ActivityGiftProductVO> list) {
        List<ActivityGiftProductVO> sublist = new ArrayList<>(sendGiftCount);
        if(list.size()< sendGiftCount){
            return sendPersonCountFinal;
        }
        for(int i=0;i<sendGiftCount;i++){
            ActivityGiftProductVO product = list.get(i);
            sublist.add(product);
        }
        sublist.sort(Comparator.comparingInt(ActivityGiftProductVO::getCount));
        int min = sublist.get(0).getCount();
        for(int i=0;i<sendGiftCount;i++){
            ActivityGiftProductVO product = list.get(i);
            product.setCount(product.getCount()-min);
        }
        Iterator<ActivityGiftProductVO> listIterator = list.iterator();
        List<ActivityGiftProductVO> newList = new ArrayList<>();
        while(listIterator.hasNext()){
            ActivityGiftProductVO product =listIterator.next();
            if(product.getCount() > 0){
                newList.add(product);
            }
        }
        sendPersonCountFinal += min;
        if(list.size() >= sendGiftCount){
            sendPersonCountFinal = check(sendGiftCount, sendPersonCountFinal, newList);
        }
        return sendPersonCountFinal;

    }


}
