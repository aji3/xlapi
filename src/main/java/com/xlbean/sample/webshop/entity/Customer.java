package com.xlbean.sample.webshop.entity;

import java.util.Date;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Customer {
    public enum Gender {MALE, FEMALE, }; 
    public enum CustomerType {CORPORATE, INDIVIDUAL, }; 

    private Integer customerId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String postCd;
    private String addressDetail;
    private String email;
    private String phone;
    private CustomerType customerType;

    public void updateKey(Integer customerId) {
        if (customerId != null) {
            this.customerId = customerId;
        }
    }
}
