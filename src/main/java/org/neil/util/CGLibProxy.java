package org.neil.util;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangzhen on 2019/6/12.
 */
public class CGLibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("this is proxy 代码");
        methodProxy.invokeSuper(o,objects);
        return null;
    }

    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(cgLibProxy);
        enhancer.setSuperclass(ProxyB.class);
        ProxyB proxyB = (ProxyB)enhancer.create();
        proxyB.method();

    }


}


class ProxyB{
    public void method(){
        System.out.println("this is a class");
    }
}