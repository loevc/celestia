package com.loevc.celestia.admin.mapper;

import com.example.celestia.common.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

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
    User getNameById(@Param("id") String id);
    @Insert("INSERT INTO sys_user (id, name, age) VALUES (#{user.id}, #{user.name}, #{user.age})")
    int addUser(@Param("user") User user);
}
