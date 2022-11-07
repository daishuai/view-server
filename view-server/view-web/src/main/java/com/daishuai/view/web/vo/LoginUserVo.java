package com.daishuai.view.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author admin
 * @version 1.0.0
 * @description 登录用户
 * @createTime 2022-11-07 22:02:55
 */
@Data
public class LoginUserVo {

    private String username;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String phone;

    private String picture;

    private String email;

    private String address;

}
