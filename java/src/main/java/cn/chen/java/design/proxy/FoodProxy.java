package cn.chen.java.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FoodProxy implements InvocationHandler {

    private Object o;

    /*
     * create by: chen
     * description: 创建代理对象
     * create time: 18:26 2019-08-21
     * @param o: 需要代理的对象
     * @return java.lang.Object:
     */
    Object getProxy(Object o) {
        this.o = o; // 设置真正需要代理的对象
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("吃饭前：准备碗筷"); // 前置增强
        Object res = method.invoke(o, args); // 在需要代理的对象上调用方法
        System.out.println("吃饭后：刷洗碗筷"); // 后置增强
        return res;
    }
}
