package org.xlbean.sample.webshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.xlbean.sample.webshop.dao.mapper.AddressMasterMapper;
import org.xlbean.sample.webshop.entity.AddressMaster;
import org.xlbean.xlapi.dao.DaoUtil;

@Component
public class AddressMasterDao {

    @Autowired
    private AddressMasterMapper mapper;
    
    public AddressMaster selectOne(String postCd) {
        return mapper.selectOne(postCd);
    }
    
    public List<AddressMaster> selectList(int offset, int limit) {
        return mapper.selectList(offset, limit);
    }
    
    public AddressMaster insert(AddressMaster object) {
        return insert(object, false);
    }
    
    public AddressMaster insert(AddressMaster object, boolean autoGenerateId) {
        if (autoGenerateId) {
            object.updateKey(generatePostCd());
        }
        DaoUtil.updateSystemValueForInsert(object);
        mapper.insert(object);
        return object;
    }

    public void update(AddressMaster object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.update(object);
    }

    public void updatePartial(AddressMaster object) {
        DaoUtil.updateSystemValueForUpdate(object);
        mapper.updateSelective(object);
    }
    
    public AddressMaster upsert(AddressMaster object) {
        AddressMaster registeredObject = mapper.selectOne(object.getPostCd());
        if (registeredObject == null) {
            insert(object, false);
            return object;
        } else {
            DaoUtil.updateSystemValueForUpdate(object);
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
