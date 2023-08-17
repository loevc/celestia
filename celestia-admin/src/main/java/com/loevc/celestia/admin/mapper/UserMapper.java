package com.loevc.celestia.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/8/15 16:21
 * @Description
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    @Select("select name from sys_user where id = #{id}")
    String getNameById(@Param("id") String id);
}
