package org.xlbean.sample.webshop.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

import org.xlbean.sample.webshop.dao.mapper.gen.CartMapperGen;

@Mapper
@Primary
public interface CartMapper extends CartMapperGen {

}
