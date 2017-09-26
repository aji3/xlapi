package com.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xlbean.sample.webshop.entity.Order;

@Mapper
public interface OrderMapperGen {

    Order selectOne(@Param("orderId") Integer orderId);

    List<Order> selectList();

    void insert(@Param("record")Order record);

    void update(@Param("record")Order record);

    void updateSelective(@Param("record")Order record);

    void delete(@Param("orderId") Integer orderId);

    Integer generateOrderId();

}
