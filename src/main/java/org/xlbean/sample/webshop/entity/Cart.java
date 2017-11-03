package org.xlbean.sample.webshop.entity;

import java.util.Date;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Cart {

    private Integer customerId;
    private Integer cartDetailId;
    private Integer productId;
    private Integer quantity;

    public void updateKey(Integer customerId, Integer cartDetailId) {
        if (customerId != null) {
            this.customerId = customerId;
        }
        if (cartDetailId != null) {
            this.cartDetailId = cartDetailId;
        }
    }
}
