package com.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xlbean.sample.webshop.dao.mapper.CustomerMapper;
import com.xlbean.sample.webshop.entity.Customer;

@Component
public class CustomerDao {

    @Autowired
    private CustomerMapper mapper;
    
    public Customer selectOne(Integer customerId) {
        return mapper.selectOne(customerId);
    }
    
    public List<Customer> selectList() {
        return mapper.selectList();
    }
    
    public Customer insert(Customer object) {
        return insert(object, false);
    }
    
    public Customer insert(Customer object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(generateCustomerId());
        }
        mapper.insert(object);
        return object;
    }

    public void update(Customer object) {
        mapper.update(object);
    }

    public void updatePartial(Customer object) {
        mapper.updateSelective(object);
    }
    
    public Customer upsert(Customer object) {
        Customer registeredObject = mapper.selectOne(object.getCustomerId());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            mapper.updateSelective(object);
            return object;
        }
    }
    
    public void delete(Integer customerId) {
        mapper.delete(customerId);
    }

    public Integer generateCustomerId() {
        return mapper.generateCustomerId();
    }


}
