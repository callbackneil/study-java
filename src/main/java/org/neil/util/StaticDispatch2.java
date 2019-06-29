package org.neil.util;

/**
 * @author neil
 * @date 2018/11/13
 */
public class StaticDispatch2 {

    public static void main(String[] args) {
        Human2 man = new Men2();
        Human2 women = new Women2();
        man.sayHello();
        women.sayHello();

    }






}

class Human2 {
    public void sayHello() {
        System.out.println("hi humen");
    }
}

class Men2 extends Human2 {
    public void sayHello() {
        System.out.println("hi men");
    }
}

class Women2 extends Human2 {
    public void sayHello() {
        System.out.println("hi women");
    }
}
