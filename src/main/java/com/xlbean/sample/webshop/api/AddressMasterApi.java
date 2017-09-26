package com.xlbean.sample.webshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xlbean.sample.webshop.dao.AddressMasterDao;
import com.xlbean.sample.webshop.entity.AddressMaster;

@CrossOrigin
@RestController
@RequestMapping(path="/addresses")
public class AddressMasterApi {

    @Autowired
    private AddressMasterDao dao;
    
    @RequestMapping(path="/", method=RequestMethod.GET)
    public List<AddressMaster> getList() {
        return dao.selectList();
    }
    
    @RequestMapping(path="/{postCd}", method=RequestMethod.GET)
    public AddressMaster getOne(@PathVariable String postCd) {
        return dao.selectOne(postCd);
    }
    
    @RequestMapping(path="/", method=RequestMethod.POST)
    @Transactional
    public AddressMaster create(@RequestBody AddressMaster object) {
        return dao.insert(object, true);
    }

    @RequestMapping(path="/{postCd}", method=RequestMethod.PUT)
    @Transactional
    public AddressMaster upsert(@PathVariable String postCd, @RequestBody AddressMaster object) {
        object.updateKey(postCd);
        return dao.upsert(object);
    }

    @RequestMapping(path="/{postCd}", method=RequestMethod.DELETE)
    public void delete(@PathVariable String postCd) {
        dao.delete(postCd);
    }
}

