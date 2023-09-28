package com.loevc.celestia.admin.mapper;

import com.loevc.celestia.common.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/8/15 16:21
 * @Description
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    @Select("select * from sys_user where id = #{id}")
    User getNameById(@Param("id") int id);

    @Insert("INSERT INTO sys_user (id, name, age) VALUES (#{user.id}, #{user.name}, #{user.age})")
    int addUser(@Param("user") User user);

    @Delete("delete FROM sys_user where id = #{id}")
    int delUser(@Param("id") int id);
    @Update("UPDATE sys_user set name = #{user.name},age = #{user.age} where id = #{user.id}")
    int updataUser(@Param("user") User user);
}
