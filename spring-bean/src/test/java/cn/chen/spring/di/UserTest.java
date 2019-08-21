package cn.chen.spring.di;

import cn.chen.spring.BeanLife;
import cn.chen.spring.config.BeanConfig;
import cn.chen.spring.di.impl.Play;
import cn.chen.spring.di.impl.Study;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {
    @Test
    public void userDiTest() {
        Action play = new Play();
        Action study = new Study();
        User user = new User(play);
        user.doSomeString();
        User user1 = new User(study);
        user1.doSomeString();
    }


    @Test
    public void springBeanTest() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        User user = annotationConfigApplicationContext.getBean(User.class);
        user.doSomeString();
        System.out.println(annotationConfigApplicationContext.getBean(BeanLife.class));
    }

}
