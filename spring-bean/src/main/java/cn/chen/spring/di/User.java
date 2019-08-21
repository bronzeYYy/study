package cn.chen.spring.di;

import cn.chen.spring.di.impl.Play;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class User {
    private Action action;

    @Autowired(required = false) // 自动注入所需要的其它类
    // 指定required = false时，发现容器中没有所需要的bean，会执行无参构造（存在的这个构造的情况）
    public User(Action action) { // 注入
        this.action = action;
    }
    //
    public User() {
        this.action = new Play(); // 紧耦合
    }

    void doSomeString() {
        action.action();
    }
}
