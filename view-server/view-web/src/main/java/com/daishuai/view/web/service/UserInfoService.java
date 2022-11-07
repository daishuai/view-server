package com.daishuai.view.web.service;

import com.daishuai.view.web.vo.LoginUserVo;

/**
 * @author admin
 * @version 1.0.0
 * @description 用户
 * @createTime 2022-11-07 22:01:12
 */
public interface UserInfoService {

    /**
     * 获取登录用户信息
     *
     * @param username  用户名
     * @return  用户信息
     */
    LoginUserVo queryUserByUsername(String username);
}
