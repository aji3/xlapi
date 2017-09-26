package com.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xlbean.sample.webshop.entity.OrderDetail;

@Mapper
public interface OrderDetailMapperGen {

    OrderDetail selectOne(@Param("orderId") Integer orderId, @Param("orderDetailId") Integer orderDetailId);

    List<OrderDetail> selectList(@Param("orderId") Integer orderId);

    void insert(@Param("record")OrderDetail record);

    void update(@Param("record")OrderDetail record);

    void updateSelective(@Param("record")OrderDetail record);

    void delete(@Param("orderId") Integer orderId, @Param("orderDetailId") Integer orderDetailId);

    Integer generateOrderId();

    Integer generateOrderDetailId(Integer orderId);

}
