package org.xlbean.sample.webshop.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import org.xlbean.sample.webshop.dao.mapper.gen.CustomerMapperGen;

@Mapper
@Primary
public interface CustomerMapper extends CustomerMapperGen {

	public int select(@Param("customerId") Integer customerId);
}
