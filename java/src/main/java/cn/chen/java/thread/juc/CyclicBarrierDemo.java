package cn.chen.java.thread.juc;

import java.util.concurrent.*;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int nThreads = 10;
        ExecutorService service = Executors.newFixedThreadPool(nThreads);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, ()->{
            System.out.println("所有线程已就绪");
        });
        for (int i = 0; i < nThreads; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ": 开始执行");
                try {
                    cyclicBarrier.await(); // 等待所有线程到达，计数器-1，线程等待
                    // 所有线程都到达此处，然后这些线程一起继续执行
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": 继续执行");
            });
        }
        service.shutdown();
    }
}
