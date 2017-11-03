package org.xlbean.sample.webshop.entity;

import java.util.Date;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Order {

    private Integer orderId;
    private Integer customerId;
    private Date orderDatetime;
    private Integer totalPrice;

    public void updateKey(Integer orderId) {
        if (orderId != null) {
            this.orderId = orderId;
        }
    }
}
