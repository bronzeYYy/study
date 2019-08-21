package cn.chen.java.jvm;

public class GcTest {
    public static void main(String[] args) {
        new My();
        System.gc(); // 垃圾回收线程进行回收
        System.out.println(Thread.currentThread().getName() + ": main");
    }
}
class My {
    @Override
    protected void finalize() throws Throwable {
        // 回收时调用这个方法
        System.out.println(Thread.currentThread().getName() + ": my finalize");
    }
}
