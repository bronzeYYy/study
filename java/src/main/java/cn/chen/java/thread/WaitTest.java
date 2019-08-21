package cn.chen.java.thread;

// 用来测试wait中的两个线程哪个被唤醒
public class WaitTest implements Runnable {
    private final Object object = new Object();
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 开始");
        synchronized(object) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": 继续");
    }

    public static void main(String[] args) {
        WaitTest runnable = new WaitTest();
        new Thread(runnable).start();
        new Thread(runnable).start();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("唤醒");
        synchronized(runnable.object) {
            runnable.object.notify();
        }
        // 结果：随机唤醒一个线程
    }
}
