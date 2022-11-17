package com.daishuai.view.web.service.impl;

import com.daishuai.view.entity.ResourceInfoEntity;
import com.daishuai.view.mapper.ResourceInfoMapper;
import com.daishuai.view.web.dto.ResourceInfoDto;
import com.daishuai.view.web.service.ResourceInfoService;
import com.daishuai.view.web.vo.ResourceInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 资源信息
 * @createTime 2022年11月14日 12:16:00
 */
@Slf4j
@Service
public class ResourceInfoServiceImpl implements ResourceInfoService {

    private static final String ROOT = "-1";
    @Resource
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    public List<ResourceInfoVo> queryResourceAsTree(String username) {
        List<ResourceInfoEntity> resources = resourceInfoMapper.queryUserResources(username);
        if (CollectionUtils.isEmpty(resources)) {
            return new ArrayList<>();
        }
        Map<String, List<ResourceInfoVo>> resourcesInfoMap = resources.stream().map(entity -> {
            ResourceInfoVo infoVo = new ResourceInfoVo();
            BeanUtils.copyProperties(entity, infoVo);
            return infoVo;
        }).collect(Collectors.groupingBy(ResourceInfoVo::getParent));
        List<ResourceInfoVo> resourceTree = resourcesInfoMap.get(ROOT);
        this.buildResourceTree(resourceTree, resourcesInfoMap);
        return resourceTree;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addResource(ResourceInfoDto resourceInfoDto) {
        ResourceInfoEntity entity = new ResourceInfoEntity();
        BeanUtils.copyProperties(resourceInfoDto, entity);
        int row = resourceInfoMapper.insertResource(entity);
        return row == 1;
    }

    /**
     * 构建资源树
     *
     * @param resourceTree  资源树
     * @param resourceInfosMap  子级资源
     */
    private void buildResourceTree(List<ResourceInfoVo> resourceTree, Map<String, List<ResourceInfoVo>> resourceInfosMap) {
        if (CollectionUtils.isEmpty(resourceTree)) {
            return;
        }
        for (ResourceInfoVo resourceInfoVo : resourceTree) {
            String name = resourceInfoVo.getName();
            List<ResourceInfoVo> children = resourceInfosMap.get(name);
            resourceInfoVo.setChildren(children);
            this.buildResourceTree(children, resourceInfosMap);
        }
    }
}
