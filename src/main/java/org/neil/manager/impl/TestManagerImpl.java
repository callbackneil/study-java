package org.neil.manager.impl;

import org.neil.manager.TestManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author neil
 * @date 2019-07-03
 */
@Service
public class TestManagerImpl implements TestManager {


    @Async("taskExecutor")
    @Override
    public void asnyTest() {

        try {
            Thread.sleep(10000);
            System.out.println("异步方法调用测试");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
