package cn.chen.spring.tx.service.impl;

import cn.chen.spring.tx.dao.OrderDao;
import cn.chen.spring.tx.service.OrderService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    @Override
    public boolean buy() {
        if (orderDao.subMoney() == 1) {
            if (addSuccess()) {
                return true;
            }
            throw new RuntimeException();
            // 在此处捕获这个异常则不回滚，需向上抛出回滚，调用者可以捕获
            // 未回滚，原因：没有启用事务管理（@EnableTransactionManagement）
        }
        return false;
    }

    boolean subMoney() {
        return orderDao.subMoney() == 1;
    }

    boolean addSuccess() {
//        throw new RuntimeException();
        return false;
//        return orderDao.addSuccess() == 1;
    }
}
