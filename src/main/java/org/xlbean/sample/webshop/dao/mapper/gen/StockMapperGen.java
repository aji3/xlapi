package org.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.xlbean.sample.webshop.entity.Stock;

@Mapper
public interface StockMapperGen {

    Stock selectOne(@Param("productId") Integer productId);

    List<Stock> selectList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    void insert(@Param("record") Stock record);

    void update(@Param("record") Stock record);

    void updateSelective(@Param("record") Stock record);

    void delete(@Param("productId") Integer productId);

    Integer generateProductId();

}
