package com.subdb.controller;

import com.subdb.entity.Order;
import com.subdb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * list
     * */
    @RequestMapping("/getOrders")
    public List<Order> getUsers() {
        return orderService.getOrders();
    }

    /**
     * insert
     * */
    @RequestMapping(value="/save")
    public String updateTransactional(@RequestParam(value = "uid") Long uid,
                                      @RequestParam(value = "orderNo") String orderNo,
                                      @RequestParam(value = "amount") BigDecimal amount
    ) {
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUid(uid);
        order.setAmount(amount);
        order.setStatus(1);
        order.setNote("aaa");
        order.setCreateTime("2018-05-21");
        order.setEditTime("2018-05-21");
        orderService.updateTransactional(order);

        return "ok";
    }

}
