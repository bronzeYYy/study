package cn.chen.spring.data.jpa.dao;

import cn.chen.spring.data.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {

    User findUserByName(String name);
}
