package org.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.xlbean.sample.webshop.entity.Product;

@Mapper
public interface ProductMapperGen {

    Product selectOne(Integer productId);

    List<Product> selectList(@Param("offset")Integer offset, @Param("limit")Integer limit);

    void insert(@Param("record")Product record);

    void update(@Param("record")Product record);

    void updateSelective(@Param("record")Product record);

    void delete(Integer productId);

    Integer generateProductId();

}
