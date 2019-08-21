package cn.chen.java.design.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(Singleton::getInstance);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> System.out.println(getInstance()));
        }
        service.shutdown();
    }
    private static volatile Singleton singleton;
    // volatile禁止指令重排序，创建对象不是原子操作，有3个步骤
    // 1.在堆区分配内存
    // 2.进行初始化
    // 3.将变量指向堆区的对象
    // CPU可能会将2和3进行重排序，造成的结果：
    // 其它线程获取到的对象虽然不是null，但还没有初始化完成，然后使用出现错误
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized(Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton(); // new这一步不是原子操作
                }
            }
        }
        return singleton;
    }
    private Singleton() {}
}
