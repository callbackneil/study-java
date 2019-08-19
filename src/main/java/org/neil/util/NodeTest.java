package org.neil.util;


/**
 * @author neil
 * @date 2019-08-13
 */
public class NodeTest<E> {

    private static transient volatile Node head;
    private static transient volatile Node tail = new Node(1);

    public static void main(String[] args) {
        int i = 100;
        boolean b = i == (i = 10);
        i = 1;
        System.out.println(b);
        System.out.println(i);

        /*
        public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=3, args_size=1
         0: bipush        100
         2: istore_1
         3: iload_1
         4: bipush        10
         6: dup
         7: istore_1
         8: if_icmpne     15
        11: iconst_1
        12: goto          16
        15: iconst_0
        16: istore_2
        17: iconst_1
        18: istore_1
        19: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        22: iload_2
        23: invokevirtual #3                  // Method java/io/PrintStream.println:(Z)V
        26: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        29: iload_1
        30: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
        33: return

         */


        /*
         public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=3, args_size=1
         0: bipush        100
         2: istore_1
         3: iload_1
         4: bipush        10
         6: dup
         7: istore_1
         8: if_icmpeq     15
        11: iconst_1
        12: goto          16
        15: iconst_0
        16: istore_2
        17: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        20: iload_2
        21: invokevirtual #3                  // Method java/io/PrintStream.println:(Z)V
        24: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        27: iload_1
        28: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
        31: return
      LineNumberTable:
        line 19: 0
        line 20: 3
        line 21: 17
        line 22: 24
        line 39: 31
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      32     0  args   [Ljava/lang/String;
            3      29     1     i   I
           17      15     2    b1   Z
      StackMapTable: number_of_entries = 2
        frame_type = 252
        offset_delta = 15
        locals = [ int ]
        frame_type = 64 /
        stack = [ int ]

         */

        /*
        public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=3, args_size=1
         0: bipush        100
         2: istore_1
         3: iload_1
         4: bipush        10
         6: dup
         7: istore_1
         8: if_icmpne     15
        11: iconst_1
        12: goto          16
        15: iconst_0
        16: istore_2
        17: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        20: iload_2
        21: invokevirtual #3                  // Method java/io/PrintStream.println:(Z)V
        24: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        27: iload_1
        28: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
        31: return
      LineNumberTable:
        line 19: 0
        line 20: 3
        line 21: 17
        line 22: 24
        line 82: 31
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      32     0  args   [Ljava/lang/String;
            3      29     1     i   I
           17      15     2    b1   Z
      StackMapTable: number_of_entries = 2
        frame_type = 252
        offset_delta = 15
        locals = [ int ]
        frame_type = 64
        stack = [ int ]


         */


//        head = new Node(null);
//        tail = head;
//        Node t = tail, p = t;
//        Node q = p.next;
//        p = (p != t && t != (t = tail)) ? t : q;
//        System.out.println(p);

//        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        queue.offer(4);
//        queue.offer(5);
//        System.out.println(queue);
    }



    public boolean offer(E e) {
        final Node<E> newNode = new Node<E>(e);
        for (Node<E> t = tail, p = t;;) {
            Node<E> q = p.next;
            if (q == null) {
                if (p.casNext(null, newNode)) {
                    if (p != t) {
                        casTail(t, newNode);
                    }
                    return true;
                }
            } else if (p == q){
                p = (t != (t = tail)) ? t : head;
            } else{
                p = (p != t && t != (t = tail)) ? t : q;
            }
        }
    }

    private boolean casTail(Node<E> cmp, Node<E> val) {
        return true;
    }
    private static class Node<E> {
        volatile E item;
        volatile Node<E> next;

        boolean casNext(Node<E> cmp, Node<E> val) {
            return true;
        }

        public Node(E item) {
            this.item = item;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    }
