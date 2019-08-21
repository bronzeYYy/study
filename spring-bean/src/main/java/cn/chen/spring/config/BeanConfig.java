package cn.chen.spring.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cn.chen.spring") // 自动扫描含有bean注解的bean
public class BeanConfig {

    /*@Bean // 手动配置bean
    public User user() {
        return new User();
    }*/
}
