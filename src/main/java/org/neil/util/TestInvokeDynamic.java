package org.neil.util;

import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Created by zhangzhen on 2019/4/28.
 */
public class TestInvokeDynamic {

    static class GrandFather{
        public void thing(){
            System.out.println("I am grandfather");
        }
    }
    static class Father extends GrandFather{
        public void thing(){
            System.out.println("I am father");
        }
    }

    static class Son extends Father{

        public void thing(){
//            GrandFather grandFather = new GrandFather();
//            grandFather.thing();

            MethodType methodType = MethodType.methodType(Void.class);

        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.thing();
    }

}
