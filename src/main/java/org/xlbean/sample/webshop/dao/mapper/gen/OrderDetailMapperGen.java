package org.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.xlbean.sample.webshop.entity.OrderDetail;

@Mapper
public interface OrderDetailMapperGen {

    OrderDetail selectOne(Integer orderId, Integer orderDetailId);

    List<OrderDetail> selectList(Integer orderId, @Param("offset")Integer offset, @Param("limit")Integer limit);

    void insert(@Param("record")OrderDetail record);

    void update(@Param("record")OrderDetail record);

    void updateSelective(@Param("record")OrderDetail record);

    void delete(Integer orderId, Integer orderDetailId);

    Integer generateOrderId();

    Integer generateOrderDetailId(Integer orderId);

}
