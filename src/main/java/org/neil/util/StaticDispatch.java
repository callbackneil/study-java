package org.neil.util;

/**
 * @author neil
 * @date 2018/11/13
 */
public class StaticDispatch {

    public static void main(String[] args) {
        Human man = new Men();
        Human women = new Women();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(women);

    }

    public void sayHello(Human human) {
        System.out.println("hi humen");
    }

    public void sayHello(Men human) {
        System.out.println("hi men");
    }

    public void sayHello(Women human) {
        System.out.println("hi women");
    }
}

class Human {

}

class Men extends Human {

}

class Women extends Human {

}
