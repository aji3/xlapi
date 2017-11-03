package org.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.xlbean.sample.webshop.entity.Customer;

@Mapper
public interface CustomerMapperGen {

    Customer selectOne(Integer customerId);

    List<Customer> selectList(@Param("offset")Integer offset, @Param("limit")Integer limit);

    void insert(@Param("record")Customer record);

    void update(@Param("record")Customer record);

    void updateSelective(@Param("record")Customer record);

    void delete(Integer customerId);

    Integer generateCustomerId();

}
