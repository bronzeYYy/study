package cn.chen.spring.aop.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@Service
@ComponentScan("cn.chen.spring")
@EnableAspectJAutoProxy
public class UserService {
    // 为这个类进行代理，使用cglib，设置类为final不可继承则报错
    // 如果实现接口，则使用jdk动态代理
    public void addUser() {
        System.out.println("addUser");
    }
}
