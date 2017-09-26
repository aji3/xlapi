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

import com.xlbean.sample.webshop.dao.CartDao;
import com.xlbean.sample.webshop.entity.Cart;

@CrossOrigin
@RestController
@RequestMapping(path="/carts/{customerId}")
public class CartApi {

    @Autowired
    private CartDao dao;
    
    @RequestMapping(path="/", method=RequestMethod.GET)
    public List<Cart> getList(@PathVariable Integer customerId) {
        return dao.selectList(customerId);
    }
    
    @RequestMapping(path="/{cartDetailId}", method=RequestMethod.GET)
    public Cart getOne(@PathVariable Integer customerId, @PathVariable Integer cartDetailId) {
        return dao.selectOne(customerId, cartDetailId);
    }
    
    @RequestMapping(path="/", method=RequestMethod.POST)
    @Transactional
    public Cart create(@RequestBody Cart object) {
        return dao.insert(object, true);
    }

    @RequestMapping(path="/{cartDetailId}", method=RequestMethod.PUT)
    @Transactional
    public Cart upsert(@PathVariable Integer customerId, @PathVariable Integer cartDetailId, @RequestBody Cart object) {
        object.updateKey(customerId, cartDetailId);
        return dao.upsert(object);
    }

    @RequestMapping(path="/{cartDetailId}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Integer customerId, @PathVariable Integer cartDetailId) {
        dao.delete(customerId, cartDetailId);
    }
}

