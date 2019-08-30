package cn.chen.java.thread;

public class ThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(ThreadState::run);
        Thread thread1 = new Thread(ThreadState::run);
        thread.start();
        thread1.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 线程1等待获取锁，状态为BLOCKED
        System.out.println(thread1.getState());
    }
    private synchronized static void run() {
        try {
            System.out.println("run");
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
