package org.neil.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.neil.domain.ActivityGiftProductVO;
import org.neil.domain.TestDomainWapper;
import org.neil.domain.UpdateChildLevelVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author neil
 * @date 2018/5/16
 */
@RestController
@RequestMapping("test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);


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

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Object upload(@PathVariable("file") MultipartFile file, UpdateChildLevelVO vo,HttpServletRequest request) {
        System.out.println(file);

        return "";
    }


    @RequestMapping(value = "test5", method = RequestMethod.POST)
    public Object list(@RequestBody ActivityGiftProductVO vo) {
        return vo;
    }



    @Autowired
    private TaskExecutor taskExecutor;
    @RequestMapping(value = "test6", method = RequestMethod.GET)
    public Object list() {
        Integer integer = 0;
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            taskExecutor.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("====");
            });
        }
        Long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));

        return integer;
    }

}
