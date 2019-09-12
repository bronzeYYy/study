package cn.chen.spring.mvc.controller;

import cn.chen.spring.data.jpa.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @PostMapping("/")
    User home(@RequestBody User user) { // json数据自动映射到对象
        System.out.println(user);
        return user;
    }
}
