package org.neil.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.neil.domain.TestDomainWapper;
import org.neil.domain.UpdateChildLevelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Object argumentResolverController2() throws Exception {
        System.out.println("1234");
        System.out.println("test");
        System.out.println("test");
        System.out.println("张振");
        throw new Exception("");
        //        return this.testDomainWapper;
    }

    @RequestMapping(value = "test3", method = RequestMethod.POST)
    public Object updateActivityChildLevel(@RequestBody List<UpdateChildLevelVO> list,String memo) {
        System.out.println(memo);
        System.out.println(list);
        return "";
    }


//    @RequestMapping(value = "test3", method = RequestMethod.POST)
//    public Object test(@RequestBody List<UpdateChildLevelVO> list) {
//
//        return "";
//    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Object login(HttpServletRequest request) {
        HttpSession s = request.getSession();
        s.setAttribute("123","test");
        s.setMaxInactiveInterval(1000000);
        return "";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public Object logout(HttpServletRequest request) {
        String s = (String) request.getSession().getAttribute("123");
        System.out.println("zhangzhen"+s);
        return s;
    }


    @RequestMapping(value = "test4", method = RequestMethod.POST)
    public Object list(@RequestBody List<Integer> list,String memo) {
        System.out.println(memo);
        System.out.println(list);
        return "";
    }


}
