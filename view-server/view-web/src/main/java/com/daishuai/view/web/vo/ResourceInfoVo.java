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

    private Integer sort;

    private String component;

    private String parent;

    private Boolean status;

    private Meta meta;

    private List<ResourceInfoVo> children;

    @Data
    public static class Meta {

        private String title;

        private Boolean hideInMenu;

        private Boolean hideInBread;

        private String icon;
    }
}
