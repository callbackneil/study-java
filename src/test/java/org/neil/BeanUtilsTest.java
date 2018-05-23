package org.neil;

import org.junit.Test;
import org.neil.domain.TestDomain;
import org.neil.domain.TestDomainAnother;
import org.neil.domain.TestDomainWapper;
import org.neil.domain.TestDomainWapperAnother;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neil
 * @date 2018/5/23
 */
public class BeanUtilsTest {

    @Test
    public void test() {
        TestDomainWapper testDomainWapper = new TestDomainWapper();
        TestDomain testDomain = new TestDomain();
        testDomain.setId(123);
        testDomain.setField("neil");
        List<String> idList = new ArrayList<>();
        idList.add("231");
        testDomain.setIdList(idList);
        testDomainWapper.setTestDomain(testDomain);
        TestDomainAnother testDomainAnother = new TestDomainAnother();
        TestDomainWapperAnother testDomainWapperAnother = new TestDomainWapperAnother();
        BeanUtils.copyProperties(testDomainWapper, testDomainWapperAnother);
        BeanUtils.copyProperties(testDomain, testDomainAnother);
        System.out.println(testDomainAnother);
        System.out.println(testDomainWapperAnother);
    }
}
