package org.neil.controller;

import org.neil.domain.TestDomainWapper;
import org.neil.manager.TestManager;
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
    private TestManager testManager;

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public Object argumentResolverController(TestDomainWapper testDomainWapper) {
        return testDomainWapper;
    }

    @RequestMapping(value = "test3", method = RequestMethod.GET)
    public Object asyncTest() {
        System.out.println("执行异步方法调用前");
        testManager.asnyTest();
        System.out.println("执行异步方法调用后");
        return "success";
    }


}
