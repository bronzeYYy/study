package cn.chen.java.thread.juc;

import java.util.concurrent.CountDownLatch;

// 测试线程执行到countDownLatch.countDown(); 之后进行等待还是继续执行
// 结果：线程执行到countDownLatch.countDown(); 之后会继续执行。这条语句不会对影响线程的执行
public class CountDownLatchDemo2 {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);
    private static void run1() {
        System.out.println("开始执行");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + ": 执行完毕");
    }
    private static void run2() {
        System.out.println("开始执行");
        countDownLatch.countDown(); // 第二个线程执行到此处不会等待第一个线程
        System.out.println(Thread.currentThread().getName() + ": 执行完毕"); // 第二个县城继续执行
    }

    public static void main(String[] args) {
        Thread thread = new Thread(CountDownLatchDemo2::run1);
        Thread thread1 = new Thread(CountDownLatchDemo2::run2);
        thread.start();
        thread1.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程继续执行");
    }
}
