package com.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xlbean.sample.webshop.dao.mapper.CartMapper;
import com.xlbean.sample.webshop.entity.Cart;

@Component
public class CartDao {

    @Autowired
    private CartMapper mapper;
    
    public Cart selectOne(Integer customerId, Integer cartDetailId) {
        return mapper.selectOne(customerId, cartDetailId);
    }
    
    public List<Cart> selectList(Integer customerId) {
        return mapper.selectList(customerId);
    }
    
    public Cart insert(Cart object) {
        return insert(object, false);
    }
    
    public Cart insert(Cart object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(null, generateCartDetailId(object.getCustomerId()));
        }
        mapper.insert(object);
        return object;
    }

    public void update(Cart object) {
        mapper.update(object);
    }

    public void updatePartial(Cart object) {
        mapper.updateSelective(object);
    }
    
    public Cart upsert(Cart object) {
        Cart registeredObject = mapper.selectOne(object.getCustomerId(), object.getCartDetailId());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            mapper.updateSelective(object);
            return object;
        }
    }
    
    public void delete(Integer customerId, Integer cartDetailId) {
        mapper.delete(customerId, cartDetailId);
    }

    public Integer generateCartDetailId(Integer customerId) {
        return mapper.generateCartDetailId(customerId);
    }


}
