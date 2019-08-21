package cn.chen.java.thread.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OOMDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(OOMDemo::run);
            // 不停地添加任务，内部的堵塞队列最大添加Integer.MAX_VALUE个任务，内存过大造成OutOfMemoryError
        }
        executorService.shutdown();
    }
    private static void run() {}
}
