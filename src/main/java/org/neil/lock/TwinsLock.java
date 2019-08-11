package org.neil.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by zhangzhen on 2019/8/5.
 */
public class TwinsLock implements Lock{
    private Sync sync = new Sync(2);

    public TwinsLock() throws Exception {
    }


    @Override
    public void lock() {
        sync.acquireShared(1);
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }


    @Override
    public boolean tryLock() {
        return false;
    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public void unlock() {
        sync.releaseShared(1);
    }


    @Override
    public Condition newCondition() {
        return null;
    }

    private class Sync extends AbstractQueuedSynchronizer{

        public Sync() {
        }
        public Sync(int count) throws Exception {
            if(count <= 0){
                throw new Exception(" error");
            }
            setState(count);
        }


        @Override
        protected boolean tryReleaseShared(int arg) {
            for(;;){
                int currentState = getState();
                int newState =currentState + arg;
                // 自旋尝试释放
                if(compareAndSetState(currentState,newState)){
                    return true;
                }
            }
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (;;){
                int currentState = getState();
                int newState =currentState - arg;
                // 若newState < 0 返回表示获取失败 否则原子操作尝试获取同步状态
                if(newState < 0 || compareAndSetState(currentState,newState)){
                    return newState;
                }
            }
        }
    }
}
