package org.xlbean.sample.webshop.dao.mapper.gen;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.xlbean.sample.webshop.entity.AddressMaster;

@Mapper
public interface AddressMasterMapperGen {

    AddressMaster selectOne(@Param("postCd") String postCd);

    List<AddressMaster> selectList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    void insert(@Param("record") AddressMaster record);

    void update(@Param("record") AddressMaster record);

    void updateSelective(@Param("record") AddressMaster record);

    void delete(@Param("postCd") String postCd);

    String generatePostCd();

}
