package com.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xlbean.sample.webshop.entity.Product;

@Mapper
public interface ProductMapperGen {

    Product selectOne(@Param("productId") Integer productId);

    List<Product> selectList();

    void insert(@Param("record")Product record);

    void update(@Param("record")Product record);

    void updateSelective(@Param("record")Product record);

    void delete(@Param("productId") Integer productId);

    Integer generateProductId();

}
