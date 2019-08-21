package cn.chen.spring.di.impl;

import cn.chen.spring.di.Action;
import org.springframework.stereotype.Component;

@Component
public class Study implements Action {
    public void action() {
        System.out.println("学习");
    }
}
