package org.neil.util;


import org.neil.domain.TestDomain;
import org.neil.domain.TestDomainAnother;

/**
 *
 * @author zhangzhen
 * @version $Id: TestDomainAnotherConverter.java, v 0.1 2018-05-23 22:11:49 zhangzhen Exp $$
 */
public class TestDomainAnotherConverter {

    /**
     * Convert TestDomain to TestDomainAnother
     * @param testDomain
     * @return
     */
    public static TestDomainAnother convertToTestDomainAnother(TestDomain testDomain) {
        if (testDomain == null) {
            return null;
        }
        TestDomainAnother testDomainAnother = new TestDomainAnother();

        testDomainAnother.setId(testDomain.getId());
        testDomainAnother.setField(testDomain.getField());
        testDomainAnother.setIdList(testDomain.getIdList());

        return testDomainAnother;
    }

    /**
     * Convert TestDomainAnother to TestDomain
     * @param testDomainAnother
     * @return
     */
    public static TestDomain convertToTestDomain(TestDomainAnother testDomainAnother) {
        if (testDomainAnother == null) {
            return null;
        }
        TestDomain testDomain = new TestDomain();

        testDomain.setId(testDomainAnother.getId());
        testDomain.setField(testDomainAnother.getField());
        testDomain.setIdList(testDomainAnother.getIdList());

        return testDomain;
    }
}
