package cn.chen.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static synchronized void run() {
        System.out.println("run");
        run1();
    }
    private static synchronized void run1() {
        System.out.println("run1");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(LockTest::run1);
        service.execute(LockTest::run);
        service.shutdown();
    }
}
