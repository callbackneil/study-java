package org.neil.util;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author neil
 * @date 2019-06-15
 */
public class SpringInitTest implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet is run");
//        throw new Exception("afterPropertiesSet exception");
    }

    public void initMethod() throws Exception {
        System.out.println("initMethod is run");
    }

}





