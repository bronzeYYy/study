package cn.chen.java.thread.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// FutureTask是Callable与Future结合
// 需要配合线程一起使用
// new Thread(FutureTask)
// executor.execute(FutureTask)
public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("task");
            Thread.sleep(1000L);
            return "123";
        });
        // 非异步
        // new Thread(futureTask).start()  异步
        futureTask.run();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main");
    }
}
