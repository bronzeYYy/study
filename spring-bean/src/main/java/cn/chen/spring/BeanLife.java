package cn.chen.spring;

import cn.chen.spring.di.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// 测试bean的生命周期
// 输出顺序如下
/**
 * 还有BeanPostProcessor的两个方法
 * {@link MyBeanPostProcessor}
 *
 */
@Component
public class BeanLife implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    public BeanLife() {
        System.out.println("1.构造");
    }
    @Autowired
    public void setUser(User user) {
        System.out.println("2.注入/设置属性");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4.设置beanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("3.设置beanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5.设置applicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7.设置属性之后");
        // 在这一步之后会执行自定义初始化方法（如果有）
    }

}
