package org.neil.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangzhen on 2019/8/11.
 */
public class ConditionTest {
    // 排它锁
    private Lock lock = new ReentrantLock();
    // 等待通知条件
    private Condition condition = lock.newCondition();

    private List<String> list = new ArrayList<>();

    public void add(String item) throws InterruptedException {
        if(!list.isEmpty()){
            condition.wait();
        }


    }


























}
