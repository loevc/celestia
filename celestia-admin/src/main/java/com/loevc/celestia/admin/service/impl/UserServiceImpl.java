package com.loevc.celestia.admin.service.impl;

import com.loevc.celestia.common.entity.User;
import com.loevc.celestia.admin.mapper.UserMapper;
import com.loevc.celestia.admin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/8/15 16:19
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public User getNameById(String id) {
        return userMapper.getNameById(id);
    }
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    public int delUser(String id){
        User nameById = getNameById(id);
        if (Objects.nonNull(nameById)){
            return 0;
        }

        return userMapper.delUser(id);
    }
    public int updataUser(User user){
        return userMapper.updataUser(user);
    }

}
