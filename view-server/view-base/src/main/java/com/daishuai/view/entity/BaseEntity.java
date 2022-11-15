package com.daishuai.view.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 数据库基类
 * @createTime 2022年11月14日 10:26:00
 */
@Data
public class BaseEntity {

    private Long id;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;
}
