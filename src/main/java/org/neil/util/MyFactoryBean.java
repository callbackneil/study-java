package org.neil.util;

import org.neil.domain.TestDomain;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author neil
 * @date 2019-06-15
 */
public class MyFactoryBean extends AbstractFactoryBean<TestDomain> {


    @Override
    public java.lang.Class<?> getObjectType() {
        return TestDomain.class;
    }

    @Override
    protected TestDomain createInstance() throws Exception {
        TestDomain testDomain = new TestDomain();
        testDomain.setField("neil");
        testDomain.setId(1);
        return testDomain;
    }


}
