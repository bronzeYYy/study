package cn.chen.java.thread.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        int nThreads = 10;
        ExecutorService service = Executors.newFixedThreadPool(nThreads);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < nThreads; i++) {
            service.execute(() -> {
                countDownLatch.countDown(); // 计数器-1
                System.out.println(Thread.currentThread().getName() + ": 开始执行");
                try {
                    Thread.sleep(3000L); // 耗时操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": 执行完毕");
            });
        }
        try {
            countDownLatch.await(); // 等待所有线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程执行完毕");
        service.shutdown();
    }
}