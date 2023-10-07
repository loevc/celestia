package com.loevc.celestia.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private int gender;
    private Date birthday;
    private String avatar;
    private Date createTime;

}

