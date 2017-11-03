package org.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.xlbean.sample.webshop.entity.Order;

@Mapper
public interface OrderMapperGen {

    Order selectOne(Integer orderId);

    List<Order> selectList(@Param("offset")Integer offset, @Param("limit")Integer limit);

    void insert(@Param("record")Order record);

    void update(@Param("record")Order record);

    void updateSelective(@Param("record")Order record);

    void delete(Integer orderId);

    Integer generateOrderId();

}
