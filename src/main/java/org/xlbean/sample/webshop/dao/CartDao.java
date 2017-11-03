package org.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.xlbean.sample.webshop.dao.mapper.CartMapper;
import org.xlbean.sample.webshop.entity.Cart;
import org.xlbean.xlapi.dao.DaoUtil;

@Component
public class CartDao {

    @Autowired
    private CartMapper mapper;
    
    public Cart selectOne(Integer customerId, Integer cartDetailId) {
        return mapper.selectOne(customerId, cartDetailId);
    }
    
    public List<Cart> selectList(Integer customerId, int offset, int limit) {
        return mapper.selectList(customerId, offset, limit);
    }
    
    public Cart insert(Cart object) {
        return insert(object, false);
    }
    
    public Cart insert(Cart object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(null, generateCartDetailId(object.getCustomerId()));
        }
        DaoUtil.updateSystemValueForInsert(object);
        mapper.insert(object);
        return object;
    }

    public void update(Cart object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.update(object);
    }

    public void updatePartial(Cart object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.updateSelective(object);
    }
    
    public Cart upsert(Cart object) {
        Cart registeredObject = mapper.selectOne(object.getCustomerId(), object.getCartDetailId());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            DaoUtil.updateSystemValueForUpdate(object);
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
