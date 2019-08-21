package cn.chen.java.thread.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int[] a = {1, 2, 3, 4, 5};
        Test test = new Test(a, 0, a.length);
        try {
            System.out.println(forkJoinPool.submit(test).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
// 有返回值的任务
class Test extends RecursiveTask<Integer> {
    private int THRESHOLD = 3;
    private int[] a;
    private int start;
    private int end;

    Test(int[] a, int start, int end) {
        this.a = a;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start < THRESHOLD) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            int mid = (end + start) >> 1;
            Test test1 = new Test(a, start, mid - 1);
            Test test2 = new Test(a, mid, end);
            test1.fork(); // 子线程
            test2.fork();
            return test1.join() + test2.join(); // 等待子线程执行完毕
        }
    }
}