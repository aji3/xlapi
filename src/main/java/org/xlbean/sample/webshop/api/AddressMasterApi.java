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

import org.xlbean.sample.webshop.dao.AddressMasterDao;
import org.xlbean.sample.webshop.entity.AddressMaster;

@RestController
@RequestMapping(path="/webshop/addresses")
public class AddressMasterApi {

    @Autowired
    private AddressMasterDao dao;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<AddressMaster> getList( 
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

    @RequestMapping(path = "/{postCd}", method = RequestMethod.GET)
    public AddressMaster getOne(@PathVariable String postCd) {
        return dao.selectOne(postCd);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    @Transactional
    public AddressMaster create(@RequestBody AddressMaster object) {
        return dao.insert(object, true);
    }

    @RequestMapping(path = "/{postCd}", method = RequestMethod.PUT)
    @Transactional
    public AddressMaster upsert(@PathVariable String postCd, @RequestBody AddressMaster object) {
        object.updateKey(postCd);
        return dao.upsert(object);
    }

    @RequestMapping(path = "/{postCd}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String postCd) {
        dao.delete(postCd);
    }
}

