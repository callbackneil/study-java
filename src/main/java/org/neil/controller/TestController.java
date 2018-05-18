package org.neil.controller;

import org.neil.domain.TestDomainWapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author neil
 * @date 2018/5/16
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestDomainWapper testDomainWapper;

    public void setTestDomainWapper(TestDomainWapper testDomainWapper) {
        this.testDomainWapper = testDomainWapper;
    }

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public Object argumentResolverController(TestDomainWapper testDomainWapper) {
        return testDomainWapper;
    }

    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public Object argumentResolverController2() {
        return this.testDomainWapper;
    }

}
