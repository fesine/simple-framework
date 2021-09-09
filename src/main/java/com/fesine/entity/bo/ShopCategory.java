package com.fesine.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/9
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/9
 */
@Data
public class ShopCategory {

    private Long shopCategoryId;

    private String shopCategoryName;

    private String shopCategoryDesc;

    private String shopCategoryImg;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    private ShopCategory parent;
}
