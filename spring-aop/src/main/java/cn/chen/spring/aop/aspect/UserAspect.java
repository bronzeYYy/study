package cn.chen.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
    // @Before 为通知（advice）
    // 切面（aspect）是通知（advice）和切点（pointcut）的结合
    // execution(返回值类型 方法名(参数类型))   这一条表达式为切点（pointcut）
    // 连接点（join point）：能够插入切面的一个点
    // 引入（introduction）：允许向现有的类添加新的功能
    // 织入（weaving）：把切面运用到目标对象并创建代理对象的过程
    @Before("execution(* cn.chen.spring.aop.service.UserService.addUser())")
    public void before() {
        System.out.println("beforeAddUser");
    }

    @Before("execution(* cn.chen.spring.aop.service.CourseService.*())")
    public void courseJdk() {
        System.out.println("beforeAddCourse");
    }


}
