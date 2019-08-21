package cn.chen.java.thread.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorDemo {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Condition condition1 = lock.newCondition();
    private final CountDownLatch countDownLatch = new CountDownLatch(2);
    private int num;
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        ExecutorDemo executorDemo = new ExecutorDemo();
        executor.execute(executorDemo::do1);
        executor.execute(executorDemo::do2);


        try {
            executorDemo.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");

        executor.shutdown();
    }
    private void do1() {
        lock.lock();
        try {
            //condition.await();
            System.out.println("继续执行2");
            /*while (num != 2) {
                System.out.println("num != 2");
                //condition1.signal();

            }*/
            Thread.sleep(1000L);
            System.out.println("do1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            countDownLatch.countDown();
        }
    }
    private void do2() {
        lock.lock();
        try {
            //condition1.await();
            System.out.println("继续执行1");
            /*while (num != 1) {
                System.out.println("num != 1");
                //condition.signal();

            }*/
        } finally {
            lock.unlock();
            countDownLatch.countDown();
        }
    }
    private void do3() {
        synchronized (lock) {
            while (num != 1) {
                System.out.println("num != 1");
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void do4() {
        synchronized (lock) {
            while (num != 2) {
                System.out.println("num != 2");
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
