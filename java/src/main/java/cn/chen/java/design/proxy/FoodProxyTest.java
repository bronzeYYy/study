package cn.chen.java.design.proxy;

import java.util.HashMap;
import java.util.Objects;

public class FoodProxyTest {
    public static void main(String[] args) {
        FoodProxy foodProxy = new FoodProxy();
        Food proxy = (Food) foodProxy.getProxy(new Rice());
        proxy.eat();
        System.out.println("----下一顿饭----");
        proxy = (Food) foodProxy.getProxy(new Noodle());
        proxy.eat();
    }
}
