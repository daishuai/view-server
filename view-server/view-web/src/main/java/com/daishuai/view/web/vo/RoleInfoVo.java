package com.daishuai.view.web.vo;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @description 角色信息
 * @createTime 2022-11-20 21:31:48
 */
@Data
public class RoleInfoVo {

    private String name;

    private String sign;

    private Integer sort;

    private Boolean status;
}
