package org.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.xlbean.sample.webshop.dao.mapper.CustomerMapper;
import org.xlbean.sample.webshop.entity.Customer;
import org.xlbean.xlapi.dao.DaoUtil;

@Component
public class CustomerDao {

    @Autowired
    private CustomerMapper mapper;
    
    public Customer selectOne(Integer customerId) {
    	System.out.println(mapper.select(customerId));
        return mapper.selectOne(customerId);
    }
    
    public List<Customer> selectList(int offset, int limit) {
        return mapper.selectList(offset, limit);
    }
    
    public Customer insert(Customer object) {
        return insert(object, false);
    }
    
    public Customer insert(Customer object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(generateCustomerId());
        }
        DaoUtil.updateSystemValueForInsert(object);
        mapper.insert(object);
        return object;
    }

    public void update(Customer object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.update(object);
    }

    public void updatePartial(Customer object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.updateSelective(object);
    }
    
    public Customer upsert(Customer object) {
        Customer registeredObject = mapper.selectOne(object.getCustomerId());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            DaoUtil.updateSystemValueForUpdate(object);
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
