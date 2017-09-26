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

import com.xlbean.sample.webshop.dao.ProductDao;
import com.xlbean.sample.webshop.entity.Product;

@CrossOrigin
@RestController
@RequestMapping(path="/products")
public class ProductApi {

    @Autowired
    private ProductDao dao;
    
    @RequestMapping(path="/", method=RequestMethod.GET)
    public List<Product> getList() {
        return dao.selectList();
    }
    
    @RequestMapping(path="/{productId}", method=RequestMethod.GET)
    public Product getOne(@PathVariable Integer productId) {
        return dao.selectOne(productId);
    }
    
    @RequestMapping(path="/", method=RequestMethod.POST)
    @Transactional
    public Product create(@RequestBody Product object) {
        return dao.insert(object, true);
    }

    @RequestMapping(path="/{productId}", method=RequestMethod.PUT)
    @Transactional
    public Product upsert(@PathVariable Integer productId, @RequestBody Product object) {
        object.updateKey(productId);
        return dao.upsert(object);
    }

    @RequestMapping(path="/{productId}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Integer productId) {
        dao.delete(productId);
    }
}

