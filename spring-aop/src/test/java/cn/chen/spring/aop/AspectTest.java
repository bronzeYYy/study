package cn.chen.spring.aop;

import cn.chen.spring.aop.service.CourseService;
import cn.chen.spring.aop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserService.class)
public class AspectTest {
    private UserService userService;
    private CourseService courseService;
//    private CourseServiceImpl courseServiceImpl;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    /*@Autowired
    public void setCourseServiceImpl(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }*/
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Test
    public void beforeTest() {

        System.out.println(userService.getClass().getName()); // cn.chen.spring.aop.service.UserService$$EnhancerBySpringCGLIB$$ae64844f
        userService.addUser();
    }

    @Test
    public void jdkTest() {
        System.out.println(courseService.getClass().getName()); // com.sun.proxy.$Proxy20
        courseService.addCourse();
    }


}
