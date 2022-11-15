package com.daishuai.view.mapper;

import com.daishuai.view.entity.ResourceInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @description 用户
 * @createTime 2022-11-07 21:56:24
 */
public interface ResourceInfoMapper {

    /**
     * 查询用户资源
     *
     * @param username  用户名
     * @return  资源列表
     */
    List<ResourceInfoEntity> queryUserResources(@Param("username") String username);
}
