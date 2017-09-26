package com.xlbean.sample.webshop.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Order {

    private Integer orderId;
    private Integer customerId;
    private Date orderDatetime;
    private Integer totalPrice;
    
    private OrderDetail orderDetails;

    public void updateKey(Integer orderId) {
        if (orderId != null) {
            this.orderId = orderId;
        }
    }
}
