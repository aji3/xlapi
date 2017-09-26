package com.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xlbean.sample.webshop.dao.mapper.ProductMapper;
import com.xlbean.sample.webshop.entity.Product;

@Component
public class ProductDao {

    @Autowired
    private ProductMapper mapper;
    
    public Product selectOne(Integer productId) {
        return mapper.selectOne(productId);
    }
    
    public List<Product> selectList() {
        return mapper.selectList();
    }
    
    public Product insert(Product object) {
        return insert(object, false);
    }
    
    public Product insert(Product object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(generateProductId());
        }
        mapper.insert(object);
        return object;
    }

    public void update(Product object) {
        mapper.update(object);
    }

    public void updatePartial(Product object) {
        mapper.updateSelective(object);
    }
    
    public Product upsert(Product object) {
        Product registeredObject = mapper.selectOne(object.getProductId());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            mapper.updateSelective(object);
            return object;
        }
    }
    
    public void delete(Integer productId) {
        mapper.delete(productId);
    }

    public Integer generateProductId() {
        return mapper.generateProductId();
    }


}
