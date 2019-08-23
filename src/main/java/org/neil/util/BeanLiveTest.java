package org.neil.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by zhangzhen on 2019/6/15.
 */
public class BeanLiveTest  implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,BeanPostProcessor,InitializingBean,DisposableBean{
    public BeanLiveTest() {
        System.out.println("构造器方法");
    }

    private BeanLiveProperty beanLiveProperty;

    public void setBeanLiveProperty(BeanLiveProperty beanLiveProperty) {
        this.beanLiveProperty = beanLiveProperty;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware-setBeanName is-run");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware-setBeanFactory is-run");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware-setApplicationContext is-run");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean-afterPropertiesSet is-run");
    }

    public void initMethod() throws BeansException {
        System.out.println("initMethod is-run");
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
    public void destroy() throws Exception {
        System.out.println("DisposableBean-destroy is-run");
    }

    public void destroyMethod() throws BeansException {
        System.out.println("destroyMethod is-run");
    }

    public static void main(String[] args) {
        System.out.println("main is run");
    }



}
