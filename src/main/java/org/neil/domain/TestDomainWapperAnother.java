package org.neil.domain;

/**
 * @author neil
 * @date 2018/5/17
 */
public class TestDomainWapperAnother {

    private Long       id;
    private TestDomain testDomain;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public TestDomain getTestDomain() {
        return testDomain;
    }

    public void setTestDomain(TestDomain testDomain) {

        this.testDomain = testDomain;

    }

    @Override
    public String toString() {
        return "TestDomainWapperAnother{" + "id=" + id + ", testDomain=" + testDomain + '}';
    }
}
