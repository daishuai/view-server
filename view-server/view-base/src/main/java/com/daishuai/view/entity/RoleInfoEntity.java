package com.daishuai.view.entity;

import lombok.Data;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 角色信息
 * @createTime 2022年11月14日 10:27:00
 */
@Data
public class RoleInfoEntity extends BaseEntity{

    private String name;

    private String sign;

    private Integer sort;

    private Boolean status;
}
