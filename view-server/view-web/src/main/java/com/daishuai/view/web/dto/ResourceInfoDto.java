package com.daishuai.view.web.dto;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @description 资源信息
 * @createTime 2022-11-17 21:49:39
 */
@Data
public class ResourceInfoDto {

    private String name;

    private String path;

    private String icon;

    private String title;

    private Integer sort;

    private String component;

    private String parent;

    private Boolean hideInBread;

    private Boolean hideInMenu;

    private Boolean status;

    private Long id;

    private String createdBy;

    private String updatedBy;

}
