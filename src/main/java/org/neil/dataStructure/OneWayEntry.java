package org.neil.dataStructure;

/**
 * Created by zhangzhen on 2019/6/27.
 */
public class OneWayEntry<T> {

    public static void main(String[] args) {
        OneWayEntry<Integer> oneWayEntry = new OneWayEntry<>();
        oneWayEntry.add(1);
        oneWayEntry.add(2);
        oneWayEntry.add(3);
        oneWayEntry.add(4);
        System.out.println(oneWayEntry);
    }


    private Entry<T> root;

    private Entry<T>[] table;


    public boolean add(T t){
//        Entry<T> last = root;
//        Entry<T> pre = null;
//        while (last != null){
//            pre = last;
//            last = last.next;
//        }
//        if(pre == null){
//            root = new Entry<>(t,null);
//            return true;
//        }
//        pre.next = new Entry<>(t,null);

//        Entry<T> e = root;
//        if(e == null){
//            root = new Entry<>(t,null);
//            return true;
//        }
//        while (e.next != null){
//            e = e.next;
//        }
//        e.next =  new Entry<>(t,null);
        Entry<T> entry = new Entry<>(t,null);
        if(root == null){
            root = entry;
            return true;
        }
        add(root,entry);
        return true;
    }

    private void add(Entry<T> pre,Entry<T> entry){
        if(pre == null){
            return;
        }
        if (pre.next != null){
            add(pre.next,entry);
            return;
        }
        pre.next = entry;

    }

    public Entry<T> getEntry() {
        return root;
    }

    public void setEntry(Entry<T> entry) {
        this.root = entry;
    }

    private class Entry<T>{

        private T t;
        private Entry<T> next;

        public Entry(T t, Entry<T> next) {
            this.t = t;
            this.next = next;
        }

        public Entry<T> getNext() {
            return next;
        }

        public void setNext(Entry<T> next) {
            this.next = next;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }
}
