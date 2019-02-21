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
        Map<Key,Integer> map = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 50; j++) {
                Key key = new Key(i);
                key.setValue(j);
                Integer oldValue = map.put(key, j);
                System.out.println(oldValue);

            }
        }
        System.out.println(map);


    }

    static class Key{
        private int code;
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Key(int code) {
            this.code = code;
        }

        @Override
        public int hashCode() {
            return code;
        }

        @Override
        public boolean equals(Object key) {
//            if(key instanceof Key){
//                return this.code == ((Key)key).code;
//            }
            return false;
        }
    }
}
