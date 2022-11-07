package com.daishuai.view.mapper;

import com.daishuai.view.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author admin
 * @version 1.0.0
 * @description 用户
 * @createTime 2022-11-07 21:56:24
 */
public interface UserInfoMapper {

    /**
     * 根据用户名查询用户
     *
     * @param username  用户名
     * @return  用户信息
     */
    UserInfoEntity queryUserByUsername(@Param("username") String username);
}
