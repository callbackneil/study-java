package org.neil.jvm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhangzhen on 2019/7/18.
 */
public class ClassLoaderRun {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        // 初始化场景1
        // new 创建对象时需要先初始化 对应字节码new
//        ClassLoaderInit init = new ClassLoaderInit();
        // 获取类变量时需要先初始化 对应字节码getstatic
//        int a = ClassLoaderInit.a;
        // 设置类变量时需要先初始化 对应字节码putstatic
//        ClassLoaderInit.a = 2;

        // 执行类的static方法时时需要先初始化 对应字节码invokestatic
//        ClassLoaderInit.b();

        // 初始化场景2
        // Class.forName会初始化 因为默认去初始化forName0(className, true, ClassLoader.getClassLoader(caller), caller);
//        Class.forName("org.neil.jvm.ClassLoaderInit");
        // 反射执行该类的方法 获取该类的类变量时 下面第一句不会初始化 第二句才会初始化
        // 反射调用类的方法 包括static方法和非static方法
//        Method b = ClassLoaderInit.class.getMethod("b");
//        b.invoke(new Object());
//        Method c = ClassLoaderInit.class.getMethod("c");
//        c.invoke("");
        // 反射调用构造器
//        Constructor<?>[] constructors = ClassLoaderInit.class.getConstructors();
//        constructors[0].newInstance();
        // 反射获取类的变量 包括static变量和非static变量
        Field b = ClassLoaderInit.class.getField("a");
        b.setInt("",2);
//        b.getInt("");

    }
}
