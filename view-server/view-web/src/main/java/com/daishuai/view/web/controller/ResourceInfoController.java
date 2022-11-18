package com.daishuai.view.web.controller;

import com.daishuai.view.model.ResponseMessage;
import com.daishuai.view.web.dto.ResourceInfoDto;
import com.daishuai.view.web.service.ResourceInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 资源接口
 * @createTime 2022年11月18日 09:27:00
 */
@RestController
@RequestMapping(value = "/resource")
public class ResourceInfoController {

    @Resource
    private ResourceInfoService resourceInfoServiceImpl;

    @PostMapping(value = "/add")
    public ResponseMessage<Boolean> addResource(@RequestBody ResourceInfoDto resourceInfoDto) {
        boolean result = resourceInfoServiceImpl.addResource(resourceInfoDto);
        return ResponseMessage.ok(result);
    }
}
