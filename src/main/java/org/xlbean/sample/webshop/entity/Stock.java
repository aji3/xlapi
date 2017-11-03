package org.xlbean.sample.webshop.entity;

import java.util.Date;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Stock {

    private Integer productId;
    private Integer number;

    public void updateKey(Integer productId) {
        if (productId != null) {
            this.productId = productId;
        }
    }
}
