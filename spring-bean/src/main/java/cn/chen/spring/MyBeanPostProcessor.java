package cn.chen.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor() {
        System.out.println("创建MyBeanPostProcessor");
        // 实现BeanPostProcessor接口的最先创建
        // 有多个BeanPostProcessor的实现类，它们的初始方法都会执行
    }
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        // o为spring创建的bean对象
        // s为beanName
        System.out.println("6.postProcessBeforeInitialization");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("8.postProcessAfterInitialization");
        // 执行完这个步后，bean可以使用了
        return o;
    }
}
