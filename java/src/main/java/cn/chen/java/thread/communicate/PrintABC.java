package cn.chen.java.thread.communicate;


// 三个线程交替打印ABC
public class PrintABC implements Runnable {
    private final Object object = new Object();
    private int i = 0;
    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();
        Thread thread = new Thread(printABC);
        Thread thread1 = new Thread(printABC);
        Thread thread2 = new Thread(printABC);
        thread.start();
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        synchronized(object) {
            while (i++ < 10) {
                System.out.println("A");
                System.out.println("B");
                System.out.println("C");
                object.notifyAll();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            object.notifyAll();  // 任务完成，唤醒所有等待线程
        }
    }
}
