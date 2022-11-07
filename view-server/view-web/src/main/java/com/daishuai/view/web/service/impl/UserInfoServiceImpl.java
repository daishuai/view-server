package com.daishuai.view.web.service.impl;

import com.daishuai.view.entity.UserInfoEntity;
import com.daishuai.view.exception.ServiceException;
import com.daishuai.view.mapper.UserInfoMapper;
import com.daishuai.view.web.service.UserInfoService;
import com.daishuai.view.web.vo.LoginUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author admin
 * @version 1.0.0
 * @description 用户
 * @createTime 2022-11-07 22:01:32
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public LoginUserVo queryUserByUsername(String username) {
        UserInfoEntity userInfoEntity = userInfoMapper.queryUserByUsername(username);
        if (userInfoEntity == null) {
            throw new ServiceException("登录用户不存在: " + username);
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        BeanUtils.copyProperties(userInfoEntity, loginUserVo);
        return loginUserVo;
    }
}
