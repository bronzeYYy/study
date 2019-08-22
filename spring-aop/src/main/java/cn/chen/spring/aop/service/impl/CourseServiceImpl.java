package cn.chen.spring.aop.service.impl;

import cn.chen.spring.aop.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    // 实现了接口，将使用jdk动态代理
    @Override
    public void addCourse() {
        System.out.println("addCourse");
    }
    // 实现接口，使用jdk动态代理
    public void delCourse() {
        System.out.println("delCourse");
    }
}
