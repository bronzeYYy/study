package cn.chen.java.design.proxy;

public class Rice implements Food{
    @Override
    public void eat() {
        System.out.println("eat: 米饭");
    }
}
