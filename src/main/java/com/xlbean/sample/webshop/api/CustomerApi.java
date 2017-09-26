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

import com.xlbean.sample.webshop.dao.CustomerDao;
import com.xlbean.sample.webshop.entity.Customer;

@CrossOrigin
@RestController
@RequestMapping(path="/customers")
public class CustomerApi {

    @Autowired
    private CustomerDao dao;
    
    @RequestMapping(path="/", method=RequestMethod.GET)
    public List<Customer> getList() {
        return dao.selectList();
    }
    
    @RequestMapping(path="/{customerId}", method=RequestMethod.GET)
    public Customer getOne(@PathVariable Integer customerId) {
        return dao.selectOne(customerId);
    }
    
    @RequestMapping(path="/", method=RequestMethod.POST)
    @Transactional
    public Customer create(@RequestBody Customer object) {
        return dao.insert(object, true);
    }

    @RequestMapping(path="/{customerId}", method=RequestMethod.PUT)
    @Transactional
    public Customer upsert(@PathVariable Integer customerId, @RequestBody Customer object) {
        object.updateKey(customerId);
        return dao.upsert(object);
    }

    @RequestMapping(path="/{customerId}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Integer customerId) {
        dao.delete(customerId);
    }
}

