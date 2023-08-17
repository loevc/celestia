package com.loevc.celestia.admin.service;

import com.example.celestia.common.entity.User;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/8/15 16:18
 * @Description
 * @Version 1.0
 */
public interface UserService {
    User getNameById(String id);
    int addUser(User user);
}
