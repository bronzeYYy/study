package cn.chen.spring.tx;

import cn.chen.spring.tx.config.RootConfig;
import cn.chen.spring.tx.service.OrderService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class DaoTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(RootConfig.class);

    @Test
    public void mapperTest() {
        OrderService orderService = annotationConfigApplicationContext.getBean(OrderService.class);

        System.out.println(orderService.getClass());

//        System.out.println(annotationConfigApplicationContext.getBean("orderDao"));
//        System.out.println(RootConfig.class.getAnnotations());
        /*MapperFactoryBean m = new MapperFactoryBean(OrderDao.class);
        System.out.println(m.getMapperInterface().getName());*/
    }

    @Test
    public void txTest() {
        OrderService orderService = annotationConfigApplicationContext.getBean(OrderService.class);
        try {
            orderService.buy();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}
