package com.subdb.dao.impl;

import com.google.common.base.Strings;
import com.subdb.dao.OrderDao;
import com.subdb.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> getAll() {

        StringBuilder s=new StringBuilder();
//        s.append(" SELECT order_id,order_no,uid,amount,note,status,create_time,edit_time from order ");
//        s.append(" order by create_time desc ");
        s.append(" select t2.* ,t1.user_name from user t1 ,order t2 where t1.uid = t2.uid ");
        RowMapper<Order> rowMapper = new BeanPropertyRowMapper<>(Order.class);

        return jdbcTemplate.query(s.toString(), rowMapper);
    }

    @Override
    public void insert(Order order) {
        StringBuilder s=new StringBuilder();
        s.append("insert into order(");
        Map<String, Object> m = map(order);
        s.append(String.join(",", m.keySet()));
        s.append(") values (");
        List<String> query = m.keySet().stream().map(t -> "?").collect(Collectors.toList());
        s.append(String.join(",", query));
        s.append(")");
        jdbcTemplate.update(s.toString(), m.values().toArray());
    }

    private static Map<String,Object> map(Order order) {
        Map<String,Object> map=new HashMap();
        if (order.getOrderId() != null) {
            map.put("order_id",order.getOrderId());
        }
        if (!Strings.isNullOrEmpty(order.getOrderNo())) {
            map.put("order_no",order.getOrderNo());
        }
        if (order.getUid() != null) {
            map.put("uid",order.getUid());
        }
        if (order.getAmount() != null) {
            map.put("amount",order.getAmount());
        }
        if (!Strings.isNullOrEmpty(order.getNote())) {
            map.put("note",order.getNote());
        }
        if (order.getStatus() != null) {
            map.put("status",order.getStatus());
        }
        if (!Strings.isNullOrEmpty(order.getCreateTime())) {
            map.put("create_time",order.getCreateTime());
        }
        if (!Strings.isNullOrEmpty(order.getEditTime())) {
            map.put("edit_time",order.getEditTime());
        }
        return map;
    }
}
