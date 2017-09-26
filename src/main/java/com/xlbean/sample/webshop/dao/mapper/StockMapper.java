package com.xlbean.sample.webshop.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

import com.xlbean.sample.webshop.dao.mapper.gen.StockMapperGen;

@Mapper
@Primary
public interface StockMapper extends StockMapperGen {

}
