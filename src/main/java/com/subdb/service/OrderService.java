package com.subdb.service;

import com.subdb.entity.Order;

import java.util.List;

/**
 * 订单管理类
 * */
public interface OrderService {

    /**
     * 更新订单数据
     * */
    void updateTransactional(Order order);
    /**
     * 获取订单列表
     * */
     List<Order> getOrders();
}
