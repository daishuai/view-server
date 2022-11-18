package com.daishuai.view.entity;

import lombok.Data;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 资源信息
 * @createTime 2022年11月14日 12:11:00
 */
@Data
public class ResourceInfoEntity extends BaseEntity {

    private String name;

    private String path;

    private String icon;

    private String title;

    private Integer sort;

    private String component;

    private String parent;

    private Boolean notCache;

    private Boolean showAlways;

    private String href;

    private Boolean hideInBread;

    private Boolean hideInMenu;

    private Boolean status;
}
