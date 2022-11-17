package com.daishuai.view.web.service;

import com.daishuai.view.web.dto.ResourceInfoDto;
import com.daishuai.view.web.vo.ResourceInfoVo;

import java.util.List;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 资源信息
 * @createTime 2022年11月14日 12:15:00
 */
public interface ResourceInfoService {

    /**
     * 查询用户资源树
     *
     * @param username  用户名
     * @return  资源树
     */
    List<ResourceInfoVo> queryResourceAsTree(String username);

    /**
     * 新增资源信息
     *
     * @param resourceInfoDto   资源信息
     * @return  true or false
     */
    boolean addResource(ResourceInfoDto resourceInfoDto);
}
