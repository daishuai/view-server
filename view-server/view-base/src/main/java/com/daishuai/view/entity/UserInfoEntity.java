package com.daishuai.view.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author admin
 * @version 1.0.0
 * @description 用户信息
 * @createTime 2022-11-07 21:47:06
 */
@Data
public class UserInfoEntity {

    private String username;

    private String password;

    private Date birthday;

    private String phone;

    private String picture;

    private String email;

    private String address;

    private Date createdTime;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;
}
