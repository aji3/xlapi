package com.xlbean.sample.webshop.entity;

import java.util.Date;
import java.time.LocalDate;
import lombok.Data;

@Data
public class OrderDetail {

    private Integer orderId;
    private Integer orderDetailId;
    private Integer productId;
    private Integer quantity;

    public void updateKey(Integer orderId, Integer orderDetailId) {
        if (orderId != null) {
            this.orderId = orderId;
        }
        if (orderDetailId != null) {
            this.orderDetailId = orderDetailId;
        }
    }
}
