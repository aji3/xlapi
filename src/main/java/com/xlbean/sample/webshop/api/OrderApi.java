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

import com.xlbean.sample.webshop.dao.OrderDao;
import com.xlbean.sample.webshop.entity.Order;

@CrossOrigin
@RestController
@RequestMapping(path="/orders")
public class OrderApi {

    @Autowired
    private OrderDao dao;
    
    @RequestMapping(path="/", method=RequestMethod.GET)
    public List<Order> getList() {
        return dao.selectList();
    }
    
    @RequestMapping(path="/{orderId}", method=RequestMethod.GET)
    public Order getOne(@PathVariable Integer orderId) {
        return dao.selectOne(orderId);
    }
    
    @RequestMapping(path="/", method=RequestMethod.POST)
    @Transactional
    public Order create(@RequestBody Order object) {
        return dao.insert(object, true);
    }

    @RequestMapping(path="/{orderId}", method=RequestMethod.PUT)
    @Transactional
    public Order upsert(@PathVariable Integer orderId, @RequestBody Order object) {
        object.updateKey(orderId);
        return dao.upsert(object);
    }

    @RequestMapping(path="/{orderId}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Integer orderId) {
        dao.delete(orderId);
    }
}

