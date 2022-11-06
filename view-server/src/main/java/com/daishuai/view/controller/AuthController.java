package com.daishuai.view.controller;

import com.alibaba.fastjson.JSON;
import com.daishuai.view.dto.LoginUserDto;
import com.daishuai.view.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @version 1.0.0
 * @description 权限控制器
 * @createTime 2022-11-06 21:48:53
 */
@Slf4j
@RestController
public class AuthController {

    @PostMapping(value = "/login")
    public Object login(@RequestBody LoginUserDto loginUser) {
        log.info("Current Login User : {}", JSON.toJSONString(loginUser));
        return loginUser;
    }

    @GetMapping(value = "/getUserInfo")
    public Object getUserInfoByToken(String token) {
        log.info("Get User Info By Token: {}", token);
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUsername("super_admin");
        userInfoVo.setAddress("江苏省苏州市");
        userInfoVo.setAge(11);
        userInfoVo.setPhone("15250121221");
        userInfoVo.setEmail("daishuai2011@126.com");
        return userInfoVo;
    }
}
