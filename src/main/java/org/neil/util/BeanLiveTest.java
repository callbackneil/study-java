package org.neil.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.applet.AppletContext;

/**
 * Created by zhangzhen on 2019/6/15.
 */
public class BeanLiveTest  implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,BeanPostProcessor,InitializingBean,DisposableBean{

    public static void main(String[] args) {
        System.out.println("");
    }

    public BeanLiveTest() {
        System.out.println("构造器方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware-setBeanFactory is-run");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware-setBeanName is-run");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean-destroy is-run");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean-afterPropertiesSet is-run");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor-postProcessBeforeInitialization is-run");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor-postProcessAfterInitialization is-run");
        return o;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware-setApplicationContext is-run");
    }


    public void initMethod() throws BeansException {
        System.out.println("initMethod is-run");
    }

    public void destroyMethod() throws BeansException {
        System.out.println("destroyMethod is-run");
    }


}
