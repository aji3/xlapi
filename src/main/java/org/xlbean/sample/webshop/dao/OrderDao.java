package org.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.xlbean.sample.webshop.dao.mapper.OrderMapper;
import org.xlbean.sample.webshop.entity.Order;
import org.xlbean.xlapi.dao.DaoUtil;

@Component
public class OrderDao {

    @Autowired
    private OrderMapper mapper;
    
    public Order selectOne(Integer orderId) {
        return mapper.selectOne(orderId);
    }
    
    public List<Order> selectList(int offset, int limit) {
        return mapper.selectList(offset, limit);
    }
    
    public Order insert(Order object) {
        return insert(object, false);
    }
    
    public Order insert(Order object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(generateOrderId());
        }
        DaoUtil.updateSystemValueForInsert(object);
        mapper.insert(object);
        return object;
    }

    public void update(Order object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.update(object);
    }

    public void updatePartial(Order object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.updateSelective(object);
    }
    
    public Order upsert(Order object) {
        Order registeredObject = mapper.selectOne(object.getOrderId());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            DaoUtil.updateSystemValueForUpdate(object);
            mapper.updateSelective(object);
            return object;
        }
    }
    
    public void delete(Integer orderId) {
        mapper.delete(orderId);
    }

    public Integer generateOrderId() {
        return mapper.generateOrderId();
    }


}
