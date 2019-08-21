package cn.chen.java.design.singleton;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Singleton {
    public static void main(String[] args) {
        /*ExecutorService service = Executors.newCachedThreadPool();
        service.execute(Singleton::getInstance);
        for (int i = 0; i < 10; i++) {
            service.execute(Singleton::getInstance);
        }
        service.shutdown();*/
        /*System.out.println(null instanceof Object);
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, null);
        String s = "12";
        System.out.println(s.hashCode());*/
//        System.out.println(Integer.valueOf(1) == Integer.valueOf(1)); //true
        System.out.println();
    }
    private int i;
    private static Singleton singleton;
    // volatile禁止指令重排序，创建对象有几个步骤
    public static Singleton getInstance() {
        if (singleton == null) {
            System.out.println(Thread.currentThread().getName() + ": 进入第一个判断");
            try {
                Thread.sleep(20L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(Singleton.class) {
                if (singleton == null) {
                    System.out.println(Thread.currentThread().getName() + ": 创建单例");
                    singleton = new Singleton();
                }
            }
        }
        System.out.println(singleton);
        System.out.println(singleton.i);
        return singleton;
    }
    private Singleton() {}
}
