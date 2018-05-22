package com.subdb.entity;

import lombok.Data;

import java.io.Serializable;
/**
 * 订单实体对象
 * */
@Data
public class Order implements Serializable {
    //主键ID
    private Long orderId;
    //订单号
    private String orderNo;
    //发起方客户关联id
    private Long uid;
    //发起方客户关联id
    private String userName;
    //发起金额
    private java.math.BigDecimal amount;
    //备注
    private String note;
    //状态  0. 无效 1.有效
    private Integer status;
    //创建时间
    private String createTime;
    //更新时间
    private String editTime;

}
