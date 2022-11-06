package com.daishuai.view.vo;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @description 用户信息
 * @createTime 2022-11-06 21:59:39
 */
@Data
public class UserInfoVo {

    private String username;

    private String phone;

    private String email;

    private Integer age;

    private String address;
}
