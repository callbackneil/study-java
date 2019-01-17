package org.neil.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author neil
 * @date 2018/8/9
 */
public class Test2 {

    public static void main(String[] args) {

//        List<String> oldlist1 = new ArrayList<>();
//        oldlist1.add("zz");oldlist1.add("zhangZhen");
//        List<String> newlist2 = new ArrayList<>();
//        newlist2.add("neil");newlist2.add("zz");
//
//        Set<String> list1 = new HashSet<>();
//        // 并集
//        list1.addAll(oldlist1);
//        list1.addAll(newlist2);
//        // new独有的
//        list1.removeAll(oldlist1);
//        Set<String> list2 = new HashSet<>();
//        // 并集
//        list2.addAll(oldlist1);
//        list2.addAll(newlist2);
//        // new独有的
//        list2.removeAll(newlist2);
//        // 交集
//        oldlist1.retainAll(newlist2);
//
//        System.out.println(111);
        Map<String,Integer> map = new HashMap<>();
//        map.put("id",new ArrayList<>());
//        map.put("level",1);
//        List list= (List)map.get("id");
//        list.add("12");
        map.put("1",1);
        map.put("2",1);
        map.put("1",2);
        map.put("3",1);
        System.out.println(map);


    }
}
