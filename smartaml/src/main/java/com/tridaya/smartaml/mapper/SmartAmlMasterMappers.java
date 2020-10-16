package com.tridaya.smartaml.mapper;


import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SmartAmlMasterMappers {
    
    @Select(value = "${param1}")
    @Options(statementType = StatementType.CALLABLE)
    List<HashMap<String, Object>> exec(@Param("store_procedure")String store_procedure);
}
