package org.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.xlbean.sample.webshop.dao.mapper.OrderDetailMapper;
import org.xlbean.sample.webshop.entity.OrderDetail;
import org.xlbean.xlapi.dao.DaoUtil;

@Component
public class OrderDetailDao {

    @Autowired
    private OrderDetailMapper mapper;
    
    public OrderDetail selectOne(Integer orderId, Integer orderDetailId) {
        return mapper.selectOne(orderId, orderDetailId);
    }
    
    public List<OrderDetail> selectList(Integer orderId, int offset, int limit) {
        return mapper.selectList(orderId, offset, limit);
    }
    
    public OrderDetail insert(OrderDetail object) {
        return insert(object, false);
    }
    
    public OrderDetail insert(OrderDetail object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(null, generateOrderDetailId(object.getOrderId()));
        }
        DaoUtil.updateSystemValueForInsert(object);
        mapper.insert(object);
        return object;
    }

    public void update(OrderDetail object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.update(object);
    }

    public void updatePartial(OrderDetail object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.updateSelective(object);
    }
    
    public OrderDetail upsert(OrderDetail object) {
        OrderDetail registeredObject = mapper.selectOne(object.getOrderId(), object.getOrderDetailId());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            DaoUtil.updateSystemValueForUpdate(object);
            mapper.updateSelective(object);
            return object;
        }
    }
    
    public void delete(Integer orderId, Integer orderDetailId) {
        mapper.delete(orderId, orderDetailId);
    }

    public Integer generateOrderDetailId(Integer orderId) {
        return mapper.generateOrderDetailId(orderId);
    }


}
