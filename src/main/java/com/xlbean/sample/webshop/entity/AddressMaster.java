package com.xlbean.sample.webshop.entity;

import java.util.Date;
import java.time.LocalDate;
import lombok.Data;

@Data
public class AddressMaster {

    private String postCd;
    private String address;

    public void updateKey(String postCd) {
        if (postCd != null) {
            this.postCd = postCd;
        }
    }
}
