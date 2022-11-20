package com.daishuai.view.web.controller;

import com.daishuai.view.model.ResponseMessage;
import com.daishuai.view.web.dto.LoginUserDto;
import com.daishuai.view.web.service.ResourceInfoService;
import com.daishuai.view.web.service.UserInfoService;
import com.daishuai.view.web.vo.LoginUserVo;
import com.daishuai.view.web.vo.ResourceInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @description 权限
 * @createTime 2022-11-07 22:06:40
 */
@Slf4j
@RequestMapping(value = "/auth")
@RestController
public class AuthController {

    @Resource
    private UserInfoService userInfoServiceImpl;

    @Resource
    private ResourceInfoService resourceInfoServiceImpl;


    @PostMapping(value = "/login")
    public ResponseMessage<LoginUserVo> login(@RequestBody LoginUserDto loginUserDto) {
        LoginUserVo result = userInfoServiceImpl.queryUserByUsername(loginUserDto.getUsername());
        return ResponseMessage.ok(result);
    }

    @GetMapping(value = "/getUserInfo")
    public ResponseMessage<LoginUserVo> getUserInfo(@RequestParam("token") String token) {
        LoginUserVo result = userInfoServiceImpl.queryUserByUsername(token);
        List<ResourceInfoVo> resources = resourceInfoServiceImpl.queryResourceAsTree(token);
        result.setResources(resources);
        return ResponseMessage.ok(result);
    }

    @GetMapping(value = "/resources_as_tree")
    public ResponseMessage<List<ResourceInfoVo>> resourcesAsTree(@RequestParam("username") String username) {
        List<ResourceInfoVo> result = resourceInfoServiceImpl.queryResourceAsTree(username);
        return ResponseMessage.ok(result);
    }

    @GetMapping(value = "/resource_tree_me")
    public ResponseMessage<List<ResourceInfoVo>> queryResourceAsTree(@RequestParam("username") String username) {
        List<ResourceInfoVo> resourceTree = resourceInfoServiceImpl.queryResourceAsTree(username);
        return ResponseMessage.ok(resourceTree);
    }
}
