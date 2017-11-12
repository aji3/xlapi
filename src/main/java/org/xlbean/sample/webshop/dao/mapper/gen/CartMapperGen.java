package org.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.xlbean.sample.webshop.entity.Cart;

@Mapper
public interface CartMapperGen {

    Cart selectOne(@Param("customerId") Integer customerId, @Param("cartDetailId") Integer cartDetailId);

    List<Cart> selectList(@Param("customerId") Integer customerId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    void insert(@Param("record") Cart record);

    void update(@Param("record") Cart record);

    void updateSelective(@Param("record") Cart record);

    void delete(@Param("customerId") Integer customerId, @Param("cartDetailId") Integer cartDetailId);

    Integer generateCustomerId();

    Integer generateCartDetailId(Integer customerId);

}
