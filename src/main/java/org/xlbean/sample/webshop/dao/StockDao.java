package org.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.xlbean.sample.webshop.dao.mapper.StockMapper;
import org.xlbean.sample.webshop.entity.Stock;
import org.xlbean.xlapi.dao.DaoUtil;

@Component
public class StockDao {

    @Autowired
    private StockMapper mapper;
    
    public Stock selectOne(Integer productId) {
        return mapper.selectOne(productId);
    }
    
    public List<Stock> selectList(int offset, int limit) {
        return mapper.selectList(offset, limit);
    }
    
    public Stock insert(Stock object) {
        return insert(object, false);
    }
    
    public Stock insert(Stock object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(generateProductId());
        }
        DaoUtil.updateSystemValueForInsert(object);
        mapper.insert(object);
        return object;
    }

    public void update(Stock object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.update(object);
    }

    public void updatePartial(Stock object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.updateSelective(object);
    }
    
    public Stock upsert(Stock object) {
        Stock registeredObject = mapper.selectOne(object.getProductId());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            DaoUtil.updateSystemValueForUpdate(object);
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
