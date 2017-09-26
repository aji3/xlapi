package com.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xlbean.sample.webshop.entity.Customer;

@Mapper
public interface CustomerMapperGen {

    Customer selectOne(@Param("customerId") Integer customerId);

    List<Customer> selectList();

    void insert(@Param("record")Customer record);

    void update(@Param("record")Customer record);

    void updateSelective(@Param("record")Customer record);

    void delete(@Param("customerId") Integer customerId);

    Integer generateCustomerId();

}
