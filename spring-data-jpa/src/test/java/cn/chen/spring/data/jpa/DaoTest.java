package cn.chen.spring.data.jpa;

import cn.chen.spring.data.jpa.dao.UserDao;
import cn.chen.spring.data.jpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class DaoTest {

    @Autowired
    private UserDao userDao;
    @Test

    public void daoTest() {
        User user = new User();
        user.setId(4);
        user.setName("张三");
        user.setPass("456");
        user.setCourseId(1);
        userDao.delete(user);
        if (userDao.exists("张三")) {
            System.out.println("用户已存在");

        } else {
            System.out.println(userDao.saveAndFlush(user));
        }
    }
}
