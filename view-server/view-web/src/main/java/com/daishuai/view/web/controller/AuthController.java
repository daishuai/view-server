package com.daishuai.view.web.controller;

import com.daishuai.view.model.ResponseMessage;
import com.daishuai.view.web.dto.LoginUserDto;
import com.daishuai.view.web.service.UserInfoService;
import com.daishuai.view.web.vo.LoginUserVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author admin
 * @version 1.0.0
 * @description 权限
 * @createTime 2022-11-07 22:06:40
 */
@RequestMapping(value = "/auth")
@RestController
public class AuthController {

    @Resource
    private UserInfoService userInfoServiceImpl;

    @PostMapping(value = "/login")
    public ResponseMessage<LoginUserVo> login(@RequestBody LoginUserDto loginUserDto) {
        LoginUserVo result = userInfoServiceImpl.queryUserByUsername(loginUserDto.getUsername());
        return ResponseMessage.ok(result);
    }
}
