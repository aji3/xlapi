package com.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xlbean.sample.webshop.entity.Stock;

@Mapper
public interface StockMapperGen {

    Stock selectOne(@Param("productId") Integer productId);

    List<Stock> selectList();

    void insert(@Param("record")Stock record);

    void update(@Param("record")Stock record);

    void updateSelective(@Param("record")Stock record);

    void delete(@Param("productId") Integer productId);

    Integer generateProductId();

}
