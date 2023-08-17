package com.loevc.celestia.admin.controller;

import com.example.celestia.common.entity.User;
import com.loevc.celestia.admin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/8/15 16:17
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/name")
    public User info(@RequestParam("id") String id) {
        return userService.getNameById(id);
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody User user) {
        System.out.println(user);
        return userService.addUser(user) == 1;
    }

    @GetMapping("/del")
    public Boolean del(@RequestParam(value = "id",required = true) String id) {
        return userService.delUser(id) == 1;
    }
    @PostMapping("/updata")
    public Boolean del(@RequestBody User user) {
        return userService.updataUser(user) == 1;
    }

}
