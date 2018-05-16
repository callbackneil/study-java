package org.neil.controller;

import org.neil.domain.TestDomain;
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


    @RequestMapping(value = "argumentResolver",method = RequestMethod.GET)
    public Object argumentResolverController(){
        TestDomain t = new TestDomain();
        t.setField("123");
        t.setId(321);
        return t;
    }
}
