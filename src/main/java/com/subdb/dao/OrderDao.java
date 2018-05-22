package com.subdb.dao;

import com.subdb.entity.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getAll();

    void insert(Order order);
}
