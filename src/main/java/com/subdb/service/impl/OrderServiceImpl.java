package com.subdb.service.impl;

import com.subdb.dao.OrderDao;
import com.subdb.entity.Order;
import com.subdb.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理类的实现
 * */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void updateTransactional(Order order) {
        orderDao.insert(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderDao.getAll();
    }
}
