package com.loevc.celestia.admin.controller;

import com.loevc.celestia.common.entity.User;
import com.loevc.celestia.common.util.ApiResponse;
import com.loevc.celestia.admin.service.UserService;
import com.loevc.celestia.common.util.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
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
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
//    @Value("${loevc.name}")
//    private String name;

    @GetMapping("/get")
    public ApiResponse info(@RequestParam("id") int id) {
//        ApiResponse response = new ApiResponse();
//        return response.returnApiResponse(ResponseCode.SUCCESS.getCode(), "好了", null);
        return ApiResponse.restResult(ResponseCode.SUCCESS.getCode(), "好了", null);
//
//        return userService.getNameById(id);
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody @Validated User user) {
        System.out.println(user);
        return userService.addUser(user) == 1;
    }

    @GetMapping("/del")
    public Boolean del(@RequestParam(value = "id") int id) {
        return userService.delUser(id) == 1;
    }

    @PostMapping("/updata")
    public Boolean del(@RequestBody User user) {
        return userService.updataUser(user) == 1;
    }

}
