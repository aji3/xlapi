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

import org.xlbean.sample.webshop.dao.OrderDetailDao;
import org.xlbean.sample.webshop.entity.OrderDetail;

@RestController
@RequestMapping(path="/webshop/orders/{orderId}/details")
public class OrderDetailApi {

    @Autowired
    private OrderDetailDao dao;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<OrderDetail> getList(@PathVariable Integer orderId, 
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit) {
        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            limit = 100;
        }
        return dao.selectList(orderId, offset, limit);
    }

    @RequestMapping(path = "/{orderDetailId}", method = RequestMethod.GET)
    public OrderDetail getOne(@PathVariable Integer orderId, @PathVariable Integer orderDetailId) {
        return dao.selectOne(orderId, orderDetailId);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    @Transactional
    public OrderDetail create(@RequestBody OrderDetail object) {
        return dao.insert(object, true);
    }

    @RequestMapping(path = "/{orderDetailId}", method = RequestMethod.PUT)
    @Transactional
    public OrderDetail upsert(@PathVariable Integer orderId, @PathVariable Integer orderDetailId, @RequestBody OrderDetail object) {
        object.updateKey(orderId, orderDetailId);
        return dao.upsert(object);
    }

    @RequestMapping(path = "/{orderDetailId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer orderId, @PathVariable Integer orderDetailId) {
        dao.delete(orderId, orderDetailId);
    }
}

