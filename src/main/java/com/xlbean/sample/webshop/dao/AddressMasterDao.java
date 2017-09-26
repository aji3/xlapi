package com.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xlbean.sample.webshop.dao.mapper.AddressMasterMapper;
import com.xlbean.sample.webshop.entity.AddressMaster;

@Component
public class AddressMasterDao {

    @Autowired
    private AddressMasterMapper mapper;
    
    public AddressMaster selectOne(String postCd) {
        return mapper.selectOne(postCd);
    }
    
    public List<AddressMaster> selectList() {
        return mapper.selectList();
    }
    
    public AddressMaster insert(AddressMaster object) {
        return insert(object, false);
    }
    
    public AddressMaster insert(AddressMaster object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(generatePostCd());
        }
        mapper.insert(object);
        return object;
    }

    public void update(AddressMaster object) {
        mapper.update(object);
    }

    public void updatePartial(AddressMaster object) {
        mapper.updateSelective(object);
    }
    
    public AddressMaster upsert(AddressMaster object) {
        AddressMaster registeredObject = mapper.selectOne(object.getPostCd());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            mapper.updateSelective(object);
            return object;
        }
    }
    
    public void delete(String postCd) {
        mapper.delete(postCd);
    }

    public String generatePostCd() {
        return mapper.generatePostCd();
    }


}
