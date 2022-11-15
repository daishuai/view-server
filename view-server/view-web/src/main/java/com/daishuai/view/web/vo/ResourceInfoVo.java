package com.daishuai.view.web.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 资源信息
 * @createTime 2022年11月14日 13:15:00
 */
@Data
public class ResourceInfoVo {

    private Long id;

    private String name;

    private String path;

    private String icon;

    private String title;

    private String component;

    private String parent;

    private Boolean hideInBread;

    private Boolean hideInMenu;

    private Boolean status;

    private List<ResourceInfoVo> children;
}
