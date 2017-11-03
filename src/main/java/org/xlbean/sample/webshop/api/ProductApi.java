package org.xlbean.sample.webshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.xlbean.sample.webshop.dao.ProductDao;
import org.xlbean.sample.webshop.entity.Product;

@RestController
@RequestMapping(path="/webshop/products")
public class ProductApi {

    @Autowired
    private ProductDao dao;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Product> getList( 
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit) {
        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            limit = 100;
        }
        return dao.selectList(offset, limit);
    }

    @RequestMapping(path = "/{productId}", method = RequestMethod.GET)
    public Product getOne(@PathVariable Integer productId) {
        return dao.selectOne(productId);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    @Transactional
    public Product create(@RequestBody Product object) {
        return dao.insert(object, true);
    }

    @RequestMapping(path = "/{productId}", method = RequestMethod.PUT)
    @Transactional
    public Product upsert(@PathVariable Integer productId, @RequestBody Product object) {
        object.updateKey(productId);
        return dao.upsert(object);
    }

    @RequestMapping(path = "/{productId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer productId) {
        dao.delete(productId);
    }
}

