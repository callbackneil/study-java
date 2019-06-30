package org.neil.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhangzhen on 2019/6/12.
 */
public class JDKProxy implements InvocationHandler {

    private Object proxyInterface;

    public JDKProxy(Object proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 自己的增强代码
        System.out.println("this is a proxy");
        return method.invoke(proxyInterface,args);
    }

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy(new ProxyA());
        ProxyInterface proxyInterface = (ProxyInterface)Proxy.newProxyInstance(ProxyA.class.getClassLoader(),new Class[]{ProxyInterface.class},jdkProxy);
        proxyInterface.method();
    }


}


class ProxyA implements ProxyInterface{

    @Override
    public void method() {
        System.out.println("this is a class");
    }
}
