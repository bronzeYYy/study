package cn.chen.java.thread;

public class ThreadStateDemo implements Runnable{
    private static final Object o = new Object();

    @Override
    public void run() {
        synchronized (o) {
            try {
                // 线程0到达此处，线程1等待线程0释放锁，线程2状态为BLOCKED
                Thread.sleep(300L); // 语句1
                // 线程0到达此处，状态为WAITING并释放锁，线程1获取到锁执行语句1
                o.wait(100);
                // 线程1还未到达wait()时，主线程唤醒线程0，线程0继续执行
                Thread.sleep(100L); // 语句3
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadStateDemo(), "线程0");
        Thread thread1 = new Thread(new ThreadStateDemo(), "线程1");
        System.out.println(thread.getName() + thread.getState()); // NEW
        thread.start();
        thread1.start();
        System.out.println(thread.getName() + thread.getState()); // RUNNABLE
        try {
            Thread.sleep(400L); // 延迟400ms，此时线程0进入wait并释放锁，线程1拿到锁执行语句1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName() + thread.getState()); // WAITING
        System.out.println(thread1.getName() + thread1.getState()); // TIMED_WAITING
        // 主线程等待锁直到线程1进入wait释放锁
        synchronized (o) {
            o.notifyAll(); // 唤醒两个线程
        }
        System.out.println(thread.getName() + thread.getState()); // 拿到锁的线程进入语句3，另一个线程则BLOCKED
        try {
            thread.join(); // 等待执行完毕，主线程状态为TIMED_WAITING
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*synchronized(thread) {
            while (thread.isAlive()) {
                // 不停的进行判断，防止被假唤醒
                try {
                    thread.wait(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/
        System.out.println(thread.getName() + thread.getState()); // TERMINATED

    }
}
