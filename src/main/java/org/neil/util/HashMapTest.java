//package org.neil.util;
//
//import java.util.HashMap;
//
///**
// * Created by zhangzhen on 2019/6/25.
// */
//public class HashMapTest<K,V> {
//
//    transient int size  = 0;
//    private Entry<K,V>[] table = null;
//
//    public V put(K key, V value) {
//        if (table == null) {
//            table = new Entry[16];
//        }
//        int hash = hash(key);
//        int i = indexFor(hash, table.length);
//        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
//            Object k;
//            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
//                V oldValue = e.value;
//                e.value = value;
//                return oldValue;
//            }
//        }
//
//        addEntry(hash, key, value, i);
//        return null;
//    }
//    public static final int indexFor(int h, int length) {
//        return h & length - 1;
//    }
//    void addEntry(int hash, K key, V value, int bucketIndex) {
//        if ((size >= (int)0.75*table.length) && (null != table[bucketIndex])) {
//            resize(2 * table.length);
//            hash = (null != key) ? hash(key) : 0;
//            bucketIndex = indexFor(hash, table.length);
//        }
//
//        createEntry(hash, key, value, bucketIndex);
//    }
//    void createEntry(int hash, K key, V value, int bucketIndex) {
//        Entry<K,V> e = table[bucketIndex];
//        table[bucketIndex] = new Entry<>(hash, key, value, e);
//        size++;
//    }
//    void resize(int newCapacity) {
//        Entry[] newTable = new Entry[newCapacity];
//        transfer(newTable, false);
//        table = newTable;
//
//    }
//
//    void transfer(Entry[] newTable, boolean rehash) {
//        int newCapacity = newTable.length;
//        for (Entry<K,V> e : table) {
//            while(null != e) {
//                Entry<K,V> next = e.next;
//                if (rehash) {
//                    e.hash = null == e.key ? 0 : hash(e.key);
//                }
//                int i = indexFor(e.hash, newCapacity);
//                e.next = newTable[i];
//                newTable[i] = e;
//                e = next;
//            }
//        }
//    }
//
//    final int hash(Object k) {
//        int h = 0;
//        h ^= k.hashCode();
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
//    }
//
//    static class StringHash{
//        private int i;
//
//        public StringHash(int i) {
//            this.i = i;
//        }
//
//        @Override
//        public int hashCode() {
//            return (int) (Math.random()*50+1);
//        }
//    }
//
//
//    static class Entry<K,V>{
//        K key;
//        V value;
//        Entry<K,V> next;
//        int hash;
//
//        public Entry(int hash, K key, V value, Entry<K, V> next) {
//            this.key = key;
//            this.value = value;
//            this.next = next;
//            this.hash = hash;
//        }
//
//        public K getKey() {
//            return key;
//        }
//
//        public void setKey(K key) {
//            this.key = key;
//        }
//
//        public V getValue() {
//            return value;
//        }
//
//        public void setValue(V value) {
//            this.value = value;
//        }
//
//        public Entry<K, V> getNext() {
//            return next;
//        }
//
//        public void setNext(Entry<K, V> next) {
//            this.next = next;
//        }
//
//        public int getHash() {
//            return hash;
//        }
//
//        public void setHash(int hash) {
//            this.hash = hash;
//        }
//    }
//
//
//    public static void main(String[] args) {
//        HashMap<StringHash,String> map = new HashMap<>();
//        for (int i =0;i<1000;i++){
//            StringHash stringHash = new StringHash(i);
//            if(i == 10){
//                System.out.println(i);
//            }
//            map.put(stringHash,""+i);
//        }
//        System.out.println(map);
//
//    }
//}
