package com.loevc.celestia.admin.controller;

import com.example.celestia.common.entity.User;
import com.example.celestia.common.util.ApiResponse;
import com.loevc.celestia.admin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    public ApiResponse info(@RequestParam("id") String id) {
        ApiResponse response = new ApiResponse();
        response.setCode(1);
        response.setMessage("");
//        HashMap map = new HashMap();
//        map.put("user", userService.getNameById(id));
        response.setData(userService.getNameById(id));

        return response;
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody @Validated User user) {
        System.out.println(user);
        return userService.addUser(user) == 1;
    }

    @GetMapping("/del")
    public Boolean del(@RequestParam(value = "id") String id) {
        return userService.delUser(id) == 1;
    }

    @PostMapping("/updata")
    public Boolean del(@RequestBody User user) {
        return userService.updataUser(user) == 1;
    }

}
