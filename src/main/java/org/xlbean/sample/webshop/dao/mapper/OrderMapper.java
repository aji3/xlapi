package org.xlbean.sample.webshop.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

import org.xlbean.sample.webshop.dao.mapper.gen.OrderMapperGen;

@Mapper
@Primary
public interface OrderMapper extends OrderMapperGen {

}
