package org.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.xlbean.sample.webshop.entity.Cart;

@Mapper
public interface CartMapperGen {

    Cart selectOne(Integer customerId, Integer cartDetailId);

    List<Cart> selectList(Integer customerId, @Param("offset")Integer offset, @Param("limit")Integer limit);

    void insert(@Param("record")Cart record);

    void update(@Param("record")Cart record);

    void updateSelective(@Param("record")Cart record);

    void delete(Integer customerId, Integer cartDetailId);

    Integer generateCustomerId();

    Integer generateCartDetailId(Integer customerId);

}
