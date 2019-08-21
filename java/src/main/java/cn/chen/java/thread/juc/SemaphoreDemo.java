package cn.chen.java.thread.juc;

import java.util.concurrent.*;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ": 获取");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 第一个线程释放锁后，等待的线程可能在第二个线程执行到此处获取到锁
                    System.out.println(Thread.currentThread().getName() + ": 释放");
                    semaphore.release();
                }
            });
        }
        service.shutdown();
    }
}
