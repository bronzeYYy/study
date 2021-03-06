package cn.chen.java.thread.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(3, 6, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
                        (r, executor) -> System.out.println("拒绝添加"));
        for (int i = 0; i < 9; i++) {
            threadPoolExecutor.execute(ThreadPoolExecutorDemo::run);
            // i为3时核心线程数达到最大，此时添加到队列中
            // i为5时核心线程和队列都满，再添加任务则再开启线程执行
            // i为8时队列，和最大线程都满了，再进行添加则执行拒绝添加策略
        }
        threadPoolExecutor.shutdown();
        // 输出结果为： 8个run，1个拒绝添加。
    }
    private static void run() {
        System.out.println("run");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
