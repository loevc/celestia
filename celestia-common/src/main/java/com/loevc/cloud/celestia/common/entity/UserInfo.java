package com.loevc.cloud.celestia.common.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/11 13:36
 * @Description TODO
 * @Version 1.0
 */
@Data
public class UserInfo {

    private String id;

    @Indexed(name = "email_1")
    private String email;

    private String password;

    private String phone;

    private String salt;

    private String avatar;

    private String firstName;

    private String lastName;

    private String fullName;

    private String gender;

    private String birthday;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String delFlag;


}
