package org.xlbean.sample.webshop.entity;

import java.util.Date;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Product {

    private Integer productId;
    private String name;
    private Integer price;

    public void updateKey(Integer productId) {
        if (productId != null) {
            this.productId = productId;
        }
    }
}
